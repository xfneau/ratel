import java.net.URLEncoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;


/**
 * API工具类
 * 
 * @author Administrator
 */
public class APITools {

	private static String HmacMD5 = "HmacMD5";
	
	private static String HOST = "http://125.39.26.229";//"http://game.reyun.com";

	/**
	 * 生成签名数据
	 * 
	 * @param message
	 *            待加密的数据
	 * @param key
	 *            加密使用的key
	 * python版：
	 *  >>> import hmac
	 *	>>> hmac.new(key,message).hexdigest()
	 */
	public static String hmacMd5Encode(String key, String message)
			throws Exception {
		SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), HmacMD5);
		Mac mac = Mac.getInstance(HmacMD5);
		mac.init(keySpec);
		byte[] rawHmac = mac.doFinal(message.getBytes());
		return Hex.encodeHexString(rawHmac);
	}

	/**
	 * 请求含appID的一段时间内的数据
	 * @param uri 请求方法名
	 * @param method  HTTP请求方式
	 * @param appID 游戏APPID
	 * @param openID 生成的openID
	 * @param openKey 生成的openKey
	 * @param startTime 数据起始时间
	 * @param endTime 数据截止时间
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String getURL(String uri, String method, String appID,
			String openID, String openKey, String startTime, String endTime) {
		
		StringBuffer host = new StringBuffer(HOST);
		String message = "";
		String sign = "";
		StringBuffer URL = new StringBuffer();
		message = method + "&"
				+ URLEncoder.encode(uri) + "&"
				+ URLEncoder.encode("appID=" + appID + "&endTime=" + endTime
						+ "&openID=" + openID + "&startTime=" + startTime);
		try {
			sign = APITools.hmacMd5Encode(openKey, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		URL = host.append(uri).append("?").append("appID=").append(appID)
				  .append("&endTime=").append(endTime).append("&openID=")
				  .append(openID).append("&startTime=").append(startTime).append("&sign=").append(sign); 
		return URL.toString();
	}

	/**
	 * 请求含appID不带时间参数的数据
	 * @param uri 请求方法名
	 * @param method  HTTP请求方式
	 * @param appID 游戏APPID
	 * @param openID 生成的openID
	 * @param openKey 生成的openKey
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String getURL(String uri, String method, String appID,
			String openID, String openKey) {
		
		StringBuffer host = new StringBuffer(HOST);
		String message = "";
		String sign = "";
		StringBuffer URL = new StringBuffer();
		message = method + "&"
				+ URLEncoder.encode(uri) + "&"
				+ URLEncoder.encode("appID=" + appID + "&openID=" + openID );
		try {
			sign = APITools.hmacMd5Encode(openKey, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		URL = host.append(uri).append("?").append("appID=").append(appID)
				  .append("&openID=").append(openID).append("&sign=").append(sign); 
		return URL.toString();
	}

	/**
	 * 请求不含appID且不带时间参数的数据
	 * @param uri
	 * @param method
	 * @param openID
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String getURL(String uri, String method, String openID, String openKey ){
		
		StringBuffer host = new StringBuffer(HOST);
		String message = "";
		String sign = "";
		StringBuffer URL = new StringBuffer();
		message = method + "&"
				+ URLEncoder.encode(uri) + "&"
				+ URLEncoder.encode( "openID=" + openID );
		try {
			sign = APITools.hmacMd5Encode(openKey, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		URL = host.append(uri).append("?").append("openID=").append(openID).append("&sign=").append(sign); 
		return URL.toString();
	}
	
	public static void main(String[] args) {
		String appID = "982da2ae92188e5f73fbf7f82e41ed65";//"02d29c7ba100b4c7c2d57d4baa5509ae";//982da2ae92188e5f73fbf7f82e41ed65";
		String openID = "3a8980bbcd74640c1fbd38f1bf7169da";//"b8fbab3b43c7f36f36f27df3c5863bcd";
		String openKey = "27a51ce964b9972cc478677130bab32f";//"9bd263462bc57a880db5158ad8ee7942";
		String startTime = "2014-09-25";
		String endTime = "2014-10-07";
		String method = "GET";
		String uri = "/apigetChannelList";
		String URL = getURL(uri,method,appID,openID,openKey);
		System.out.println(URL);	
	}

}
