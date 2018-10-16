package com.zhouli.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhouli.domain.OrderMaster;

public interface OrderMasterService {

	public  List<OrderMaster> findByBuyerOpenid(String buyerOpenid);

	public void insert(OrderMaster orderMaster);

}
