package com.zhouli.VO;

import java.math.BigDecimal;

public class ProductInfoVO {
	/*
	 * ��productInfo�����������ǵ�����Ʒ����ʾ����
	 * ֻ���������
	 */
	private String productId;
	private String productName;
	private BigDecimal productPrice;
	private String productDescription;
	private String productIcon;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
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
	

}
