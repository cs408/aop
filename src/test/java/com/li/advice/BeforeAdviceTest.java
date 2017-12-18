package com.li.advice;

import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class BeforeAdviceTest {

	@Test
	public void before() {
		Waiter target = new NaiveWaiter();
		BeforeAdvice advice = new GreetingBeforeAdvice();
		ProxyFactory pf = new ProxyFactory();// spring提供的代理工厂
		pf.setInterfaces(target.getClass().getInterfaces());// 指定对接口进行代理
		pf.setTarget(target);// 设置代理目标
//		pf.addAdvice(0, advice);
		pf.addAdvice(advice);// 为代理目标添加增强
		// pf.setOptimize(true);//启用优化，CGLib动态代理
		Waiter proxy = (Waiter) pf.getProxy();// 生产代理实例
		proxy.greetTo("John");
		proxy.serveTo("Tom");
	}

}
