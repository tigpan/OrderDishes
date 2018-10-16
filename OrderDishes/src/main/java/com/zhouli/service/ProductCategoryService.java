package com.zhouli.service;

import java.util.List;

import com.zhouli.domain.ProductCategory;

public interface ProductCategoryService {
	public void save(ProductCategory productCategory);

	public ProductCategory findOneById(Integer id);

	public List<ProductCategory> findAll();

	public void update(ProductCategory productCategory);

	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
