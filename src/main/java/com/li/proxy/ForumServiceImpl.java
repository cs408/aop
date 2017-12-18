package com.li.proxy;

/**
 * ClassName: ForumServiceImpl <br/>
 * Function: 包含性能监视的横切代码
 * date: 2017年12月12日  <br/>
 *
 * @author prd-lxw
 * @version 1.0
 * @since JDK 1.7
 */
public class ForumServiceImpl implements ForumService {

	public void removeTopic(int topicId) {
//		PerformanceMonitor.begin("com.smart.proxy.ForumServiceImpl.removeTopic");
		System.out.println("模拟删除Topic记录:"+topicId);
		try {
			Thread.sleep(20);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
//		PerformanceMonitor.end();
	}

	public void removeForum(int forumId) {
//		PerformanceMonitor.begin("com.smart.proxy.ForumServiceImpl.removeForum");
		System.out.println("模拟删除Forum记录:"+forumId);
		try {
			Thread.sleep(40);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
//		PerformanceMonitor.end();
	}
}
