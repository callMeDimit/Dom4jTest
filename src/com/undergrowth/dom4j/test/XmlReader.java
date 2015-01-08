package com.undergrowth.dom4j.test;

import org.dom4j.Document;

/**
 * Dimit 2015年1月8日
 */
public interface XmlReader {
	public static final String PATH = "test.xml";
	public static final String XSDPATH = "test.xsd";
	/**
	 * 读取xml
	 */
	Document readXml();
	
	/**
	 * 根据shcema验证xml文件的合法性
	 * @param doc
	 */
	void validateXml(Document doc);
}

