package com.li.proxy;


/**
 * ClassName: PerformanceMonitor <br/>
 * Function: 性能监视实现类
 * date: 2017年12月12日  <br/>
 *
 * @author prd-lxw
 * @version 1.0
 * @since JDK 1.7
 */
public class PerformanceMonitor {
	
	/**
	 * performaceRecord:通过ThreadLocal保存与调用线程相关的性能监视信息
	 */
	private static ThreadLocal<MethodPerformace> performaceRecord = new ThreadLocal<MethodPerformace>();
	
	public static void begin(String method) {
		System.out.println("begin monitor...");
		MethodPerformace mp = performaceRecord.get();
		if(mp == null){
			mp = new MethodPerformace(method);
			performaceRecord.set(mp);
		}else{
		    mp.reset(method);	
		}
	}
	public static void end() {
		System.out.println("end monitor...");
		MethodPerformace mp = performaceRecord.get();
		mp.printPerformace();//打印出方法性能监视的结果信息
	}
}
