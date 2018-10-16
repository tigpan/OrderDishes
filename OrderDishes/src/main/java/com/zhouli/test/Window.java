package com.zhouli.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhouli.controller.ProductCategoryServlet;

public class Window {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1111111111111111111111111");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("222222222222222222");
		ProductCategoryServlet pcs = (ProductCategoryServlet) context.getBean("productCategoryServlet");
		System.out.println("444444444" + pcs);
		/*
		 * OrderForm orderForm = new OrderForm(); orderForm.setPhone("13088886666");
		 * orderForm.setAddress("����");
		 * orderForm.setItems("[{productId:\"1435\",productQuantity:2}]");
		 * orderForm.setName("����"); orderForm.setOpenid("wechat4399"); ;
		 * System.out.println("׼��ִ��list");
		 * 
		 * }
		 */
		pcs.doGet();
	}
}
