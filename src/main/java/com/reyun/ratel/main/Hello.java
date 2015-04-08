package com.reyun.ratel.main;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;



public class Hello implements Runnable{

	@SuppressWarnings("unchecked")
	public static void main(String[] args)throws Exception {
		
		TransportClient transport = new TransportClient();
		transport.addTransportAddress(new InetSocketTransportAddress("127.0.0.1",9300));
		Client client = transport;
		
		SimpleDateFormat simple = new SimpleDateFormat("YYYY-MM-dd");
		Date date = new Date();
		
		Calendar time = Calendar.getInstance();
		time.add(Calendar.DATE,-1);
		System.out.println(  time.getTime() );
		List list = new ArrayList();
		Collections.sort(list, new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		});
	}
	public static String hmacMd5Encode(String key, String message) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec( key.getBytes(),"HmacMD5");
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(keySpec);
        byte[] rawHmac = mac.doFinal(message.getBytes());
        return Hex.encodeHexString(rawHmac);
    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public synchronized void test(){
		
	}

	
}
