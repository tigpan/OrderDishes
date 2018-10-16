package com.zhouli.mapper;

import java.util.List;

import com.zhouli.domain.OrderDetail;

public interface OrderDetailMapper {
	public int insert(OrderDetail record);

	public int insertSelective(OrderDetail record);

	public List<OrderDetail> findByOrderId(String orderId);

}