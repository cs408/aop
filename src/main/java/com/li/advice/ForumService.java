package com.li.advice;

import java.sql.SQLException;

/**
 * ClassName: ForumService <br/>
 * Function: 模拟业务异常
 * date: 2017年12月12日 <br/>
 *
 * @author prd-lxw
 * @version 1.0
 * @since JDK 1.7
 */
public class ForumService {
	public void removeForum(int forumId) {
		// do sth...
		throw new RuntimeException("运行异常。");
	}
	public void updateForum(Forum forum) throws Exception{
		// do sth...
		throw new SQLException("数据更新操作异常。");
		
	}
}
