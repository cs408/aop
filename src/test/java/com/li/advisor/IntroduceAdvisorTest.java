package com.li.advisor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.li.introduce.ForumService;
import com.li.introduce.Monitorable;
/**
 * ClassName: IntroduceAdvisorTest <br/>
 * Function: 
 * date: 2017年12月12日 <br/>
 *
 * @author prd-lxw
 * @version 1.0
 * @since JDK 1.7
 */
public class IntroduceAdvisorTest {

    @Test
	public void introduce() {
		String configPath = "com/li/advisor/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        ForumService forumService = (ForumService)ctx.getBean("forumService");
        forumService.removeForum(10);
        Monitorable moniterable = (Monitorable)forumService;//引介切面实现
        moniterable.setMonitorActive(true);
        forumService.removeForum(10);
	}
}
