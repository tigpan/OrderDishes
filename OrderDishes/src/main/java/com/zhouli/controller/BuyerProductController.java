package com.zhouli.controller;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhouli.VO.ProductInfoVO;
import com.zhouli.VO.ProductVO;
import com.zhouli.VO.ResultVO;
import com.zhouli.domain.ProductCategory;
import com.zhouli.domain.ProductInfo;
import com.zhouli.service.ProductCategoryService;
import com.zhouli.service.ProductInfoService;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.impl.WxMpServiceHttpClientImpl;
//
@Controller
@RequestMapping
public class BuyerProductController {

	@Autowired(required = false)
	ProductVO productVO;

	@Autowired(required = false)
	ProductInfoVO productInfoVO;

	@Autowired(required = false)
	List<ProductInfoVO> productInfoVOList;
	@Autowired
	ProductInfoService productInfoService;

	@Autowired
	ProductCategoryService productCategoryService;
//
	@RequestMapping("codee")
	@ResponseBody
	/* Model哈哈拷装锟斤拷实锟斤拷锟洁，锟斤拷锟斤拷锟轿猺equest */
	public String list(Model model) {
		ResultVO resultVO = new ResultVO();
		resultVO.setCode(1);
		model.addAttribute("resultVO", resultVO);
		return "兄弟给个面子吧，你就出现吧";
	}

	@RequestMapping("/authorize222")
	
	public String authorize(/*@RequestParam("returnUrl")*/ String returnUrl) {
		System.out.println("我進來了");
		WxMpServiceHttpClientImpl wxMpService = new WxMpServiceHttpClientImpl();
		String url = "https://zhouli.mynatapp.cc/OrderDishes/wechat/userInfo";
		System.out.println(wxMpService);
		String redireUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO,
				URLEncoder.encode(returnUrl));
		return "www.baidu.com";
	}

	/* 锟斤拷锟斤拷锟狡凤拷斜锟� */
	@RequestMapping("/list4")
	@ResponseBody
	public ResultVO list4() {
		ResultVO resultVO = new ResultVO();
		/*
		 * 1.锟斤拷询锟斤拷锟斤拷锟较硷拷锟斤拷品
		 */
		/*
		 * List<ProductInfo> productInfoList = productInfoService.findUpProductInfo(0);
		 */
		List<ProductInfo> productInfoList = productInfoService.findUpProductInfo(0);
		System.out.println("" + productInfoList);
		/*
		 * 2.锟斤拷询锟斤拷目
		 */
		List<Integer> categoryTypeList = new ArrayList<>();
		for (ProductInfo productInfo : productInfoList) {
			System.out.println("productInfo:==" + productInfo);
			System.out.println("productInfo.getCategoryType():===" + productInfo.getCategoryType());
			categoryTypeList.add(productInfo.getCategoryType());
			System.out.println("" + categoryTypeList);
		}
		List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);
		/*
		 * 3.锟斤拷锟斤拷拼装
		 */
		List<ProductVO> productVOList = new ArrayList<>();
		for (ProductCategory productCategory : productCategoryList) {
			ProductVO productVO = new ProductVO();
			productVO.setCategoryName(productCategory.getCategoryName());
			productVO.setCategoryType(productCategory.getCategoryType());
			productVO.setProductInfoVOList(productInfoVOList);
			System.out.println("productVO:==" + productVO);
			System.out.println("productInfoVOList:===" + productInfoVOList);
			List<ProductInfoVO> productInfoVOList = new ArrayList<>();
			for (ProductInfo productInfo : productInfoList) {
				if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
					ProductInfoVO productInfoVO = new ProductInfoVO();
					BeanUtils.copyProperties(productInfo, productInfoVO);
					productInfoVOList.add(productInfoVO);
				}
				productVO.setProductInfoVOList(productInfoVOList);

			}
			productVOList.add(productVO);
		}
		resultVO.setCode(0);
		resultVO.setData(productCategoryList);
		resultVO.setMsg("锟缴癸拷");
		return resultVO;
	}

	@RequestMapping("/list3")
	@ResponseBody
	public PageInfo<ProductInfo> list3(ResultVO resultVO) {
		/*
		 * resultVO.setCode(22); ProductVO productVO = new ProductVO(); ProductInfoVO
		 * productInfoVO = new ProductInfoVO();
		 * productInfoVO.setProductIcon("http:xxxxx/3333.jpg");
		 * productVO.setProductInfoVOList(Arrays.asList(productInfoVO));
		 * resultVO.setData(Arrays.asList(productVO)); resultVO.setMsg("锟斤拷锟斤拷");
		 */
		return productInfoService.findAllProductInfo(1, 3);
	}
}
