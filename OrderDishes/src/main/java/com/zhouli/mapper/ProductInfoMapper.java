package com.zhouli.mapper;

import java.util.List;

import com.zhouli.domain.ProductInfo;

public interface ProductInfoMapper {

	public void saveProductInfo(ProductInfo productInfo);

	public List<ProductInfo> findByProductStates(Integer categoryType);

	public List<ProductInfo> findAll();

	public ProductInfo findOne(String productId);

	public void onSale(String productId);

	public void offSale(String productId);
}
