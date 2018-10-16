package com.zhouli.service;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhouli.dto.OrderDTO;

public interface OrderService {

	/*
	 * �û����� ���ȴ���OrderDTO����OrderMaster������ҳ�洫������
	 */
	/*
	 * �½��������� �������� ��ѯ�������� ��ѯ���ж��� ��ᶩ�� ȡ������ ֧������
	 */
	public OrderDTO create(OrderDTO orderDTO);

	public OrderDTO findOne(String orderId);

	//
	/*��ѯ�����б�ĳ���˵�
	 * public List<OrderDTO> findList(String buyerOpenid);
	 */
	public PageInfo<OrderDTO> findList(String buyerOpenid,Integer pageNum, Integer pageSize);

	public OrderDTO cancel(OrderDTO orderDTO);

	public OrderDTO finish(OrderDTO orderDTO);

	public OrderDTO paid(OrderDTO orderDTO);
/*
 * ��ѯ�����˵Ķ����б�
 */
	public PageInfo<OrderDTO> findList(Integer pageNum, Integer pageSize);
	//public List<OrderDTO> findList();
}
