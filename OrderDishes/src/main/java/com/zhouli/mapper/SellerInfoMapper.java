package com.zhouli.mapper;

import com.zhouli.domain.SellerInfo;

public interface SellerInfoMapper {
	// ����һ��������Ϣ
	public SellerInfo findByOpenid(String openid);

	// ����һ��������Ϣ
	public void save(SellerInfo sellerInfo);
}
