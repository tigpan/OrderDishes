package com.zhouli.handle;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.zhouli.VO.ResultVO;
import com.zhouli.exception.SellException;
import com.zhouli.exception.SellerAuthorizeException;
import com.zhouli.utils.ResultVOUtil;

@RestControllerAdvice
public class SellerExceptionHandler {

	@ExceptionHandler(value=SellerAuthorizeException.class)
	public ModelAndView handlerAuthorizeException(){
		//跳转到登录界面
		return new ModelAndView("redirect:www.baidu.com");
	}
	@ExceptionHandler(value=SellException.class)
	@ResponseBody
	public ResultVO handlerSellException(SellException e) {
		return ResultVOUtil.error(e.getCode(), e.getMessage());
	}
}
