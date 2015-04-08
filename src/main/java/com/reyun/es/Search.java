package com.reyun.es;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Search {

	
	static String url = "http://localhost:9200/grade/_search?pretty&ignore_unavailable=true";//"http://125.39.26.229/apigetGameList?openID=b8fbab3b43c7f36f36f27df3c5863bcd&sign=097137b7c4261f70eca76c1a230db1bc";
	static String sql = "{\"query\": { \"match_all\": {} },\"size\": 100}";
	public static void main(String[] args) {
		
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
//		HttpGet post = new HttpGet(url);
		post.setHeader("Content-Type", "application/json;charset=utf8");
		
		StringEntity se;
		String result = "";
		try{
			se = new StringEntity("", "application/json", "UTF-8");
			post.setEntity(se);
			HttpResponse response = client.execute(post);
			result = EntityUtils.toString(response.getEntity());
			JSONObject json = new JSONObject(result);
			System.out.println(result);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
