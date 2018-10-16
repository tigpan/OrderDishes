package com.zhouli.mapper;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.zhouli.domain.OrderMaster;

public interface OrderMasterMapper {
	/*
	 * 根据微信openId查询订单细节id
	 */
	public List<OrderMaster> findByBuyerOpenid(String buyerOpenid);

	public int deleteByPrimaryKey(String orderid);

	public int insert(OrderMaster orderMaster);

	public int insertSelective(OrderMaster orderMaster);

	public OrderMaster findOne(String orderId);

	public int updateByPrimaryKeySelective(OrderMaster orderMaster);

	public int updateByPrimaryKey(OrderMaster orderMaster);

	// 查询所有订单 与第一个方法不同
	public List<OrderMaster> findAll();

}