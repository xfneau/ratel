package redis;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import redis.clients.jedis.JedisShardInfo;

public class Constant {
	
	/**
	 * 写入
	 */
	public static List<JedisShardInfo> writeShards = new ArrayList<JedisShardInfo>();
	
	static{
		ResourceBundle bw = ResourceBundle.getBundle("redis");
		String write = bw.getString("writeredis");
		String[] sw = write.split(":");
		int portW = Integer.valueOf(sw[1]);
		String ipW = sw[0];
		writeShards.add(new JedisShardInfo(ipW,portW));
	}
	
	/**
	 * 读出
	 */
	static List<JedisShardInfo> readredis = new ArrayList<JedisShardInfo>();
	
	static{
		ResourceBundle br = ResourceBundle.getBundle("redis");
		String read = br.getString("readredis");
		String[] sr = read.split(":");
		int portR = Integer.valueOf(sr[1]);
		String ipR = sr[0];
		readredis.add(new JedisShardInfo(ipR,portR));
		
	}
	

}
