package es;

import java.io.IOException;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;


public class ESURL {
	
	public static void main(String[] args){
		
		HttpClient client = new DefaultHttpClient();
		String url = "http://192.168.2.33:9200/grade/class/_search?pretty";
		HttpPost post = new HttpPost(url);
		post.setHeader("Content-Type", "application/json;charset=utf8");
		
		try {
			HttpResponse response = client.execute(post);
			String res = EntityUtils.toString(response.getEntity());
			JSONObject jb = new JSONObject(res);
			JSONArray hit = jb.getJSONObject("hits").getJSONArray("hits");
			for( int i = 0; i < hit.length(); i++ ){
				JSONObject source = new JSONObject(hit.getJSONObject(i).getString("_source"));
				JSONObject name = new JSONObject(source.getString("name"));
				
				System.out.println("name:{"+source.getString("age")+":"+name.getString(source.getString("age"))+"}");
				System.out.println("height:"+source.getString("height"));
				System.out.println("age:"+source.getString("age"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
