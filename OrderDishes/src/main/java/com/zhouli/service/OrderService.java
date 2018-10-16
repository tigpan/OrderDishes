package com.zhouli.service;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhouli.dto.OrderDTO;

public interface OrderService {

	/*
	 * 用户订单 首先创建OrderDTO代替OrderMaster用于在页面传输数据
	 */
	/*
	 * 新建六个方法 创建订单 查询单个订单 查询所有订单 完结订单 取消订单 支付订单
	 */
	public OrderDTO create(OrderDTO orderDTO);

	public OrderDTO findOne(String orderId);

	//
	/*查询订单列表，某个人的
	 * public List<OrderDTO> findList(String buyerOpenid);
	 */
	public PageInfo<OrderDTO> findList(String buyerOpenid,Integer pageNum, Integer pageSize);

	public OrderDTO cancel(OrderDTO orderDTO);

	public OrderDTO finish(OrderDTO orderDTO);

	public OrderDTO paid(OrderDTO orderDTO);
/*
 * 查询所有人的订单列表
 */
	public PageInfo<OrderDTO> findList(Integer pageNum, Integer pageSize);
	//public List<OrderDTO> findList();
}
