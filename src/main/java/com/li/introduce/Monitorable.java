package com.li.introduce;

/**
 * ClassName: Monitorable <br/>
 * Function: 通过该接口来控制业务横切逻辑
 * date: 2017年12月12日 <br/>
 *
 * @author prd-lxw
 * @version 1.0
 * @since JDK 1.7
 */
public interface Monitorable {
   void setMonitorActive(boolean active);
}
