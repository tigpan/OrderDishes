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
	// ���������
	@Pointcut("execution(public * com.zhouli.controller.Seller*.* (..))"
			+ "&&!execution(public * com.zhouli.controller.SellerUserController.*(..))")
	public void verify() {
	}
	// �����ľ���ʵ��
	@Before("verify()")
	public void doVerify() throws SellerAuthorizeException  {
		System.out.println("���淽�� �ҽ�����������");
		/* ���request/response�Ĵ��뷽ʽ */
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		//��ѯcookie
		Cookie cookie = CookieUtil.getCookieByName(request, CookieConstant.Token);
		if(cookie==null) {
			throw new SellerAuthorizeException();
		}
		//��ѯredis token
		String tokenValue =redisTemplate.opsForValue().get(String.format(RedisConstant.Token,cookie.getValue()));
		if(StringUtils.isEmpty(tokenValue)) {
			throw new SellerAuthorizeException();
		}
	}
}
