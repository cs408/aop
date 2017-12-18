/**
 * Project Name:Spring0725
 * File Name:Test5.java
 * Package Name:work1201.basic
 * Date:2017年12月1日下午4:16:25
 * Copyright (c) 2017, 深圳金融电子结算中心 All Rights Reserved.
 *
*/


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

/**
 * ClassName:TestIterator <br/>
 * Function: 测试Collection Map 集合改变对迭代器遍历有无影响
 * 在使用Iterator时候，对于Collection集合，改变集合的大小会触发ConcurrentModificationException异常；改变集合中元素的内容不会触发异常
 * 对于Map集合，改变集合Map的大小或者元素，均可以正常执行。
 * Date:     2017年12月1日 下午4:16:25 <br/>
 * @author   prd-lxw
 * @version   1.0
 * @since    JDK 1.7
 * @see 	 
 */
public class TestIterator {
	
	@Test
	public void testDeletCollection(){
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0;i<20;i++){
			list.add(i+"");
		}
		
		Iterator<String> it = list.iterator();
		String ss = 10+"";
		while(it.hasNext()){
			if(it.next().equals(ss)){
				System.out.println("找到元素："+ss);
//				list.remove(ss); //集合大小发生改变 ConcurrentModificationException
//				list.add(102+""); //集合大小发生改变 ConcurrentModificationException
//				list.set(19, 211+"");  //不会触发异常，因为没有改变Collection集合的大小
//				it.remove();//正常
			}
		}
	}
	
	@Test
	public void testIteratorMapEntry(){
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
		for(int i=0;i<20;i++){
			map.put(i+"", i+"");
		}
		
		Iterator<Entry<String, String>> it = map.entrySet().iterator();
		String key = 10+"";
		while(it.hasNext()){
			if(it.next().getKey().equals(key)){
				System.out.println("找到元素："+key);
				//改变Map
				map.remove(key); //正常
//				map.put(21+"", 21+""); //正常
//				map.replace(key, 30+"");//正常
//				it.remove(); //正常
				System.out.println(map.size()+":"+map.get(key));
			}
		}
	}
	
	@Test
	public void testIteratorMapKey(){
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
		for(int i=0;i<20;i++){
			map.put(i+"", i+"");
		}
		
		Iterator<String> it = map.keySet().iterator();
		String key = 10+"";
		while(it.hasNext()){
			if(it.next().equals(key)){
				System.out.println("找到元素："+key);
				//改变Map
//				map.remove(key); //正常
//				map.put(21+"", 21+""); //正常
//				map.replace(key, 30+"");//正常
				it.remove(); //正常
				System.out.println(map.size()+":"+map.get(key));
			}
		}
	}

}

