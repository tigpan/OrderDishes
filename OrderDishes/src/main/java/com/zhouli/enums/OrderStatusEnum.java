package com.zhouli.enums;

public enum OrderStatusEnum implements CodeEnum {
	NEW_ORDER((byte) 0, "�¶���"), FINISHED_ORDER((byte) 1, "����ɶ���"), CANCEL_ORDER((byte) 2, "������ȡ��");
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
