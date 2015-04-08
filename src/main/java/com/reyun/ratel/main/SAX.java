package com.reyun.ratel.main;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class SAX {
	
	public static void main(String[] args){
		SAXReader sax = new SAXReader();
		try {
			Document doc = sax.read(new File("F:/a.xml"));
			Element ele = doc.getRootElement();
			System.out.println(ele.element("qq").getTextTrim());
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
