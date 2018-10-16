package com.zhouli.controller;

import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.zhouli.config.WeChatAccountConfig;
import com.zhouli.enums.ResultEnum;
import com.zhouli.exception.SellException;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;

@Controller
@RequestMapping(value = "/wechat")
public class WeChatController {
	@Autowired
	WxMpService wxMpService;
	@Autowired
	private WeChatAccountConfig weChatAccountConfig;

	// WxMpServiceHttpClientImpl wxMpService = new WxMpServiceHttpClientImpl() ;
	@RequestMapping("/authorize")
	public String authorize(@RequestParam("returnUrl") String returnUrl) {
		String url = "https://zhouli.mynatapp.cc/OrderDishes/wechat/userInfo";
		WxMpInMemoryConfigStorage wxMpConfigStorage = new WxMpInMemoryConfigStorage();
		wxMpConfigStorage.setAppId(weChatAccountConfig.getMpAppId());
		wxMpConfigStorage.setSecret(weChatAccountConfig.getMpAppSecret());
		wxMpService.setWxMpConfigStorage(wxMpConfigStorage);
		String redireUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO,
				URLEncoder.encode(returnUrl));
		return "redirect:" + redireUrl;
	}

	@GetMapping("/userInfo")

	@ResponseBody
	public String userInfo(@RequestParam("code") String code, @RequestParam("state") String returnUrl) {
		String openId = "";
		String accessToken = "";
		try {
			// WxMpServiceHttpClientImpl wxMpService = new WxMpServiceHttpClientImpl();
			WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
			openId = wxMpOAuth2AccessToken.getOpenId();
			accessToken = wxMpOAuth2AccessToken.getAccessToken();
		} catch (WxErrorException e) {
			// TODO Auto-generated catch block
			throw new SellException(ResultEnum.WEXIN_MP_ERROR.getCode(), e.getError().getErrorMsg());
		}
		RestTemplate restTemplate = new RestTemplate();
		String fina = restTemplate.getForObject("https://api.weixin.qq.com/sns/userinfo?access_token=" + accessToken
				+ "&openid=" + openId + "&lang=zh_CN", String.class);
		/* return "redirect:" + returnUrl + "?openid" + openId; */
		return fina;
	}
}
