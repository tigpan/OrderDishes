package com.zhouli.service;
import com.zhouli.dto.OrderDTO;
//拥有发现和取消一个订单的方法，实现类里面主要有核实订单用户身份的逻辑
public interface BuyerService {
	OrderDTO findOrderOne(String openId, String orderId);

	OrderDTO cancelOrderOne(String openId, String orderId);
}