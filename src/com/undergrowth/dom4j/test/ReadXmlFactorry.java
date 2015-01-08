package com.undergrowth.dom4j.test;

import net.sf.cglib.proxy.Enhancer;

/**
 * Dimit 2015年1月8日
 */
public class ReadXmlFactorry {
	public static XmlReader getInstance(Class<?> clz){
		Enhancer en = new Enhancer();
		en.setSuperclass(clz);
		en.setCallback(new EfficetCalHandler());
		return (XmlReader) en.create();
	}
}

