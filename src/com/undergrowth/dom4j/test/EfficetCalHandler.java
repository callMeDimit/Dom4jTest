package com.undergrowth.dom4j.test;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Dimit 2015年1月8日
 */
public class EfficetCalHandler implements MethodInterceptor{

	@Override
	public Object intercept(Object arg0, Method method, Object[] arg2,
			MethodProxy methodProxy) throws Throwable {
		EfficetCal anno = method.getAnnotation(EfficetCal.class);
		Object rel = null;
		if(anno != null ) {
			long start = System.currentTimeMillis();
			rel = methodProxy.invokeSuper(arg0, arg2);
			long end = System.currentTimeMillis();
			System.out.println(arg0.getClass().getSuperclass().getSimpleName()+"-->" + method.getName() +"执行时间:"+(end - start));
			return rel;
		}
		return methodProxy.invokeSuper(arg0, arg2);
	}

}

