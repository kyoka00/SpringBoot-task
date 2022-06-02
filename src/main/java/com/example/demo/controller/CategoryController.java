package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Categories;
import com.example.demo.form.IndexForm;
import com.example.demo.service.interfaces.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value ="/category", params = "categoryBtn")
	public String category(@ModelAttribute("users") IndexForm form, BindingResult bindingResult, Model model) {
		List<Categories> categoryList = categoryService.getAllCategory();
		model.addAttribute("categoryList",categoryList);
		return "insert";
	}
}

