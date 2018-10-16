package com.zhouli.mapper;

import com.zhouli.domain.SellerInfo;

public interface SellerInfoMapper {
	// 发现一个卖家信息
	public SellerInfo findByOpenid(String openid);

	// 保存一个卖家信息
	public void save(SellerInfo sellerInfo);
}
