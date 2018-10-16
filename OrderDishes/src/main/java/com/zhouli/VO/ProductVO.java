package com.zhouli.VO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
/*商品类别
 *
 * */
public class ProductVO {
	
	@Autowired
	private String categoryName;
	@Autowired
	private Integer categoryType;
	@Autowired
	private List<ProductInfoVO> productInfoVOList;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}

	public List<ProductInfoVO> getProductInfoVOList() {
		return productInfoVOList;
	}

	public void setProductInfoVOList(List<ProductInfoVO> productInfoVOList) {
		this.productInfoVOList = productInfoVOList;
	}

}
