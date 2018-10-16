package com.zhouli.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import com.zhouli.constant.CookieConstant;
import com.zhouli.constant.RedisConstant;
import com.zhouli.exception.SellerAuthorizeException;
import com.zhouli.utils.CookieUtil;
@Aspect
@Component
public class SellerAuthorizeAspect {
	@Autowired
	StringRedisTemplate redisTemplate;
	// 配置切入点
	@Pointcut("execution(public * com.zhouli.controller.Seller*.* (..))"
			+ "&&!execution(public * com.zhouli.controller.SellerUserController.*(..))")
	public void verify() {
	}
	// 切入点的具体实现
	@Before("verify()")
	public void doVerify() throws SellerAuthorizeException  {
		System.out.println("切面方法 我进来到了切面");
		/* 获得request/response的代码方式 */
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		//查询cookie
		Cookie cookie = CookieUtil.getCookieByName(request, CookieConstant.Token);
		if(cookie==null) {
			throw new SellerAuthorizeException();
		}
		//查询redis token
		String tokenValue =redisTemplate.opsForValue().get(String.format(RedisConstant.Token,cookie.getValue()));
		if(StringUtils.isEmpty(tokenValue)) {
			throw new SellerAuthorizeException();
		}
	}
}
