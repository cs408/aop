package com.li.advice;

public interface Waiter {
	/**
	 * greetTo:欢迎顾客
	 * 
	 * @param name
	 * @since JDK 1.7
	 */
	void greetTo(String name);

	/**
	 * serveTo:对顾客提供服务
	 * 
	 * @param name
	 * @since JDK 1.7
	 */
	void serveTo(String name);
}
