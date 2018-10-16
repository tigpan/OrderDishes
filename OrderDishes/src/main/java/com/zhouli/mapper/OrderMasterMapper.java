package com.zhouli.mapper;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.zhouli.domain.OrderMaster;

public interface OrderMasterMapper {
	/*
	 * ����΢��openId��ѯ����ϸ��id
	 */
	public List<OrderMaster> findByBuyerOpenid(String buyerOpenid);

	public int deleteByPrimaryKey(String orderid);

	public int insert(OrderMaster orderMaster);

	public int insertSelective(OrderMaster orderMaster);

	public OrderMaster findOne(String orderId);

	public int updateByPrimaryKeySelective(OrderMaster orderMaster);

	public int updateByPrimaryKey(OrderMaster orderMaster);

	// ��ѯ���ж��� ���һ��������ͬ
	public List<OrderMaster> findAll();

}