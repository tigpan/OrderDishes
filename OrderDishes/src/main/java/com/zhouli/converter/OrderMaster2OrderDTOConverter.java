package com.zhouli.converter;

import com.zhouli.dto.OrderDTO;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.zhouli.domain.OrderMaster;
/*OrderMasterתOrderDTO
 * OrderDTO������ǰ�˵�����
 * */
public class OrderMaster2OrderDTOConverter {
	
	public static OrderDTO convert(OrderMaster orderMaster) {
		OrderDTO orderDTO = new OrderDTO();
		BeanUtils.copyProperties(orderMaster, orderDTO);
		return orderDTO;
	}
	/*
	 * �õ�lambda���ʽ 
	 * ֪ʶ�㣺lambda+����ʽ���
	 */
	public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
		return orderMasterList.stream().map(e ->convert(e)).collect(Collectors.toList());
	}

}
