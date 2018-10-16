package com.zhouli.service;

import com.zhouli.domain.SellerInfo;

public interface SellerInfoService {
public void save(SellerInfo sellerInfo);
public SellerInfo findByOpenid(String openid);
}
