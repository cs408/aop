package com.li.autoproxy;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.li.advisor.Seller;
import com.li.advisor.Waiter;
/**
 * ClassName: AutoProxyCreatorTest <br/>
 * Function: 基于Bean名称 基于Advisor的自动代理
 * date: 2017年12月13日 <br/>
 *
 * @author prd-lxw
 * @version 1.0
 * @since JDK 1.7
 */
public class AutoProxyCreatorTest {

	@Test
	public void autoProxyBeanNamesTest() {
		String configPath = "com/li/autoproxy/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter waiter = (Waiter) ctx.getBean("waiter");
		Seller seller = (Seller) ctx.getBean("seller");
		waiter.serveTo("John");
		waiter.greetTo("John");
		seller.greetTo("Tom");
	}
	
	@Test
	public void autoProxyAdvisorTest() {
		String configPath = "com/li/autoproxy/beans-advisor.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter waiter = (Waiter) ctx.getBean("waiter");
		Seller seller = (Seller) ctx.getBean("seller");
		waiter.serveTo("John");
		waiter.greetTo("John");
		seller.greetTo("Tom");
	}
	

}
