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

import com.zhouli.domain.ProductCategory;
import com.zhouli.exception.SellException;
import com.zhouli.form.CategoryForm;
import com.zhouli.service.ProductCategoryService;

/*
 * 卖家商品类目
 */
@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {
	@Autowired
	ProductCategoryService productCategoryService;

	/* 所有商品类目查询 */
	@GetMapping("list")
	public ModelAndView list(Map<String, Object> map) {
		List productCategoryLsit = productCategoryService.findAll();
		System.out.println("不是controller方法的错");
		map.put("productCategoryList", productCategoryLsit);
		return new ModelAndView("templates/category/list", map);
	}

	@GetMapping("index")
	public ModelAndView index(@RequestParam(name = "categoryId", required = false) Integer categoryId,
			Map<String, Object> map) {
		ProductCategory productCategory = null;
		System.out.println(categoryId);
		if (categoryId != null) {
			productCategory = productCategoryService.findOneById(categoryId);
			map.put("productCategory", productCategory);
		}
		System.out.println("productCategory" + productCategory);
		return new ModelAndView("templates/category/index", map);
	}

	@PostMapping("save")
	public ModelAndView save(@Valid CategoryForm categoryForm, BindingResult bindingResult, Map<String, Object> map) {
		ProductCategory productCategory = new ProductCategory();
		System.out.println("1111111111");
		if (bindingResult.hasErrors()) {
			map.put("msg", bindingResult.getFieldError().getDefaultMessage());
			map.put("url", "../category/index");
			return new ModelAndView("templates/common/error", map);
		}
		System.out.println("2222222222");
		// 修改商品类目
		try {
			if (categoryForm.getCategoryId() != null) {
				productCategory = productCategoryService.findOneById(categoryForm.getCategoryId());
				BeanUtils.copyProperties(categoryForm, productCategory);
				productCategoryService.update(productCategory);
				System.out.println("3333333333");
			}
			// 新增商品类目
			else {
				System.out.println("5555555555");
				BeanUtils.copyProperties(categoryForm, productCategory);
				productCategoryService.save(productCategory);
				System.out.println("4444444");
			}
		} catch (Exception e) {
			System.out.println("6666666666666");
			map.put("msg", e.getMessage());
			map.put("url", "../category/list");
			return new ModelAndView("templates/common/error", map);
		}
		map.put("msg", "操作成功");
		map.put("url", "../category/list");
		System.out.println("7777777777777");
		return new ModelAndView("templates/common/success", map);
	}
}
