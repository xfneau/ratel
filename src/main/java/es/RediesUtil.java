package es;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.pool.impl.GenericObjectPool.Config;


import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RediesUtil {
	
	private static ShardedJedisPool wpool = null;
	private static ShardedJedis wjedis = null;
	
	private static ShardedJedisPool pool = null;
	private static ShardedJedis jedis = null;
	

	
	public static void init(){
		try{
			Config redisConfig = new Config();
			pool = new ShardedJedisPool(redisConfig, Constant.readshards);
			
			Config redisConfig2 = new Config();
			wpool = new ShardedJedisPool(redisConfig2, Constant.writeshards);
			
//			jedis = pool.getResource();
//			String val = jedis.get("1001");//
//			pool.returnResource(jedis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void write(String key, String appkey, String value) {
		
//		String appid = "1001";
//		String value = "u1000_1_2_10_10_1000";//value = "accountid_alevel_appnum_eventnum_keynum_lognum"
		init();
		wjedis = wpool.getResource();
		wjedis.hset(key, appkey, value);
		wpool.returnResource(wjedis);
		
		
	}
	
public static void write(String key, String value) {
		
		init();
		wjedis = wpool.getResource();
		wjedis.set(key, value);
		wpool.returnResource(wjedis);
		
		
	}
	
	public static void read() {
		init();
		String key = "app_log_num";
		jedis = pool.getResource();
		Set<String> dses = jedis.hkeys(key);//
		pool.returnResource(jedis);
		
		if(dses!=null && dses.size()>0){
			for(String field:dses){
				//System.out.println(field);
				ShardedJedis jedis1 = pool.getResource();
				String val = jedis1.hget(key, field);
				pool.returnResource(jedis1);
				
				//System.out.println(val+"---------------");
			}
		}
	}
	
	public static String read(String key) {
		init();
		jedis = pool.getResource();
		String val = jedis.get(key);//
		pool.returnResource(jedis);
		
		return val;
	}
	
	private static void saveAppChannel(String appid,String serverid,String channel){
		init();
//		ShardedJedis wjedis = wpool.getResource();
//		wjedis.sadd(appid+"_c11", channel);
//		wpool.returnResource(wjedis);
		
		ShardedJedis wjedis2 = wpool.getResource();
		wjedis2.sadd(appid+"_s11", serverid);
		wpool.returnResource(wjedis2);
	}
	
	private static void saveAppSegmentChannel(String appid,String serverid,String channel) {
		init();
		ShardedJedis wjedis = wpool.getResource();
		wjedis.sadd(appid+"_c_segment", channel);
		wpool.returnResource(wjedis);
		
		ShardedJedis wjedis2 = wpool.getResource();
		wjedis2.sadd(appid+"_s_segment", serverid);
		wpool.returnResource(wjedis2);
	}
	
	public static List<String> readAppChannel(String appkey) {
		init();
		ShardedJedis j = pool.getResource();
		Set<String> set = j.smembers(appkey+"_c11");
		List<String> list = new ArrayList<String>(set);
		for (String s : list) {
			//System.out.println(s);
		}
		return list;
	}
	
	public static List<String> readAppServer(String appkey) {
		init();
		ShardedJedis j = pool.getResource();
		Set<String> set = j.smembers(appkey+"_s11");
		List<String> list = new ArrayList<String>(set);
		for (String s : list) {
			//System.out.println(s);
		}
		return list;
	}
	
	public static List<String> readAppSegmentServer(String appkey) {
		init();
		ShardedJedis j = pool.getResource();
		Set<String> set = j.smembers(appkey+"_s_segment");
		List<String> list = new ArrayList<String>(set);
		for (String s : list) {
			//System.out.println(s);
		}
		return list;
	}
	
	public static List<String> readAppSegmentChannel(String appkey) {
		init();
		ShardedJedis j = pool.getResource();
		Set<String> set = j.smembers(appkey+"_c_segment");
		List<String> list = new ArrayList<String>(set);
		for (String s : list) {
			//System.out.println(s);
		}
		return list;
	}
	
	public static void main(String[] srgs) {
//		saveAppChannel("1001","s4","91");
//		saveAppSegmentChannel("1001", "s2", "92");
//		//System.out.println("----------------channel");
//		readAppChannel("1001");
//		//System.out.println("----------------server");
//		readAppServer("1001");
//		//System.out.println("---------------segment-server");
//		readAppSegmentServer("1001");
//		//System.out.println("----------------segment-channel");
		
//		try{
//			Config redisConfig = new Config();
//			pool = new ShardedJedisPool(redisConfig, Constant.readshards);
//			
//			Config redisConfig2 = new Config();
//			wpool = new ShardedJedisPool(redisConfig2, Constant.writeshards);
//			
//			jedis = pool.getResource();
//			String val = jedis.get("d89d2792fac846197de9981d28d124dc_mysqlinfo");//
//			pool.returnResource(jedis);
//			//System.out.println(val);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		
		write("1001_mysqlinfo","192.168.2.241:3306;root;hoolai;0");
		//System.out.println(read("1001_mysqlinfo"));
	}

}
