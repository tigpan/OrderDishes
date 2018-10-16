package com.zhouli.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhouli.domain.OrderMaster;
import com.zhouli.mapper.OrderMasterMapper;
import com.zhouli.service.OrderMasterService;

@Service
public class OrderMasterServiceImpl implements OrderMasterService {
	@Autowired
	OrderMasterMapper orderMasterMapper;

	@Override
	public List<OrderMaster> findByBuyerOpenid(String buyerOpenid) {
		// TODO Auto-generated method stub
		System.out.println("buyerOpenid===" + buyerOpenid);
		return orderMasterMapper.findByBuyerOpenid(buyerOpenid);
	}

	@Override
	public void insert(OrderMaster orderMaster) {
		// TODO Auto-generated method stub
		System.out.println("orderMaster====" + orderMaster);
		System.out.println("orderMasterMapper.insert(orderMaster)===" + orderMasterMapper.insert(orderMaster));
	}
}
