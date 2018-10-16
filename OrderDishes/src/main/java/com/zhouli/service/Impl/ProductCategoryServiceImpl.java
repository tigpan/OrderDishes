package com.zhouli.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhouli.domain.ProductCategory;
import com.zhouli.mapper.ProductCategoryMapper;
import com.zhouli.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	@Autowired
	ProductCategoryMapper productCategoryMapper;

	/*
	 * public ProductCategory getProductCategoryById(Integer id) {
	 * System.out.println("77777777777777" + productCategoryMapper); ProductCategory
	 * productCategory = productCategoryMapper.findOneById(id);
	 * System.out.println("8888888888888888888888");
	 * 
	 * return productCategory; }
	 */

	@Override
	public void save(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		productCategoryMapper.save(productCategory);
	}

	@Override
	public ProductCategory findOneById(Integer id) {
		// TODO Auto-generated method stub
		return productCategoryMapper.findOneById(id);
	}

	@Override
	public List<ProductCategory> findAll() {
		// TODO Auto-generated method stub
		return productCategoryMapper.findAll();
	}

	/*
	 * @Override public void delete(Integer id) { // TODO Auto-generated method stub
	 * 
	 * }
	 */

	@Override
	public void update(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		productCategoryMapper.update(productCategory);
	}

	@Override
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
		// TODO Auto-generated method stub
		return productCategoryMapper.findByCategoryTypeIn(categoryTypeList);
	}

}