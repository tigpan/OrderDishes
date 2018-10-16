package com.zhouli.domain;

import java.sql.Timestamp;
import java.util.Date;

public class ProductCategory {
	private Integer categoryId ;
	private String  categoryName ;
	private Integer categoryType ;
	private Timestamp createTime ;
	private Date updateTime ;
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
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
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String toString() {
		return "ProductCategory:[categoryId"+categoryId+"categoryName+"+categoryName+"categoryType"+categoryType+"createTime"+createTime;
		
	}
}
