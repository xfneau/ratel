package redis;


import java.util.List;

import org.apache.commons.pool.impl.GenericObjectPool.Config;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class Redis {
	
	private static ShardedJedisPool wpool=null;
	private static ShardedJedis wjedis=null;
	
	private static ShardedJedisPool rpool = null;
	private static ShardedJedis rjedis = null;
	
	public static void init(){
		try{
			
			Config redisconfig = new Config();
			wpool = new ShardedJedisPool(redisconfig,Constant.writeShards);
			
			Config redisconfig1 = new Config();
			rpool = new ShardedJedisPool(redisconfig1,Constant.readredis);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static void write(String key, String segmentkey, String value ){
		init();
		wjedis = wpool.getResource();
		wjedis.hset(key, segmentkey, value);
		wpool.returnResource(wjedis);
	}
	
	public static void write(String key, String value ){
		init();
		wjedis = wpool.getResource();
		wjedis.rpush(key,value);
		wpool.returnResource(wjedis);
	}
	
	public static void write(String key, List<String> value ){
		init();
		wjedis = wpool.getResource();
		for( int i = 0; i < value.size(); i++ ){
			wjedis.lpush(key, value.get(i));
		}
		wpool.returnResource(wjedis);
	}
	
	public static String read(String key, String segmentkey ){
		init();
		rjedis = rpool.getResource();
		String v = rjedis.hget(key, segmentkey );
		rpool.returnResource(rjedis);
		return v;
	}
	
	public static String read(String key ){
//		init();
		Jedis jedis = new Jedis("127.0.0.1",6379);
		List<String> v = jedis.blpop(0,key);
		for( String str : v ){
			System.out.println(str);
		}
		return v.get(1);
	}
	
	public static void main(String[] args){
		write("list","2");
		write("list","1");
		write("list","3");
		write("list","4");
		System.out.println(read("list"));
	}

}
