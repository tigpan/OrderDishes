package com.zhouli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WeiXinController {
	@GetMapping("/auth")
	public String auth(@RequestParam("code") String code) {
		System.out.println("׼������navҳ��");
		return "templates/common/nav";
	}

}
