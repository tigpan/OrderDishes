package com.zhouli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhouli.domain.SellerInfo;
import com.zhouli.service.SellerInfoService;

@Controller
@RequestMapping
public class ProductCategoryServlet {
	@Autowired
	SellerInfoService sellerInfoService;

	@GetMapping("/test")
	public void doGet() {
		SellerInfo sellerInfo = new SellerInfo();
		/*sellerInfo.setOpenid("openid231231");
		sellerInfo.setUsername("∆∑≈∆…Ãº“");
		sellerInfo.setPassword("1434445065558pai");
		sellerInfo.setSellerId("08");
		String openid = sellerInfo.getOpenid();
		System.out.println("5555555555555" + sellerInfoService);
		System.out.println("4444444444444444444");
		sellerInfoService.save(sellerInfo);*/
		System.out.println("666666666666666666666666666" + sellerInfoService.findByOpenid("openid231"));
	}
}
