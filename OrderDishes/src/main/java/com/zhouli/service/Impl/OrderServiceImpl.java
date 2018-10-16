package com.zhouli.service.Impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhouli.converter.OrderMaster2OrderDTOConverter;
import com.zhouli.domain.OrderDetail;
import com.zhouli.domain.OrderMaster;
import com.zhouli.domain.ProductInfo;
import com.zhouli.dto.CartDTO;
import com.zhouli.dto.OrderDTO;
import com.zhouli.enums.OrderStatusEnum;
import com.zhouli.enums.PayStatusEnum;
import com.zhouli.enums.ResultEnum;
import com.zhouli.exception.SellException;
import com.zhouli.mapper.OrderDetailMapper;
import com.zhouli.mapper.OrderMasterMapper;
import com.zhouli.service.OrderService;
import com.zhouli.service.ProductInfoService;
import com.zhouli.utils.KeyUtil;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	ProductInfoService productInfoService;
	@Autowired
	OrderDetailMapper orderDetailMapper;
	@Autowired
	OrderMasterMapper orderMasterMapper;

	/*
	 * ��Ϊ�Ĳ� 1.��ѯ��Ʒ�����������ۣ� 2.�����ܼ� 3.д�붩�����ݿ⣨OrderMaster OrderDetail�� 4.�޸Ŀ��
	 */
	@Override
	@Transactional
	public OrderDTO create(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
		// ����Ψһ�Ķ���id ��ֹ�ظ�
		String orderId = KeyUtil.genUniqueKey();
		// 1.��ѯ��Ʒ
		for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
			ProductInfo productInfo = productInfoService.findOneProductInfo(orderDetail.getProductId());
			if (productInfo == null) {
				throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
			}
			// 2.���㶩���ܼ�
			orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity()))
					.add(orderAmount);
			// �����������
			BeanUtils.copyProperties(productInfo, orderDetail);
			orderDetail.setDetailId(KeyUtil.genUniqueKey());
			orderDetail.setOrderId(orderId);
			orderDetailMapper.insert(orderDetail);
			// 3.д�붩�����ݿ⣨OrderMaster OrderDetail��
			OrderMaster orderMaster = new OrderMaster();
			orderDTO.setOrderId(orderId);
			BeanUtils.copyProperties(orderDTO, orderMaster);
			orderMaster.setOrderAmount(orderAmount);
			orderMaster.setOrderStatus((byte) 0);
			orderMaster.setPayStatus((byte) 0);

			orderMasterMapper.insert(orderMaster);
			/*
			 * 4.�޸Ŀ�� ��δ��뿴���������ҳ��� ʹ����lambda ��Ҫѧϰ ����ʽ���+lambda+stream
			 * ��黹�����Ż������˷���ʱ���ܳ��ֲ�ѯ�����㹻�����
			 */
			List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
					.map(e -> new CartDTO(e.getProductId(), e.getProductQuantity())).collect(Collectors.toList());
			productInfoService.decreaseStock(cartDTOList);
		}
		return orderDTO;
	}

	@Override
	@Transactional
	public OrderDTO findOne(String orderId) {
		// TODO Auto-generated method stub
		OrderMaster orderMaster = orderMasterMapper.findOne(orderId);
		if (orderMaster == null) {
			throw new SellException(ResultEnum.ORDER_NOT_EXIST);
		}
		List<OrderDetail> orderDetailList = orderDetailMapper.findByOrderId(orderId);
		if (CollectionUtils.isEmpty(orderDetailList)) {
			throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXIST);
		}
		OrderDTO orderDTO = new OrderDTO();
		BeanUtils.copyProperties(orderMaster, orderDTO);
		orderDTO.setOrderDetailList(orderDetailList);
		return orderDTO;
	}

	// @Override
	/*
	 * ����Ӧ���÷�ҳ�����Ǹ粻�ᰡ ����һ��Ҫ�÷�ҳ�޸� �˴�û��Ҫ�г���������
	 */
	/*
	 * public List<OrderDTO> findList(String buyerOpenid) { // TODO Auto-generated
	 * method stub List<OrderMaster> orderMasterList =
	 * orderMasterMapper.findByBuyerOpenid(buyerOpenid);
	 * OrderMaster2OrderDTOConverter orderMaster2OrderDTOConverter = new
	 * OrderMaster2OrderDTOConverter(); List<OrderDTO> orderDTOList =
	 * orderMaster2OrderDTOConverter.convert(orderMasterList); return orderDTOList;
	 * }
	 */
	@Override
	@Transactional
	public OrderDTO cancel(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		OrderMaster orderMaster = new OrderMaster();
		// �ж϶���״̬
		if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW_ORDER.getStatusCode())) {
			throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
		}
		// �޸Ķ���״̬
		orderDTO.setOrderStatus(OrderStatusEnum.CANCEL_ORDER.getStatusCode());

		BeanUtils.copyProperties(orderDTO, orderMaster);
		OrderMaster updateResult = null;
		if (orderMasterMapper.updateByPrimaryKeySelective(orderMaster) != 0) {
			updateResult = orderMaster;
		}
		if (updateResult == null) {
			throw new SellException(ResultEnum.ORDER_UPDATE_FAILED);
		}
		// ���ؿ��
		if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
			throw new SellException(ResultEnum.ORDER_DETAIL_EMPTY);
		}
		List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
				.map(e -> new CartDTO(e.getProductId(), e.getProductQuantity())).collect(Collectors.toList());
		productInfoService.increaseStock(cartDTOList);
		// �˿� �����֧������Ҫ�˿�
		if (orderDTO.getPayStatus().equals(PayStatusEnum.PAY_FINISHED)) {
			// TODO
			// ִ���˿����
			System.out.println("�˿�ɹ�");
		}
		return orderDTO;
	}

	@Override
	@Transactional
	public OrderDTO finish(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		// �ж϶���״̬
		if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW_ORDER.getStatusCode())) {
			throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
		}
		// �޸Ķ���״̬
		orderDTO.setOrderStatus(OrderStatusEnum.FINISHED_ORDER.getStatusCode());
		OrderMaster orderMaster = new OrderMaster();
		BeanUtils.copyProperties(orderDTO, orderMaster);
		OrderMaster updateResult = null;
		if (orderMasterMapper.updateByPrimaryKeySelective(orderMaster) != 0) {
			updateResult = orderMaster;
		}
		if (updateResult == null) {
			throw new SellException(ResultEnum.ORDER_UPDATE_FAILED);
		}
		return orderDTO;
	}

	@Override
	@Transactional
	public OrderDTO paid(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW_ORDER.getStatusCode())) {
			throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
		}
		// �ж�֧��״̬
		if (!orderDTO.getPayStatus().equals(PayStatusEnum.PAY_UNFINISHED.getPayStatusCode())) {
			throw new SellException(ResultEnum.ORDER_PAY_STATUS_ERROR);
		}
		// �޸�֧��״̬
		orderDTO.setPayStatus(PayStatusEnum.PAY_FINISHED.getPayStatusCode());
		OrderMaster orderMaster = new OrderMaster();
		BeanUtils.copyProperties(orderDTO, orderMaster);
		OrderMaster updateResult = null;
		if (orderMasterMapper.updateByPrimaryKeySelective(orderMaster) != 0) {
			updateResult = orderMaster;
		}
		if (updateResult == null) {
			throw new SellException(ResultEnum.ORDER_UPDATE_FAILED);
		}
		return orderDTO;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zhouli.service.OrderService#findList(java.lang.String,
	 * java.lang.Integer, java.lang.Integer) ��ѯĳ���˵����ж���
	 */
	public PageInfo<OrderDTO> findList(String buyerOpenid, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		List<OrderMaster> orderMasterList = orderMasterMapper.findByBuyerOpenid(buyerOpenid);
		OrderMaster2OrderDTOConverter orderMaster2OrderDTOConverter = new OrderMaster2OrderDTOConverter();
		PageHelper.startPage(pageNum, pageSize);
		List<OrderDTO> orderDTOList = orderMaster2OrderDTOConverter.convert(orderMasterList);
		PageInfo<OrderDTO> pageInfo = new PageInfo<>(orderDTOList);
		return pageInfo;
	}

	/*
	 * ��Ҷ������� ��ѯ���еĶ��� ���Ǹ��ˣ�
	 */
	@Override
	public PageInfo<OrderDTO> findList(Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		Page page = PageHelper.startPage(pageNum, pageSize, true);
		List<OrderMaster> orderMasterList = orderMasterMapper.findAll();
		OrderMaster2OrderDTOConverter orderMaster2OrderDTOConverter = new OrderMaster2OrderDTOConverter();

		List<OrderDTO> orderDTOList = orderMaster2OrderDTOConverter.convert(orderMasterList);
		System.out.println("orderDTOList==="+orderDTOList);
		PageInfo<OrderDTO> pageInfo = new PageInfo<>(orderDTOList);
		System.out.println("pageInfo==="+pageInfo);
		pageInfo.setFirstPage(1);
		pageInfo.setNextPage(pageNum + 1);
		pageInfo.setPrePage(pageNum - 1);
		return pageInfo;
	}

}
