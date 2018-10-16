package com.zhouli.controller;

import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.zhouli.dto.OrderDTO;
import com.zhouli.enums.ResultEnum;
import com.zhouli.exception.SellException;
import com.zhouli.service.OrderService;

@Controller
@RequestMapping("/seller/order")
public class SellerOrderController {
	@Autowired
	OrderService orderService;

	@GetMapping("/list")
	public ModelAndView list(@RequestParam(name = "pageNum", defaultValue = "2") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize, Map<String, Object> map) {
		PageInfo<OrderDTO> pageInfo = orderService.findList(pageNum, pageSize);
		System.out.println("进入了list界面");
		map.put("pageInfo", pageInfo);
		System.out.println(pageInfo);
		return new ModelAndView("templates/order/list", map);
	}

	@GetMapping("/cancel")
	public ModelAndView cancel(@RequestParam("orderId") String orderId,BindingResult bindingResult, Map<String, Object> map) {
		OrderDTO orderDTO = null;
		try {
			orderDTO = orderService.findOne(orderId);
		} catch (SellException e) {
			if (orderDTO == null) {
				map.put("msg", e.getMessage());
				map.put("url", "list");
				System.out.println("订单不存在");
				// 如果订单不存在，则返回到错误页面
				return new ModelAndView("templates/common/error", map);
			}
			e.getMessage();
		}
		map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
		map.put("url", "list");
		orderService.cancel(orderDTO);
		return new ModelAndView("templates/common/success", map);
	}

	@GetMapping("/detail")
	public ModelAndView detail(@RequestParam("orderId") String orderId, Map<String, Object> map) {
		System.out.println("进入了controller");
		OrderDTO orderDTO = null;
		try {
			orderDTO = orderService.findOne(orderId);
		} catch (SellException e) {
			if (orderDTO == null) {
				map.put("msg", e.getMessage());
				map.put("url", "list");
				System.out.println("订单不存在");
				// 如果订单不存在，则返回到错误页面
				return new ModelAndView("templates/common/error", map);
			}
		}
		map.put("orderDTO", orderDTO);
		map.put("orderDetailList",orderDTO.getOrderDetailList());
		return new ModelAndView("templates/order/detail", map);
	}
	@GetMapping("/finish")
	public ModelAndView finish(@RequestParam("orderId") String orderId, Map<String, Object> map) {
		System.out.println("进入了controller");
		OrderDTO orderDTO = null;
		try {
			orderDTO = orderService.findOne(orderId);
			orderService.finish(orderDTO);
		} catch (SellException e) {
			if (orderDTO == null) {
				map.put("msg", e.getMessage());
				map.put("url", "list");
				System.out.println("订单不存在");
				// 如果订单不存在，则返回到错误页面
				return new ModelAndView("templates/common/error", map);
			}
		}
		map.put("msg", ResultEnum.ORDER_FINISHED_SUCCESS.getMessage());
		map.put("orderDTO", orderDTO);
		map.put("url", "list");
		return new ModelAndView("templates/common/success", map);
	}

}
