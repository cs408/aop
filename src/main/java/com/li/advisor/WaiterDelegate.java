package com.li.advisor;

/**
 * ClassName: WaiterDelegate <br/>
 * Function: 间接调用waiter中的方法
 * date: 2017年12月12日 <br/>
 *
 * @author prd-lxw
 * @version 1.0
 * @since JDK 1.7
 */
public class WaiterDelegate {
	private Waiter waiter;
	public void service(String clientName) {
		waiter.greetTo(clientName);
		waiter.serveTo(clientName);
	}
	public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}
}
