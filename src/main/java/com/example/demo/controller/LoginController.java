package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Products;
import com.example.demo.form.IndexForm;
import com.example.demo.service.interfaces.ProductService;
import com.example.demo.service.interfaces.UsersService;

@Controller
public class LoginController {
	
	@Autowired 
	UsersService usersService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/index")
	public String index(@ModelAttribute("users") IndexForm form, Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/execute", method = RequestMethod.POST)
	public String login(@Validated @ModelAttribute("users") IndexForm form, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "index";
		}
		String userName = usersService.loginUser(form.getLoginId(),form.getPass());
		if(!userName.equals(null)) {
			model.addAttribute("LoginMsg", "IDかPASSが一致しません");
			return "index";
		}
		model.addAttribute("userName", userName);
		
		List<Products> products = productService.select("");
		model.addAttribute("productList", products);
		
		return "menu";
	}
}
