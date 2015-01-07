package com.undergrowth.dom4j;
/**
 * Dimit 2015年1月7日
 */
public class MainClass {
	public static void main(String[] args) {
		
		Dom4j_Test test = Dom4jTestFactory.getProxy();
		test.createXml("stus.xml");
		//使用根节点的方式获取节点元素
		test.readXmlNode("stus.xml");
		System.out.println("-----------------------------XPATH获取元素----------------");
		//使用xpath的方式读取元素
		test.readXPathNode("stus.xml");
	}
}

