package com.kurly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kurly.service.ProductService;
import com.kurly.vo.ProductVO;

@Controller
public class ProductController {
	@Autowired
	ProductService service;
	
	@GetMapping("/products")
	public String getProducts(Model model) {
		model.addAttribute("menu_num",0);
		List<ProductVO> productList = service.selectProducts();
		
		model.addAttribute("list", productList);
		return "/products/list";
	}
	
	@GetMapping("/recommend")
	public String getRecommend(Model model) {
		model.addAttribute("menu_num", 2);
		return "/products/recommend";
	}
}
