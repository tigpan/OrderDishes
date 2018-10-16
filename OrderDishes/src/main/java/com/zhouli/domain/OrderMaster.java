package com.zhouli.domain;

import java.math.BigDecimal;
import java.util.Date;

public class OrderMaster {
	/* 订单id */
	private String orderId;
	/* 买家姓名 */
	private String buyerName;
	/* 买家电话 */
	private String buyerPhone;
	/* 买家地址 */
	private String buyerAddress;
	/* 买家微信id */
	private String buyerOpenid;
	/* 订单总金额 */
	private BigDecimal orderAmount;
	/* 订单状态，默认为0，新订单。 1：订单完成，2:取消订单 */
	private Byte orderStatus = 0;
	/* 支付状态，默认为0:未支付,1:支付成功 */
	private Byte payStatus = 0;
	/* 创造时间 */
	private Date createTime;
	/* 更新时间 */
	private Date updateTime;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerPhone() {
		return buyerPhone;
	}

	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}

	public String getBuyerAddress() {
		return buyerAddress;
	}

	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}

	public String getBuyerOpenid() {
		return buyerOpenid;
	}

	public void setBuyerOpenid(String buyerOpenid) {
		this.buyerOpenid = buyerOpenid;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Byte getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Byte orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Byte getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Byte payStatus) {
		this.payStatus = payStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}