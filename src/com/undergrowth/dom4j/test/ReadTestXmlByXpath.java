package com.undergrowth.dom4j.test;

import java.util.List;

import org.dom4j.Element;
import org.dom4j.Node;

/**
 * Dimit 2015年1月8日 通过xpath方式读取节点
 */
public class ReadTestXmlByXpath extends AbstractXmlReader {

	@Override
	public Element getRoot() {
		return (Element) this.doc.selectSingleNode(XmlElementContants.FROMROOT
				+ XmlElementContants.ROOT);
	}

	@Override
	public List<?> getRootChildren(Node root) {
		return root.selectNodes(XmlElementContants.ROOT);
	}

}
