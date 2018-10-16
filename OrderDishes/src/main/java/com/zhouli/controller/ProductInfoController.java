package com.zhouli.controller;

import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhouli.dto.OrderDTO;
import com.zhouli.service.OrderDetailService;
import com.zhouli.service.OrderService;
import com.zhouli.service.ProductInfoService;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.impl.WxMpServiceHttpClientImpl;

@Controller
//@RequestMapping
public class ProductInfoController {
	@Autowired
	ProductInfoService productInfoService;
	@Autowired
	OrderDetailService orderDetailService;
	@Autowired
	OrderService orderService;

	@RequestMapping("/doGe")
	@ResponseBody
	public PageInfo<OrderDTO> doGet(Integer pageNum, Integer pageSize) {
		System.out.println("5555555555555" + productInfoService);
		System.out.println("666666666666666666666666666");
		System.out.println(orderService.findList(pageNum, pageSize));
		return orderService.findList(pageNum, pageSize);
	}
}
