package com.li.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * ClassName: GreetingBeforeAdvice <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2017年12月12日 <br/>
 *
 * @author prd-lxw
 * @version 1.0
 * @since JDK 1.7
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
	/**
	 * 在目标类方法调用前执行
	 * @see org.springframework.aop.MethodBeforeAdvice#before(java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
	 */
	public void before(Method method, Object[] args, Object obj) throws Throwable {
		String clientName = (String)args[0];
		System.out.println("How are you！Mr."+clientName+".");
	}
}
