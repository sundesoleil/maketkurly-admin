package com.kurly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kurly.service.ProductService;
import com.kurly.vo.ProductVO;
import com.kurly.vo.SearchVO;
import com.kurly.vo.SimpleProductVO;

@Controller
public class ProductController {
	@Autowired
	ProductService service;
	
	@GetMapping("/products")
	public String getProducts(Model model) {
		model.addAttribute("menu_num",0);
		List<ProductVO> productList = service.selectProducts(null);
		
		model.addAttribute("list", productList);
		return "/products/list";
	}
	
	@GetMapping("/recommend")
	public String getRecommend(Model model) {
		model.addAttribute("menu_num", 2);
		
		List<SimpleProductVO> recommendList = service.selectRecommendList();
		
		model.addAttribute("recommendList", recommendList);
		
		return "/products/recommend";
	}
	@GetMapping("/md_recommend")
	public String getMDRecommend(Model model) {
		model.addAttribute("menu_num", 3);
		
		List<SimpleProductVO> recommendList = service.selectMDRecommendList();
		model.addAttribute("recommendList", recommendList);
		
		return "/products/md_recommend";
	}
	@GetMapping("/special")
	public String getSpecial(Model model) {
		model.addAttribute("menu_num", 5);
		
		List<SimpleProductVO> recommendList = service.selectSpecialList();
		model.addAttribute("recommendList", recommendList);
		
		return "/products/special";
	}
	@GetMapping("/afford")
	public String getAfford(Model model) {
		model.addAttribute("menu_num", 6);
		
		List<SimpleProductVO> recommendList = service.selectAffordList();
		model.addAttribute("recommendList", recommendList);
		
		return "/products/afford";
	}
}
