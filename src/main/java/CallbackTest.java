//
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.TreeMap;
//
//import org.junit.Test;
//
//import com.alibaba.fastjson.JSONObject;
//import com.reyun.track.callback.Callback;
//import com.reyun.track.callback.Param;
//import com.reyun.track.callback.URL;
//
//
//public class CallbackTest {
//
//	public static void main(String[] args) throws Exception {
//		
//		URL url = new URL();
//		List<Param> params = new ArrayList<Param>();
//		Callback cb = new Callback();
//		url.setUrl("http://d.ad-mex.com/match");
////		url.setIsparam(true);
////		url.setKey("callback");
////		Param param = new Param();
////		param.setKey("appkey");
////		param.setVar("bundleid");
//		Param param0 = new Param();
//		param0.setKey("clickid");
//		param0.setVar("clickid");
//		params.add(param0);
////		Param param1 = new Param();
////		param1.setKey("mac");
////		param1.setVar("mac");
////		param1.setFormat( Class.forName("com.reyun.track.callback.Format").getMethod("upperCase",String.class) );
////		params.add(param1);
//		Param param2 = new Param();
//		param2.setKey("idfa");
//		param2.setVar("idfa");
////		param2.setFormat( Class.forName("com.reyun.track.callback.Format").getMethod("upperCase",String.class) );
//		params.add(param2);
////		Param param3 = new Param();
////		param3.setKey("acttype");
////		param3.setValue("1");
////		params.add(param3);
////		Param param4 = new Param();
////		param4.setKey("sign");
////		param4.setFormat( Class.forName("com.reyun.track.callback.Format").getMethod("domobSign",Map.class) );
////		params.add(param4);
////		Param param5 = new Param();
////		param5.setKey("acttime");
////		param5.setVar("when");
////		param5.setFormat( Class.forName("com.reyun.track.callback.Format").getMethod("when2Long",String.class) );
////		params.add(param5);
//		Param param6 = new Param();
//		param6.setKey("source");
//		param6.setValue("reyun");
//		params.add(param6);
////		cb.setUrl(url);
////		cb.setParams(params);
//		Map json = new HashMap();
//		json.put("channelname", "ad-mex");
//		json.put("appid", "2");
//		json.put("when", "2015-03-19 12:30:49");
//		json.put(
//				"clickparams",
//				"&bundleid=bundleid&ip=ip&mac=mac&openudid=openudid&idfa=idfa&callback=http%3a%2f%2fapi.mix.guohead.com%2fwall%2factive_callback%3fappid%3d463700550%26code%3d017%26mac%3d02%3a00%3a00%3a00%3a00%3a00%26idfa%3dCC08A07F-90FA-4BC3-A824-08B8B0307A3D");
//		JSONObject jsonstr = (JSONObject) JSONObject.toJSON(json);
//		System.out.println( cb.callback(jsonstr) );
//		
//	}
//
//	@Test
//	public void test() throws Exception{
//		int a = 1, b = 1;
//		System.out.println("ans:"+a/b);
//		Map<String,Integer> map = new HashMap<String,Integer>();
//		map.put("2", 2);
//		map.put("1", 1);
//		map.put("3", 3);
//		map.put("4", 4);
//		for( String i:map.keySet() ){
//			System.out.println( i+":"+map.get(i) );
//		}
//	}
//}
