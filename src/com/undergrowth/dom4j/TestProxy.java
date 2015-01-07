package com.undergrowth.dom4j;

import java.lang.reflect.Method;

import com.undergrowth.dom4j.util.StringUtils;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Dimit 2015年1月7日
 */
public class TestProxy implements MethodInterceptor {
	private static final String[] METHODNAME = { "readXmlNode", "readXPathNode","createXml"};

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		Object rel = null;
		if (StringUtils.containStr(METHODNAME, arg1.getName(), false)) {
			long start = System.currentTimeMillis();
			rel = arg3.invokeSuper(arg0, arg2);
			System.out.println(arg1.getName() + "执行时间（毫秒）："+(System.currentTimeMillis() - start));
		} else {
			rel = arg3.invokeSuper(arg0, arg2);
		}
		return rel;
	}
}
