package com.zhouli.service;

import java.util.List;

import com.zhouli.domain.OrderDetail;

public interface OrderDetailService {
	/* ͨ��orderId����ѯ������ϸ��Ϣ */
	public List<OrderDetail> findByOrderId(String orderId);
}
