package com.zhouli.enums;

public enum PayStatusEnum implements CodeEnum {
	PAY_UNFINISHED((byte) 0, "未支付"), PAY_FINISHED((byte) 1, "支付完成");
	private Byte payStatusCode;
	private String payStatusMessage;

	PayStatusEnum(Byte payStatusCode, String payStatusMessage) {
		this.payStatusCode = payStatusCode;
		this.payStatusMessage = payStatusMessage;
	}

	public Byte getPayStatusCode() {
		return payStatusCode;
	}

	public void setPayStatusCode(Byte payStatusCode) {
		this.payStatusCode = payStatusCode;
	}

	public String getPayStatusMessage() {
		return payStatusMessage;
	}

	public void setPayStatusMessage(String payStatusMessage) {
		this.payStatusMessage = payStatusMessage;
	}

	@Override
	public Byte getCode() {
		// TODO Auto-generated method stub
		return this.getPayStatusCode();
	}

}
