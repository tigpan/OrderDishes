package com.zhouli.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhouli.domain.ProductInfo;
import com.zhouli.dto.CartDTO;

public interface ProductInfoService {
	public ProductInfo findOneProductInfo(String productId);

	/* �����ϼܵĲ�Ʒ �˴�Ӧ����productStauts���� */
	public List<ProductInfo> findUpProductInfo(Integer categoryType);

	/*
	 * TODO �˴�ΪԴ����
	 *
	 */
	public List<ProductInfo> findAllProductInfo();

	/*
	 * TODO �˴�Ϊ�´��� ��ѯ���е���Ʒ�б� �˴�Ӧ���÷�ҳ PageHelper
	 */
	public PageInfo<ProductInfo> findAllProductInfo(Integer pageNum, Integer pageSize);

	public void saveProductInfo(ProductInfo productInfo);

	/* ���ӿ�� */
	void increaseStock(List<CartDTO> cartDTOList);

	/* ���ٿ�� */
	void decreaseStock(List<CartDTO> cartDTOList);

	/* �ϼ���Ʒ */
	public void onSale(String productId);

	/* �¼���Ʒ */
	public void offSale(String productId);
}