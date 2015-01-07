package com.undergrowth.dom4j.bean;

import java.lang.reflect.Field;

/**
 * Dimit 2015年1月7日
 */
public class Main {
	public static void main(String[] args) throws NoSuchFieldException,
			SecurityException, Exception, IllegalAccessException {
		Bean bean = new Bean(1);
		Class<?> clz = Bean.class;
		Field idField = clz.getDeclaredField("id");
		idField.setAccessible(true);
		System.out.println(idField.getInt(bean));
	}
}
