package com.li.proxy;

/**
 * ClassName: MethodPerformace <br/>
 * Function: 记录性能监视信息
 * date: 2017年12月12日 <br/>
 *
 * @author prd-lxw
 * @version 1.0
 * @since JDK 1.7
 */
public class MethodPerformace {
	private long begin;
	private long end;
	private String serviceMethod;
    public MethodPerformace(String serviceMethod){
    	reset(serviceMethod);
    }
    public void printPerformace(){
//    	获取目标类方法执行完成后的系统时间
        end = System.currentTimeMillis();
        long elapse = end - begin;
        System.out.println(serviceMethod+"花费"+elapse+"毫秒。");
    }
    public void reset(String serviceMethod){
    	this.serviceMethod = serviceMethod;
    	this.begin = System.currentTimeMillis();//记录目标类方法开始执行点的系统时间
    }
}
