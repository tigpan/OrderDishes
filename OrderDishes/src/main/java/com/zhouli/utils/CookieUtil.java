package com.zhouli.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	
	public static void setCookie(HttpServletResponse response,String name,String value,int time) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		cookie.setMaxAge(time);
		response.addCookie(cookie);
	}
	//把cookie放到cookieMap里面
	public static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
	//根据名字获取cookie
	 public static Cookie getCookieByName(HttpServletRequest request, String name) {
	        Map<String, Cookie> cookieMap = ReadCookieMap(request);
	        if (cookieMap.containsKey(name)) {
	            Cookie cookie = (Cookie) cookieMap.get(name);
	            return cookie;
	        } else {
	            return null;
	        }
	    }

}
