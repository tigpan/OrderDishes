package com.zhouli.service;
import com.zhouli.dto.OrderDTO;
//ӵ�з��ֺ�ȡ��һ�������ķ�����ʵ����������Ҫ�к�ʵ�����û���ݵ��߼�
public interface BuyerService {
	OrderDTO findOrderOne(String openId, String orderId);

	OrderDTO cancelOrderOne(String openId, String orderId);
}