package com.zhouli.dto;

public class CartDTO {
	/* 产品id */
	private String productId;
	/* 库存数量 */
	private Integer productQuantity;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public CartDTO(String productId, Integer productQuantity) {
		this.productId = productId;
		this.productQuantity = productQuantity;
	}
}
