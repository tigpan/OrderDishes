package com.zhouli.enums;

public enum ResultEnum {
	// ����enumʵ��
	SUCCESS(0, "�ɹ�"), PARAM_ERROE(1, "��������"), PRODUCT_NOT_EXIST(10, "��Ʒ������"), PRODUCT_STOCK_ERROR(11,
			"����Ʒ��治��"), ORDER_NOT_EXIST(12, "����������"), ORDERDETAIL_NOT_EXIST(13, "��Ʒ���鲻����"), ORDER_STATUS_ERROR(14,
					"����״̬����"), ORDER_DETAIL_EMPTY(15, "�������鲻����"), ORDER_UPDATE_FAILED(16,
							"��������ʧ��"), ORDER_PAY_STATUS_ERROR(17, "����֧��״̬����"), CART_EMPTY(18,
									"����Ϊ��"), ORDER_OWNER_ERROR(19, "�ö��������ڵ�ǰ�û�"), WEXIN_MP_ERROR(20,
											"΢�Ų����쳣"), ORDER_CANCEL_SUCCESS(21, "����ȡ���ɹ�"), ORDER_FINISHED_SUCCESS(22,
													"����ȡ���ɹ�"), LOGIN_FAILED(23, "��¼ʧ��"), LOGIN_SUCCESS(23, "��¼�ɹ�"),
	LOGOUT_FAILED(25,"δ��¼�������˳���¼����"),
	LOGOUT_SUCCESS(26,"���˳���¼");

	private Integer code;
	private String message;

	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
