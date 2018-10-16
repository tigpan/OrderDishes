package com.zhouli.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhouli.dto.OrderDTO;
import com.zhouli.enums.ResultEnum;
import com.zhouli.exception.SellException;
import com.zhouli.service.BuyerService;
import com.zhouli.service.OrderService;

@Service
public class BuyerServiceImpl implements BuyerService {
	@Autowired
	OrderService orderService;

	@Override
	// ��ѯһ������
	public OrderDTO findOrderOne(String openId, String orderId) {
		// TODO Auto-generated method stub

		return checkOrderOwner(openId, orderId);
	}

	@Override
	// ȡ��һ������
	public OrderDTO cancelOrderOne(String openId, String orderId) {
		// TODO Auto-generated method stub
		OrderDTO orderDTO = checkOrderOwner(openId, orderId);
		// ���Ϊ�ձ�ʾû�ж��������Բ������ȡ�������Ĳ���
		if (orderDTO == null) {
			throw new SellException(ResultEnum.ORDER_NOT_EXIST);
		}
		return orderDTO;
	}

	// �ж��Ƿ��ǵ�ǰ�û��Ķ���
	private OrderDTO checkOrderOwner(String openId, String orderId) {
		OrderDTO orderDTO = orderService.findOne(orderId);
		System.out.println(orderDTO.getBuyerOpenid());
		System.out.println(openId);
		System.out.println(orderDTO.getBuyerOpenid().equalsIgnoreCase(openId));
		if (orderDTO == null) {
			return null;
		}
		if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openId)) {
			throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
		}
		return orderDTO;
	}
}
