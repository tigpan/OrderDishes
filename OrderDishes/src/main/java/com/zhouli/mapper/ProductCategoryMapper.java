package com.zhouli.mapper;

import java.util.List;


import com.zhouli.domain.ProductCategory;

public interface ProductCategoryMapper {
	
	public void save(ProductCategory productCategory);
	
	public ProductCategory findOneById(Integer id);
	
	public List<ProductCategory> findAll();
	
	public void delete(Integer id);
	
	public void update(ProductCategory productCategory); 
	
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
	
	

}
