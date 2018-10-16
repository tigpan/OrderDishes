package com.zhouli.service;

import java.util.List;

import com.zhouli.domain.OrderDetail;

public interface OrderDetailService {
	/* 通过orderId来查询订单详细信息 */
	public List<OrderDetail> findByOrderId(String orderId);
}
