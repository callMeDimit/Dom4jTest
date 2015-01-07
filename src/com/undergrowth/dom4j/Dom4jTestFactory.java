package com.undergrowth.dom4j;

import net.sf.cglib.proxy.Enhancer;


/**
 * Dimit 2015年1月7日
 */
public class Dom4jTestFactory {
	public static Dom4j_Test getProxy() {
		Enhancer en = new Enhancer();
		en.setSuperclass(Dom4j_Test.class);
		en.setCallback(new TestProxy());
		return (Dom4j_Test) en.create();
	}
}

