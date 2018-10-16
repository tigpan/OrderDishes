package com.zhouli.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhouli.domain.OrderDetail;
import com.zhouli.mapper.OrderDetailMapper;
import com.zhouli.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
	OrderDetailMapper orderDetailMapper;
	@Override
	public List<OrderDetail> findByOrderId(String orderId) {
		return orderDetailMapper.findByOrderId(orderId);
	}

}