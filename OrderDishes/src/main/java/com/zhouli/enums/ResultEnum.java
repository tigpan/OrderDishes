package com.zhouli.enums;

public enum ResultEnum {
	// 定义enum实例
	SUCCESS(0, "成功"), PARAM_ERROE(1, "参数错误"), PRODUCT_NOT_EXIST(10, "商品不存在"), PRODUCT_STOCK_ERROR(11,
			"此商品库存不足"), ORDER_NOT_EXIST(12, "订单不存在"), ORDERDETAIL_NOT_EXIST(13, "商品详情不存在"), ORDER_STATUS_ERROR(14,
					"订单状态错误"), ORDER_DETAIL_EMPTY(15, "订单详情不存在"), ORDER_UPDATE_FAILED(16,
							"订单更新失败"), ORDER_PAY_STATUS_ERROR(17, "订单支付状态错误"), CART_EMPTY(18,
									"订单为空"), ORDER_OWNER_ERROR(19, "该订单不属于当前用户"), WEXIN_MP_ERROR(20,
											"微信参数异常"), ORDER_CANCEL_SUCCESS(21, "订单取消成功"), ORDER_FINISHED_SUCCESS(22,
													"订单取消成功"), LOGIN_FAILED(23, "登录失败"), LOGIN_SUCCESS(23, "登录成功"),
	LOGOUT_FAILED(25,"未登录，无需退出登录操作"),
	LOGOUT_SUCCESS(26,"已退出登录");

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
