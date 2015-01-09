package com.undergrowth.dom4j.test;

import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;

/**
 * Dimit 2015年1月8日
 */
public class MainClass {
	public static void main(String[] args) {
		XmlReader readXml = ReadXmlFactorry.getInstance(ReadTestXmlByDom.class);
//		Document doc = readXml.readXml();
//		readXml.validateXml(doc);
//		Node root = readXml.getRoot();
		
		//--------------xpath--------------------
		readXml = ReadXmlFactorry.getInstance(ReadTestXmlByXpath.class);
		Document doc = readXml.readXml();
		readXml.validateXml();
		
		System.out.println(doc.selectNodes("//person[@attr1='aaa']"));
	}
	
	public static void print(Element ele) {
		System.out.println("元素名称：" + ele.getName());
		System.out.println("属性个数：" + ele.attributeCount());
	}
	
	public static void print(List<Element> eles) {
		for(Object e : eles) {
			print((Element) e);
		}
	}
	
	public static void printAllAttr(Element ele) {
		List<?> attrs = ele.attributes();
		for(Object o : attrs) {
			System.out.println(((Attribute)o).getName());
		}
	}
}
