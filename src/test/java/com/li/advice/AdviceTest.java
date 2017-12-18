package com.li.advice;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdviceTest {

	@Test
	public void adviceBefore() {
		String configPath = "com/li/advice/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter waiter = (Waiter)ctx.getBean("waiterBefore");
		waiter.greetTo("John");
	}
	
	/**
	 * adviceAB:前置和后置增强联合
	 * @since JDK 1.7
	 */
	@Test
	public void adviceAB() {
		String configPath = "com/li/advice/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter waiter = (Waiter)ctx.getBean("waiterAB");
		waiter.greetTo("John");
	}
	
	/**
	 * adviceAround:环绕增强是前置和后置增强的联合
	 * @since JDK 1.7
	 */
	@Test
	public void adviceAround() {
		String configPath = "com/li/advice/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter waiter = (Waiter)ctx.getBean("waiterAround");
		waiter.greetTo("John");
	}
	
}
