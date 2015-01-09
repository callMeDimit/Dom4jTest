package com.undergrowth.dom4j.test;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

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
	void validateXml();
	
	/**
	 * 获取根节点
	 * @return
	 */
	public Element getRoot();
	
	/**
	 * 获取根节点的所有子节点
	 * @return
	 */
	public List<?> getRootChildren(Node root);
}

