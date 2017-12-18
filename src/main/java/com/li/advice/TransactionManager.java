package com.li.advice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

/**
 * ClassName: TransactionManager <br/>
 * Function: 异常增强类
 * date: 2017年12月12日 <br/>
 *
 * @author prd-lxw
 * @version 1.0
 * @since JDK 1.7
 */
public class TransactionManager implements ThrowsAdvice {
	/**
	 * afterThrowing:定义增强逻辑，必须采用以下签名形式定义
	 * 前三个入参要么提供，要么不提供
	 * @param method
	 * @param args
	 * @param target
	 * @param ex
	 * @throws Throwable
	 * @since JDK 1.7
	 */
	public void afterThrowing(Method method, Object[] args, Object target,
			Exception ex) throws Throwable {
		System.out.println("-----------");
		System.out.println("method:" + method.getName());
		System.out.println("抛出异常:" + ex.getMessage());
		System.out.println("成功回滚事务。");
	}
}
