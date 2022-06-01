package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Products;
import com.example.demo.form.IndexForm;
import com.example.demo.service.interfaces.ProductService;

@Controller
public class SearchController {
		
		@Autowired
		ProductService productService;
		
		@Autowired
		  HttpSession session;
		
		
		
		@RequestMapping(value ="/search",  params="search")
		public String search(@ModelAttribute("users")  IndexForm form, BindingResult bindingResult, Model model) {
			String keyword;
			if (form.getSearchKey().equals(null) || form.getSearchKey().equals("")) {
				keyword ="";
			}else {
				keyword = form.getSearchKey();
			}
			
			List<Products> products = productService.select(keyword);
			model.addAttribute("productList", products);
			model.addAttribute("count", products.size());
			
			return "menu";
		}
}
