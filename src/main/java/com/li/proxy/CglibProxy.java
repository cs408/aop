package com.li.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {
	private Enhancer enhancer = new Enhancer();

	/**
	 * getProxy:为一个类创建动态代理对象，通过扩展clazz实现代理
	 * @param clazz
	 * @return
	 * @since JDK 1.7
	 */
	public Object getProxy(Class clazz) {
		enhancer.setSuperclass(clazz);//设置需要创建子类的类
		enhancer.setCallback(this);
		return enhancer.create();//通过字节码技术动态创建子类实例
	}

	/**
	 * 拦截父类所有方法的调用 在拦截方法中织入横切逻辑代码
	 * @see net.sf.cglib.proxy.MethodInterceptor#intercept(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], net.sf.cglib.proxy.MethodProxy)
	 */
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		PerformanceMonitor.begin(obj.getClass().getName()+"."+method.getName());
		Object result=proxy.invokeSuper(obj, args);// 通过代理类调用父类中的方法
		PerformanceMonitor.end();
		return result;
	}
}
