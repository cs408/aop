package com.li.proxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

/**
 * ClassName: ForumServiceTest <br/>
 * Function: JDK和CGLib动态代理测试
 * date: 2017年12月12日 <br/>
 *
 * @author prd-lxw
 * @version 1.0
 * @since JDK 1.7
 */
public class ForumServiceTest {

	/**
	 * proxy:业务类正常编码的测试
	 * 
	 * @since JDK 1.7
	 */
	@Test
	public void proxy() {
		ForumService forumService = new ForumServiceImpl();
		forumService.removeForum(10);
		forumService.removeTopic(1012);

	}

	/**
	 * testJdkProxy:使用JDK动态代理
	 * 
	 * @since JDK 1.7
	 */
	@Test
	public void testJdkProxy() {
		ForumService target = new ForumServiceImpl();
		PerformaceHandler handler = new PerformaceHandler(target);
		ForumService proxy = (ForumService) Proxy.newProxyInstance(target
				.getClass().getClassLoader(),
				target.getClass().getInterfaces(), handler);
		proxy.removeForum(10);
		proxy.removeTopic(1012);
	}

	/**
	 * testCGLibProxy:使用CGLib动态代理
	 * 
	 * @since JDK 1.7
	 */
	@Test
	public void testCGLibProxy() {
		CglibProxy cglibProxy = new CglibProxy();
		ForumService forumService = (ForumService) cglibProxy
				.getProxy(ForumServiceImpl.class);
		forumService.removeForum(10);
		forumService.removeTopic(1023);
	}

}
