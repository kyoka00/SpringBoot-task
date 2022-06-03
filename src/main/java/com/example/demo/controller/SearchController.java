package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Categories;
import com.example.demo.entity.Products;
import com.example.demo.form.IndexForm;
import com.example.demo.form.ProductForm;
import com.example.demo.form.SearchForm;
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
		public String index(@ModelAttribute("users") IndexForm indexform, Model model) {
			return "index";
		}
		
		@RequestMapping(value ="logout")
		public String logout(@ModelAttribute("searchForm")  SearchForm searchform, @ModelAttribute("product") ProductForm productform, Model model) {
			session.invalidate();
			return "logout";
		}
		@RequestMapping(value ="/login", params="login" , method = RequestMethod.POST)
		public String login(@Validated @ModelAttribute("users")  IndexForm indexform, @ModelAttribute("searchForm") SearchForm searchform, BindingResult bindingResult, Model model) {
			if(bindingResult.hasErrors()) {
				return "index";
			}
		
			String userName = usersService.loginUser(indexform.getLoginId(),indexform.getPass());
			
			if(userName.equals(null) || userName.equals("")) {
				model.addAttribute("LoginMsg", "IDかPASSが一致しません");
				return "index";
			}else {
				session.setAttribute("userName",userName);
				
				List<Products> products = productService.select("");
				model.addAttribute("productList", products);
				model.addAttribute("count", products.size());
				
				List<Categories> categoryList = categoryService.getAllCategory();
				session.setAttribute("categoryList",categoryList);
				return "menu";
			}
			
		}
		
		@GetMapping(value ="/menu")
		public String menu(@ModelAttribute("users") IndexForm indexform,@ModelAttribute("searchForm")  SearchForm searchform, @ModelAttribute("product") ProductForm productform, Model model) {
			List<Products> products = productService.select("");
			model.addAttribute("productList", products);
			model.addAttribute("count", products.size());
			return "menu";
		}
		
		@RequestMapping(value ="/search" ,method=RequestMethod.GET)
		
		public String search(@ModelAttribute("users") IndexForm form, @ModelAttribute("searchForm")  SearchForm searchform, BindingResult bidingResult,Model model) {
			String searchKey = searchform.getSearchKey();
			if(searchKey.equals(null)) {
				searchKey="";
			}
			
			List<Products> products = productService.select(searchKey);
			model.addAttribute("productList", products);
			model.addAttribute("count", products.size());
			
			return "menu";
		}
		
		@GetMapping(value ="/insertMenu")
		public String category(@ModelAttribute("searchForm")  SearchForm searchform, @ModelAttribute("product") ProductForm productform,Model model) {
			return "insert";
		}
		
		
		
		
		
		@PostMapping(value="/insertSubmit" )
		public String insert(@Validated @ModelAttribute("product") ProductForm form, @ModelAttribute("searchForm") SearchForm searchForm,BindingResult bindingResult, Model model) {
			if(bindingResult.hasErrors()) {
				return "insert";
			}
			
			var idCheck =  productService.findById(form.getProductId());
			if(idCheck != null) {
				model.addAttribute("insertMsg", "商品IDは既に使用されています。");
				return "insert";
			}
			
			
			Products p= new Products(form.getProductId(), form.getProductName(), form.getCategoryId(),form.getPrice(), form.getDescription());
			int count  = productService.insert(p);
			model.addAttribute("menuMsg",count +"件登録しました");
			List<Object> productList = productService.selectAll();
			model.addAttribute("productList", productList.get(0));
			model.addAttribute("count", productList.get(1));
			return "menu";
			
		}
		
		@GetMapping("updateMenu")
		public String update(@ModelAttribute("product") ProductForm form,@ModelAttribute("searchForm") SearchForm searchForm, BindingResult bindingResult, Model model) {
			return "updateInput";
		}
}
