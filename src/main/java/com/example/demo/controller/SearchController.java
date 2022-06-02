package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Categories;
import com.example.demo.entity.Products;
import com.example.demo.form.IndexForm;
import com.example.demo.form.ProductForm;
import com.example.demo.service.interfaces.CategoryService;
import com.example.demo.service.interfaces.ProductService;
import com.example.demo.service.interfaces.UsersService;

@Controller
public class SearchController {

	@Autowired 
	UsersService usersService;
	
		@Autowired
		ProductService productService;
		
		@Autowired
		  HttpSession session;
		
		@Autowired
		CategoryService categoryService;
		
		@RequestMapping(value={"/","/index"})
		public String index(@ModelAttribute("users") IndexForm form, Model model) {
			return "index";
		}
		
		@RequestMapping(value ="logout")
		public String logout(@ModelAttribute("users") IndexForm form) {
			session.invalidate();
			return "index";
		}
		
		@RequestMapping(value ="/excute", params="login" , method = RequestMethod.POST)
		public String login(@Validated @ModelAttribute("users")  IndexForm form, BindingResult bindingResult, Model model) {
			if(bindingResult.hasErrors()) {
				return "index";
			}
		
			String userName = usersService.loginUser(form.getLoginId(),form.getPass());
			
			if(userName.equals(null) || userName.equals("")) {
				model.addAttribute("LoginMsg", "IDかPASSが一致しません");
				return "index";
			}else {
				session.setAttribute("userName",userName);
				
				List<Products> products = productService.select("");
				model.addAttribute("productList", products);
				model.addAttribute("count", products.size());
				return "menu";
			}
			
		}
		
		@RequestMapping(value ="/menu")
		public String menu(Model model) {
			List<Products> products = productService.select("");
			model.addAttribute("productList", products);
			model.addAttribute("count", products.size());
			return "menu";
		}
		
		@RequestMapping(value ="/search")
		public String search(@RequestParam( value = "searchKey")  String searchKey, Model model) {
			
			if (searchKey.equals(null) || searchKey.equals("")) {
				searchKey ="";
			}
			
			List<Products> products = productService.select(searchKey);
			model.addAttribute("productList", products);
			model.addAttribute("count", products.size());
			
			return "menu";
		}
		
		@RequestMapping(value ="/category", params = "insertBtn")
		public String category(@ModelAttribute("users") IndexForm form, Model model) {
			List<Categories> categoryList = categoryService.getAllCategory();
			model.addAttribute("categoryList",categoryList);
			return "insert";
		}
		
		
		
		
		
		@PostMapping(value="insert", params ="insertSubmit")
		public String insert(@Validated @ModelAttribute("products") ProductForm form, BindingResult bindingResult, Model model) {
			if(bindingResult.hasErrors()) {
				return "insert";
			}
			
			Products p= new Products(form.getProductId(), form.getProductName(), form.getCategoryId(),form.getPrice(), form.getDescription());
			productService.update(p);
			
			List<Object> productList = productService.selectAll();
			model.addAttribute("productList", productList.get(0));
			model.addAttribute("count", productList.get(1));
			return "menu";
			
		}
}
