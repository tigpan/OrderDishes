package com.zhouli.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zhouli.enums.CodeEnum;
import com.zhouli.enums.ProductStatusEnum;
import com.zhouli.utils.EnumUtil;

public class ProductInfo {
	private String productId;
	private String productName;
	private BigDecimal productPrice;
	private Integer productStock;
	private String productDescription;
	private String productIcon;
	private Integer categoryType;
	private Byte productStatus = ProductStatusEnum.UP.getCode();

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Byte getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(Byte productStatus) {
		this.productStatus = productStatus;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductStock() {
		return productStock;
	}

	public void setProductStock(Integer productStock) {
		this.productStock = productStock;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductIcon() {
		return productIcon;
	}

	public void setProductIcon(String productIcon) {
		this.productIcon = productIcon;
	}

	public Integer getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}

	public String toString() {
		return "ProductInfo:[productId" + productId + "productName+" + productName + "productPrice" + productPrice
				+ "productStock" + productStock + "productDescription" + productDescription + "productIcon"
				+ productIcon + "categoryType=" + categoryType + "]";
	}
	@JsonIgnore
	public ProductStatusEnum getProductStatusEnum() {
		return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
	}
}
