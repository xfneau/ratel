import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpCookie;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.mortbay.jetty.HttpStatus;


public class hello {

	Logger log = Logger.getLogger(hello.class);
	public static void main(String[] args){
		int total = 4;
		int cut = 8;
		int sum;
		int now = 0;
		List<Integer> list = new ArrayList<Integer>();
		for( int i = 1; i <= 4; i++ ){
			list.add(i);
		}
		while( list.size() > 0 && total != 0 ){
			sum = cut%total;
			if( sum == 0 ){
				sum += total;
			}
			if( now+sum > list.size() ){
				now = sum - (list.size()-now)-1;
			}else{
				now = now + sum-1;
			}
			total--;
			System.out.println(list.get(now));
			list.remove(now);
		}
	}
	//  1  2 3 
	
	public static boolean getFile(String destFileName){
		File file = new File(destFileName);  
        if(file.exists()) {  
            System.out.println("创建单个文件" + destFileName + "失败，目标文件已存在！");  
            return false;  
        }  
//        System.out.println(File.separator);
        if (destFileName.endsWith(File.separator)) {  
            System.out.println(File.separator+"  创建单个文件" + destFileName + "失败，目标文件不能为目录！");  
            return false;  
        }  
        //判断目标文件所在的目录是否存在  
        System.out.println(file.getParentFile());
        if(!file.getParentFile().exists()) {  
            //如果目标文件所在的目录不存在，则创建父目录  
            System.out.println("目标文件所在目录不存在，准备创建它！");  
            if(!file.getParentFile().mkdirs()) {  
                System.out.println("创建目标文件所在目录失败！");  
                return false;  
            }  
        }  
        //创建目标文件  
        try {  
            if (file.createNewFile()) {  
                System.out.println("创建单个文件" + destFileName + "成功！");  
                return true;  
            } else {  
                System.out.println("创建单个文件" + destFileName + "失败！");  
                return false;  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
            System.out.println("创建单个文件" + destFileName + "失败！" + e.getMessage());  
            return false;  
        }  
	}
	public static Boolean judgeTime(String startTime,String endTime){
		double limit =  90.0;
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			long temp = sdf.parse(endTime).getTime() - sdf.parse(startTime).getTime();
			if( temp/(limit* 24 * 60 * 60 * 1000) > 1.0 || temp/(limit* 24 * 60 * 60 * 1000) < 0){
				return false;
			}				
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
}
