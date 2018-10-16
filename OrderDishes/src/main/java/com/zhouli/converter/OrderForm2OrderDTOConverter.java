package com.zhouli.converter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhouli.domain.OrderDetail;
import com.zhouli.dto.OrderDTO;
import com.zhouli.form.OrderForm;

public class OrderForm2OrderDTOConverter {
	public static OrderDTO convert(OrderForm orderForm) {
		ObjectMapper mapper = new ObjectMapper();
		// mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, String.class);
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setBuyerName(orderForm.getName());
		orderDTO.setBuyerPhone(orderForm.getPhone());
		orderDTO.setBuyerAddress(orderForm.getAddress());
		orderDTO.setBuyerOpenid(orderDTO.getBuyerOpenid());
		List<OrderDetail> orderDetailList = new ArrayList();
		// String类型的json转换为List<>
		//程序在这有bug出现报错，主要是json不熟悉，后期一定要改正
		try {
			orderDetailList = (List<OrderDetail>) mapper.readValue(orderForm.getItems(),
					new TypeReference<List<OrderDetail>>() {
					});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			System.out.println("JsonParseException====");
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			System.out.println("JsonMappingException====");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException====");
			e.printStackTrace();
		}
		/*
		 * } catch (IOException e) { // TODO Auto-generated catch block throw new
		 * SellException(ResultEnum.PARAM_ERROE); }
		 */
		orderDTO.setOrderDetailList(orderDetailList);
		return orderDTO;
	}
}
