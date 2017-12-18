package com.li.advisor;



/**
 * ClassName: Waiter <br/>
 * Function: 定义服务生
 * date: 2017年12月12日 <br/>
 *
 * @author prd-lxw
 * @version 1.0
 * @since JDK 1.7
 */
public class Waiter {

	public void serveTo(String name){
		System.out.println("waiter serving "+name+"...");
		//waiter.greetTo(name);
	}

	public void greetTo(String name) {
		System.out.println("waiter greet to "+name+"...");
	}
}
