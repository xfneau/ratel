package es;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import redis.clients.jedis.JedisShardInfo;

public class Constant {

	public static String WARNCOMPARE="较昨日";
	public static String IS="为";
	
	public static List<JedisShardInfo> writeshards = new ArrayList<JedisShardInfo>();
	public static List<String> mailList = new ArrayList<String>();
	static{

		ResourceBundle b = ResourceBundle.getBundle("redis");
		String write = b.getString("writeredies");
		String[] ss = write.split(",");
		for (String s : ss) {
			String[] rs = s.split(":");
			String ip = rs[0];
			int port = Integer.valueOf(rs[1]);
			writeshards.add(new JedisShardInfo(ip, port));
		}
		//writeshards.add(new JedisShardInfo("redis-1", 6379));
		

		//writeshards.add(new JedisShardInfo("192.168.86.84", 6380));
		//writeshards.add(new JedisShardInfo("192.168.1.142", 6380));
		//writeshards.add(new JedisShardInfo("192.168.1.143", 6380));
		ResourceBundle mb = ResourceBundle.getBundle("mail");
		String list = mb.getString("mail_list");
		String[] ll = list.split(",");
		for (String mail : ll) {
			mailList.add(mail);
		}
	};
	
	public static List<JedisShardInfo> readshards = new ArrayList<JedisShardInfo>();
	static{

		ResourceBundle b = ResourceBundle.getBundle("redis");
		String read = b.getString("readredies");
		String[] ss = read.split(",");
		for (String s : ss) {
			String[] rs = s.split(":");
			String ip = rs[0];
			int port = Integer.valueOf(rs[1]);
			readshards.add(new JedisShardInfo(ip, port));
		}
		//readshards.add(new JedisShardInfo("redis-2", 6379));

		//readshards.add(new JedisShardInfo("192.168.86.84", 6381));
		//readshards.add(new JedisShardInfo("192.168.1.141", 6381));
		//readshards.add(new JedisShardInfo("192.168.86.84", 6382));
		//readshards.add(new JedisShardInfo("192.168.1.141", 6382));
		//readshards.add(new JedisShardInfo("192.168.1.143", 6382));
	};
	
	public static String splitStr = "/003/004";
	public static String COOKIE_USERNAME = "REYUN_USERNAME";
	public static String COOKIE_APP = "REYUN_APP";
	public static String SESSION_KEY = "USER_SESSION";
	public static String SESSION_APP = "APP_SESSION";
	
	public static String CHANNEL_SESSION_KEY = "CHANNEL_USER_SESSION";
	public static String CHANNEL_SESSION_APP = "CHANNEL_APP_SESSION";
	
	public static String CHANNEL_COOKIE_USERNAME = "CHANNEL_USERNAME";
	
	public static String APP_WARNNUMBER="10";
	public static String APP_WARNEDNUMBER="100";
	

}
