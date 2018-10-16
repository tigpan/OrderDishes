package com.zhouli.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhouli.domain.ProductInfo;
import com.zhouli.dto.CartDTO;
import com.zhouli.enums.ResultEnum;
import com.zhouli.exception.SellException;
import com.zhouli.mapper.ProductInfoMapper;
import com.zhouli.service.ProductInfoService;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {
	@Autowired
	ProductInfoMapper productInfoMapper;

	public ProductInfo findOneProductInfo(String productId) {
		// TODO Auto-generated method stub
		return productInfoMapper.findOne(productId);
	}

	@Override
	public List<ProductInfo> findUpProductInfo(Integer categoryType) {
		// TODO Auto-generated method stub
		return productInfoMapper.findByProductStates(categoryType);
	}

	@Override

	public List<ProductInfo> findAllProductInfo() {
		// TODO Auto-generated method stub
		return productInfoMapper.findAll();
	}

	@Override
	/*
	 * 此处用分页 查询所有商品列表
	 */
	public PageInfo<ProductInfo> findAllProductInfo(Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		List<ProductInfo> list = productInfoMapper.findAll();
		System.out.println("list===222===" + list);
		PageHelper.startPage(pageNum, pageSize);
		System.out.println("list===222===" + list);
		PageInfo<ProductInfo> pageInfo = new PageInfo<>(list);
		System.out.println("pageInfo=====" + pageInfo);
		return pageInfo;
	}

	@Override
	public void saveProductInfo(ProductInfo productInfo) {
		// TODO Auto-generated method stub
		productInfoMapper.saveProductInfo(productInfo);
	}

	@Override
	public void increaseStock(List<CartDTO> cartDTOList) {
		// TODO Auto-generated method stub
		for (CartDTO cartDTO : cartDTOList) {
			ProductInfo productInfo = productInfoMapper.findOne(cartDTO.getProductId());
			if (productInfo == null) {
				// 商品不存在
				throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
			}
			Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
			productInfo.setProductStock(result);
			productInfoMapper.saveProductInfo(productInfo);
		}
	}

	@Override
	@Transactional
	public void decreaseStock(List<CartDTO> cartDTOList) {
		// TODO Auto-generated method stub
		for (CartDTO cartDTO : cartDTOList) {
			ProductInfo productInfo = productInfoMapper.findOne(cartDTO.getProductId());
			if (productInfo == null) {
				// 商品不存在
				throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
			}
			// 商品存在则判断库存是否充足
			Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
			if (result < 0) {
				throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
			}
			productInfo.setProductStock(result);
			productInfoMapper.saveProductInfo(productInfo);
		}

	}

	@Override
	public void onSale(String productId) {
		// TODO Auto-generated method stub
		productInfoMapper.onSale(productId);
		System.out.println("修改后状态为" + productInfoMapper.findOne(productId).getProductStatus());
	}

	@Override
	public void offSale(String productId) {
		// TODO Auto-generated method stub
		productInfoMapper.offSale(productId);
	}

}
