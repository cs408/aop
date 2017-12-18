package com.li.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ClassName: PerformaceHandler <br/>
 * Function: JDK动态代理InvocationHandler类
 * date: 2017年12月12日 <br/>
 *
 * @author prd-lxw
 * @version 1.0
 * @since JDK 1.7
 */
public class PerformaceHandler implements InvocationHandler {
    private Object target; //目标业务类
	public PerformaceHandler(Object target){
		this.target = target;
	}
	/**
	 * 实现invoke方法，方法中加入横切逻辑代码
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		PerformanceMonitor.begin(target.getClass().getName()+"."+ method.getName());
		Object obj = method.invoke(target, args);//通过反射调用业务类的目标方法
		PerformanceMonitor.end();
		return obj;
	}
}
