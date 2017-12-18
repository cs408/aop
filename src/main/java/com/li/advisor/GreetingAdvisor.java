package com.li.advisor;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

/**
 * ClassName: GreetingAdvisor <br/>
 * Function: 静态普通方法名匹配切面
 * date: 2017年12月12日 <br/>
 *
 * @author prd-lxw
 * @version 1.0
 * @since JDK 1.7
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {

	/**
	 * 切点方法匹配规则：方法名为greetTo
	 * @see org.springframework.aop.MethodMatcher#matches(java.lang.reflect.Method, java.lang.Class)
	 */
	public boolean matches(Method method, Class clazz) {
		return "greetTo".equals(method.getName());
	}	
	/**
	 * 切点类匹配规则：Waiter的类或者子类
	 * @see org.springframework.aop.support.StaticMethodMatcherPointcut#getClassFilter()
	 */
	public ClassFilter getClassFilter(){
		return new ClassFilter(){
			public boolean matches(Class clazz){
				return Waiter.class.isAssignableFrom(clazz);
			}
		};
		
	}
}
