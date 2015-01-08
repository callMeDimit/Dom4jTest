package com.undergrowth.dom4j.test;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * Dimit 2015年1月8日
 * 通过xpath方式读取节点
 */
public class ReadTestXmlByXpath extends AbstractXmlReader {
	@Override
	@EfficetCal
	public Document readXml() {
		Document doc = constructDoc(XmlReader.PATH);
		List<?> nodes = doc.selectNodes("//note");
		for(Object n : nodes) {
			System.out.println(((Element)n).getName());
		}
		return doc;
	}
	
	/**
	 * 构造document对象
	 * 
	 * @param path
	 *            xml文件路径
	 * @return {@link org.dom4j.Document}
	 */
	private Document constructDoc(String path) {
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(new File(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return document;
	}
}

