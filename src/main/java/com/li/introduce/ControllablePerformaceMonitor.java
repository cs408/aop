package com.li.introduce;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
/**
 * ClassName: ControllablePerformaceMonitor <br/>
 * Function: 扩展IntroductionInterceptor接口的实现类来实现自定义引介增强
 * date: 2017年12月12日 <br/>
 *
 * @author prd-lxw
 * @version 1.0
 * @since JDK 1.7
 */
public class ControllablePerformaceMonitor
		extends
			DelegatingIntroductionInterceptor implements Monitorable {
	//保存性能监视开关，各个线程互不影响
	private ThreadLocal<Boolean> MonitorStatusMap = new ThreadLocal<Boolean>();
	public void setMonitorActive(boolean active) {//新接口方法的实现
		MonitorStatusMap.set(active);
	}
	
	//拦截方法
	public Object invoke(MethodInvocation mi) throws Throwable {
		Object obj = null;
		if (MonitorStatusMap.get() != null && MonitorStatusMap.get() == true) {//开关控制
			PerformanceMonitor.begin(mi.getClass().getName() + "."
					+ mi.getMethod().getName());
			obj = super.invoke(mi);
			PerformanceMonitor.end();
		} else {
			obj = super.invoke(mi);
		}
		return obj;
	}
}
