package com.zhouli.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceHttpClientImpl;

public class WeChatMpConfig {
	@Autowired
	private WeChatAccountConfig weChatAccountConfig;

	@Bean
	public WxMpService wxMpService() {
		WxMpService wxMpService = new WxMpServiceHttpClientImpl();
		wxMpService.setWxMpConfigStorage(wxConfigProvider());
		return wxMpService;
	}

	@Bean
	public WxMpConfigStorage wxConfigProvider() {
		WxMpInMemoryConfigStorage wxConfigProvider = new WxMpInMemoryConfigStorage();
		wxConfigProvider.setAppId(weChatAccountConfig.getMpAppId());
		System.out.println(weChatAccountConfig.getMpAppId());
		wxConfigProvider.setSecret(weChatAccountConfig.getMpAppSecret());
		System.out.println(wxConfigProvider);
		return wxConfigProvider;
	}
}