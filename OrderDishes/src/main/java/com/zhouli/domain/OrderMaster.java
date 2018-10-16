package com.zhouli.domain;

import java.math.BigDecimal;
import java.util.Date;

public class OrderMaster {
	/* ����id */
	private String orderId;
	/* ������� */
	private String buyerName;
	/* ��ҵ绰 */
	private String buyerPhone;
	/* ��ҵ�ַ */
	private String buyerAddress;
	/* ���΢��id */
	private String buyerOpenid;
	/* �����ܽ�� */
	private BigDecimal orderAmount;
	/* ����״̬��Ĭ��Ϊ0���¶����� 1��������ɣ�2:ȡ������ */
	private Byte orderStatus = 0;
	/* ֧��״̬��Ĭ��Ϊ0:δ֧��,1:֧���ɹ� */
	private Byte payStatus = 0;
	/* ����ʱ�� */
	private Date createTime;
	/* ����ʱ�� */
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