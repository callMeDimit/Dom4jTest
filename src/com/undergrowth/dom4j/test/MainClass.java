package com.undergrowth.dom4j.test;

import org.dom4j.Document;

/**
 * Dimit 2015年1月8日
 */
public class MainClass {
	public static void main(String[] args) {
		XmlReader readXml = ReadXmlFactorry.getInstance(ReadTestXmlByDom.class);
		Document doc = readXml.readXml();
		readXml.validateXml(doc);
		readXml = ReadXmlFactorry.getInstance(ReadTestXmlByXpath.class);
		readXml.readXml();
		readXml.validateXml(doc);
	}
}
