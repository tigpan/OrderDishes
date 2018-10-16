package com.zhouli.exception;

import com.zhouli.enums.ResultEnum;



public class SellException extends RuntimeException {
	private Integer code;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public SellException(ResultEnum resultEnum) {
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
	}

	public SellException(Integer code, String message) {
		// TODO Auto-generated constructor stub
		super(message);
		this.code = code;
	}
}
