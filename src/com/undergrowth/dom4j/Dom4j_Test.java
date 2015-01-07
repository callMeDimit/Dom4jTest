package com.undergrowth.dom4j;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4j_Test {

	// 以xpath的方式获取元素
	public void readXPathNode(String path) {
		Document document = parseXmlDocument(path);
		// 获取student元素
		List<?> stuList = document.selectNodes("//student");
		iteratorListElement(stuList);
		// 获取特定的元素
		// System.out.println("---------获取特定元素-------");
		List<Attribute> ageList = document.selectNodes("//age/@type");
		iteratorListAttribute(ageList);
	}

	// 迭代列表属性
	private void iteratorListAttribute(List<Attribute> ageList) {
		// for (Attribute object : ageList) {
		// System.out.println(object.asXML());
		// }
	}

	// 迭代列表元素
	private void iteratorListElement(List<?> stuList) {
		for (Iterator<?> iterator = stuList.iterator(); iterator.hasNext();) {
			Element stuElement = (Element) iterator.next();
			iteratorAttribute(stuElement);
			iteratorNextElement(stuElement);
		}
	}

	// 使用根节点的方式获取元素
	public void readXmlNode(String path) {
		Document document = parseXmlDocument(path);
		Element rootElement = document.getRootElement();
		// 遍历根元素的属性集合
//		iteratorAttribute(rootElement);
		// 遍历根元素的子元素
		for (Iterator<?> iterator = rootElement.elementIterator("student"); iterator
				.hasNext();) {
			Element stuElement = (Element) iterator.next();
			// 遍历元素的下一级元素
			iteratorNextElement(stuElement);
		}
	}

	// 迭代当前元素的下一级所有元素
	private void iteratorNextElement(Element stuElement) {
		Iterator<?> iterator2 = stuElement.elementIterator();
		while (iterator2.hasNext()) {
			Element nextElement = (Element) iterator2.next();
			// 判断元素是否有属性
			if (nextElement.attributeCount() != 0) {
				iteratorAttribute(nextElement);
			}
			// System.out.println(nextElement.getName()+"元素"+",值为"+nextElement.getText());
		}
	}

	// 迭代元素的属性
	private void iteratorAttribute(Element rootElement) {
		// System.out.println(rootElement.getName()+"元素");
		// for (Iterator<?> iterator = rootElement.attributeIterator();
		// iterator.hasNext();) {
		// Attribute type = (Attribute) iterator.next();
		// System.out.println(type.getName()+":"+type.getText()+"\t");

		// }
	}

	// 解析返回一个文档对象
	private Document parseXmlDocument(String path) {
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(new File(path));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return document;
	}

	// 创建xml文件
	public void createXml(String path) {
		Document document = createDocument();
		writeXml(path, document);
	}

	// 将document写入到输出文件中
	private static void writeXml(String path, Document document) {
		// 为输出流创建格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new FileWriter(path), format);
			// 将document写入到文件中
			writer.write(document);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 创建document
	private static Document createDocument() {
		Document document = DocumentHelper.createDocument();
		// 在document中创建根元素students
		Element rootElement = document.addElement("students","http://www.sitemaps.org/schemas/sitemap/0.9");
		rootElement.addNamespace("xsi","http://www.w3.org/2001/XMLSchema-instance");
		rootElement.addAttribute("xsi:schemaLocation","http://www.sitemaps.org/schemas/sitemap/0.9 http://www.sitemaps.org/schemas/sitemap/0.9/sitemap.xsd");
		rootElement.addAttribute("name", "基础与信息工程学院");
		rootElement.addComment("人数总数");
		rootElement.addAttribute("count", "2");

		// 添加student信息
		Element stuElement = rootElement.addElement("student");
		stuElement.addElement("name").addText("刘德华");
		stuElement.addElement("age").addAttribute("type", "int").addText("28");
		// 添加student信息
		Element stuElement2 = rootElement.addElement("student");
		stuElement2.addElement("name").addText("黎明");
		stuElement2.addElement("age").addText("54");
		// 添加student信息
		Element stuElement3 = rootElement.addElement("student");
		stuElement3.addElement("name").addText("黎明");
		stuElement3.addElement("age").addText("54");// 添加student信息
		Element stuElement4 = rootElement.addElement("student");
		stuElement4.addElement("name").addText("黎明");
		stuElement4.addElement("age").addText("54");// 添加student信息
		return document;
	}

}
