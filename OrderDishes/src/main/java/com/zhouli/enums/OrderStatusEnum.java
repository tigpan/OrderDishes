package com.zhouli.enums;

public enum OrderStatusEnum implements CodeEnum {
	NEW_ORDER((byte) 0, "新订单"), FINISHED_ORDER((byte) 1, "已完成订单"), CANCEL_ORDER((byte) 2, "订单已取消");
	Byte statusCode;
	String statusMessage;

	public Byte getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Byte statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	OrderStatusEnum(Byte statusCode, String statusMessage) {
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

	@Override
	public Byte getCode() {
		// TODO Auto-generated method stub syso
		return this.getStatusCode();
	}
}
