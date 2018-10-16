package com.zhouli.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.zhouli.domain.ProductCategory;
import com.zhouli.domain.ProductInfo;
import com.zhouli.exception.SellException;
import com.zhouli.form.ProductForm;
import com.zhouli.service.ProductCategoryService;
import com.zhouli.service.ProductInfoService;
import com.zhouli.utils.KeyUtil;

/*
 * չʾ���Ҷ���Ʒ�б�
 */
@Controller
@RequestMapping("/seller/product")
public class SellerProductController {
	@Autowired
	ProductInfoService productInfoService;
	@Autowired
	ProductCategoryService productCategoryService;

	@GetMapping("/list")

	public ModelAndView list(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize, Map<String, Object> map) {
		PageInfo<ProductInfo> pageInfo = productInfoService.findAllProductInfo(pageNum, pageSize);
		map.put("pageInfo", pageInfo);
		return new ModelAndView("templates/product/list", map);
	}

	@GetMapping("/onSale")
	public ModelAndView onSale(@RequestParam(name = "productId") String productId, Map<String, Object> map) {
		System.out.println("ִ��onSale����");
		productInfoService.onSale(productId);
		map.put("url", "../product/list");
		map.put("msg", "��Ʒ�ϼܳɹ�");
		return new ModelAndView("templates/common/success", map);
	}

	@GetMapping("/offSale")
	public ModelAndView offSale(@RequestParam(name = "productId") String productId, Map<String, Object> map) {
		productInfoService.offSale(productId);
		System.out.println("ִ��offSale����");
		map.put("url", "../product/list");
		map.put("msg", "��Ʒ���¼�");
		return new ModelAndView("templates/common/success", map);
	}

	@GetMapping("/index")
	public ModelAndView index(@RequestParam(name = "productId", required = false) String productId,
			Map<String, Object> map) {
		ProductInfo productInfo;
		if (!StringUtil.isEmpty(productId)) {
			productInfo = productInfoService.findOneProductInfo(productId);
			map.put("productInfo", productInfo);
		}
		// ��ѯ������Ŀ
		List<ProductCategory> productCategoryList = productCategoryService.findAll();
		map.put("productCategoryList", productCategoryList);
		System.out.println(productCategoryList);
		return new ModelAndView("templates/product/index", map);
	}

	// ������޸�
	@PostMapping("/save")
	public ModelAndView save(@Valid ProductForm productForm, BindingResult bindingResult, Map<String, Object> map) {
		if (bindingResult.hasErrors()) {
			map.put("msg", bindingResult.getFieldError().getDefaultMessage());
			map.put("url", "../product/index");
			return new ModelAndView("templates/common/error", map);
		}
		System.out.println(productForm.getProductDescription());
		ProductInfo productInfo = new ProductInfo();
		// �����������Ϊ�½���Ʒ
		if (!productForm.getProductId().equals("")) {
			System.out.println("Ϊʲô���ǿյ���");
			productInfo = productInfoService.findOneProductInfo(productForm.getProductId());
		}
		else {
			productForm.setProductId(KeyUtil.genUniqueKey());
		}
		BeanUtils.copyProperties(productForm, productInfo);
		try {
			productInfoService.saveProductInfo(productInfo);
		} catch (SellException e) {
			map.put("msg", e.getMessage());
			map.put("url", "../product/index");
			return new ModelAndView("templates/common/error", map);
		}
		map.put("url", "../product/list");
		return new ModelAndView("templates/common/success", map);
	}

}