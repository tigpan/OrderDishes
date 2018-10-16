package com.zhouli.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
//import com.github.pagehelper.util.StringUtil;
import com.zhouli.VO.ResultVO;
import com.zhouli.converter.OrderForm2OrderDTOConverter;
import com.zhouli.dto.OrderDTO;
import com.zhouli.enums.ResultEnum;
import com.zhouli.exception.SellException;
import com.zhouli.form.OrderForm;
import com.zhouli.service.BuyerService;
import com.zhouli.service.OrderService;
import com.zhouli.service.ProductCategoryService;
import com.zhouli.utils.ResultVOUtil;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;

@Controller
@RequestMapping("/buyer/order")
public class BuyerOrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	ProductCategoryService productCategoryService;
	@Autowired
	BuyerService buyerService;
	/*
	 * TODO 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷锟斤拷锟介：json锟斤拷式锟斤拷锟斤拷 锟斤拷要系统学习json
	 * com.fasterxml.jackson.databind.JsonMappingException: Unexpected character
	 * ('p' (code 112))
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	@ResponseBody
	public ResultVO<Map<String, String>> create(/* @Valid */ OrderForm orderForm/* , BindingResult bingingResult */) {
		/*
		 * if (bingingResult.hasErrors()) { throw new
		 * SellException(ResultEnum.PARAM_ERROE.getCode(),
		 * bingingResult.getFieldError().getDefaultMessage()); }
		 */
		System.out.println("00000===" + orderForm.getPhone());
		OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
		if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
			throw new SellException(ResultEnum.CART_EMPTY);
		}
		OrderDTO createResult = orderService.create(orderDTO);
		Map<String, String> map = new HashMap<>();
		map.put("orderId", createResult.getOrderId());
		return ResultVOUtil.success(map);
	}

	/* 锟斤拷询锟斤拷锟斤拷锟斤拷 */
	@GetMapping("/list")
	@ResponseBody
	public ResultVO<List<OrderDTO>> list(String openId, Integer pageNum, Integer pageSize) {
		if (StringUtil.isEmpty(openId)) {
			throw new SellException(ResultEnum.PARAM_ERROE);
		}
		PageInfo<OrderDTO> pageInfo = orderService.findList(openId, pageNum, pageSize);
		if (pageInfo.getTotal() == 0) {
			System.out.println("锟斤拷锟斤拷锟斤拷锟斤拷强盏陌锟�");
		}
		return ResultVOUtil.success(pageInfo.getList());
	}
	/*
	 * public ResultVO<List<OrderDTO>> list(String openId) { if
	 * (StringUtil.isEmpty(openId)) { throw new
	 * SellException(ResultEnum.PARAM_ERROE); } List<OrderDTO> orderDTOList =
	 * orderService.findList(openId); if (CollectionUtils.isEmpty(orderDTOList)) {
	 * System.out.println("锟斤拷锟斤拷锟斤拷锟斤拷强盏陌锟�"); } return
	 * ResultVOUtil.success(orderDTOList); }
	 */

	// 锟斤拷询锟斤拷锟斤拷锟斤拷锟斤拷锟�
	@GetMapping("/detail")
	@ResponseBody
	public ResultVO<OrderDTO> detail(String openId, String orderId) {
		// TODO 锟斤拷锟斤拷全锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷要锟侥斤拷锟斤拷锟揭诧拷应锟斤拷锟斤拷锟斤拷openId锟斤拷锟斤拷权锟斤拷
		OrderDTO orderDTO = buyerService.findOrderOne(openId, orderId);
		return ResultVOUtil.success(orderDTO);
	}
	// 取锟斤拷锟斤拷锟斤拷
	@PostMapping("/cancel")
	@ResponseBody
	public ResultVO cancel(String openId, String orderId) {
		OrderDTO orderDTO = buyerService.cancelOrderOne(openId, orderId);
		orderService.cancel(orderDTO);
		return ResultVOUtil.success(null);
	}
}
