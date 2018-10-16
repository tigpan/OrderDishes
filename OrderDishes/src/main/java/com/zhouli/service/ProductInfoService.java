package com.zhouli.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhouli.domain.ProductInfo;
import com.zhouli.dto.CartDTO;

public interface ProductInfoService {
	public ProductInfo findOneProductInfo(String productId);

	/* 发现上架的产品 此处应该用productStauts参数 */
	public List<ProductInfo> findUpProductInfo(Integer categoryType);

	/*
	 * TODO 此处为源代码
	 *
	 */
	public List<ProductInfo> findAllProductInfo();

	/*
	 * TODO 此处为新代码 查询所有的商品列表 此处应该用分页 PageHelper
	 */
	public PageInfo<ProductInfo> findAllProductInfo(Integer pageNum, Integer pageSize);

	public void saveProductInfo(ProductInfo productInfo);

	/* 增加库存 */
	void increaseStock(List<CartDTO> cartDTOList);

	/* 减少库存 */
	void decreaseStock(List<CartDTO> cartDTOList);

	/* 上架商品 */
	public void onSale(String productId);

	/* 下架商品 */
	public void offSale(String productId);
}