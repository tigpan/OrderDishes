package com.zhouli.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhouli.domain.SellerInfo;
import com.zhouli.mapper.SellerInfoMapper;
import com.zhouli.service.SellerInfoService;
@Service
public class SellerInfoServiceImpl implements SellerInfoService{
@Autowired
SellerInfoMapper sellerInfoMapper;
	@Override
	public void save(SellerInfo sellerInfo) {
		// TODO Auto-generated method stub
		sellerInfoMapper.save(sellerInfo);
	}

	@Override
	public SellerInfo findByOpenid(String openid) {
		// TODO Auto-generated method stub
		return sellerInfoMapper.findByOpenid(openid);
	}

}
