package com.zhouli.converter;

import com.zhouli.dto.OrderDTO;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.zhouli.domain.OrderMaster;
/*OrderMaster转OrderDTO
 * OrderDTO是用于前端的数据
 * */
public class OrderMaster2OrderDTOConverter {
	
	public static OrderDTO convert(OrderMaster orderMaster) {
		OrderDTO orderDTO = new OrderDTO();
		BeanUtils.copyProperties(orderMaster, orderDTO);
		return orderDTO;
	}
	/*
	 * 用的lambda表达式 
	 * 知识点：lambda+函数式编程
	 */
	public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
		return orderMasterList.stream().map(e ->convert(e)).collect(Collectors.toList());
	}

}
