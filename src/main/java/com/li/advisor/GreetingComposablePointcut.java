package com.li.advisor;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * ClassName: GreetingComposablePointcut <br/>
 * Function: 复合切点类
 * date: 2017年12月12日 <br/>
 *
 * @author prd-lxw
 * @version 1.0
 * @since JDK 1.7
 */
public class GreetingComposablePointcut {
   public Pointcut getIntersectionPointcut(){
	   ComposablePointcut cp = new ComposablePointcut();//创建复核切点
	   Pointcut pt1 = new ControlFlowPointcut(WaiterDelegate.class,"service");//创建流程切点WaiterDelegate#service（）
	   NameMatchMethodPointcut pt2 = new NameMatchMethodPointcut();//创建普通方法名切点
	   pt2.addMethodName("greetTo");
	   return cp.intersection(pt1).intersection((Pointcut)pt2);    //对两个切点取交集
   }
}
