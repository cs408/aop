package com.li.advisor;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * ClassName: GreetingBeforeAdvice <br/>
 * Function: 增强类
 * date: 2017年12月13日 <br/>
 *
 * @author prd-lxw
 * @version 1.0
 * @since JDK 1.7
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
	public void before(Method method, Object[] args, Object obj) throws Throwable {
		String clientName = (String)args[0];
		System.out.println(obj.getClass().getName()+"."+method.getName());
		System.out.println("How are you！Mr."+clientName+".");
	}
}
