package com.undergrowth.dom4j.test;

import java.util.List;

import org.dom4j.Element;
import org.dom4j.Node;

/**
 * Dimit 2015年1月8日
 * 通过root读取xml
 */
public class ReadTestXmlByDom extends AbstractXmlReader {

	@Override
	public Element getRoot() {
		return doc.getRootElement();
	}

	@Override
	public List<?> getRootChildren(Node root) {
		return null;
	}
	
}
