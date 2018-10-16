package com.zhouli.controller;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.TimeUtil;
import com.zhouli.constant.CookieConstant;
import com.zhouli.constant.RedisConstant;
import com.zhouli.domain.SellerInfo;
import com.zhouli.enums.ResultEnum;
import com.zhouli.service.SellerInfoService;
import com.zhouli.utils.CookieUtil;

@Controller
@RequestMapping("/sell/seller")
public class SellerUserController {
	@Autowired
	SellerInfoService sellerInfoService;
	@Autowired
	StringRedisTemplate redisTemplate;

	// 商家用户登录操作
	@GetMapping("/login")
	public ModelAndView login(HttpServletResponse response, @RequestParam(name = "openid") String openid,
			Map<String, Object> map) {
		// 1.验证openid是否存在于数据库
		SellerInfo sellerInfo = sellerInfoService.findByOpenid(openid);
		if (sellerInfo == null) {
			// 系统中无此商家信息
			map.put("msg", ResultEnum.LOGIN_FAILED.getMessage());
			map.put("url", "../order/list");
			return new ModelAndView("templates/common/error", map);
		}
		// 2.将openid设置为token存储到redis中
		String token = UUID.randomUUID().toString();
		System.out.println(token);
		System.out.println(String.format(RedisConstant.Token, token));
		redisTemplate.opsForValue().set(String.format(RedisConstant.Token, token), openid, RedisConstant.expire,
				TimeUnit.SECONDS);
		System.out.println(redisTemplate.opsForValue().get(String.format(RedisConstant.Token, token)));
		// 3.将token存入Cookies中
		CookieUtil.setCookie(response, CookieConstant.Token, token, CookieConstant.expire);
		return new ModelAndView("redirect:../../seller/order/list");
	}

	// 消除redis token_ 刪除cookie
	@GetMapping("logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		Cookie cookie = CookieUtil.getCookieByName(request, CookieConstant.Token);
		if (cookie == null) {
			map.put("msg", ResultEnum.LOGOUT_FAILED.getMessage());
			map.put("url", "../order/list");
			return new ModelAndView("templates/common/error", map);
		} else {
			redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.Token, cookie.getValue()));
			CookieUtil.setCookie(response, CookieConstant.Token, null, 0);
		}
		map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMessage());
		map.put("url", "../order/list");
		return new ModelAndView("templates/common/success", map);

	}

}
