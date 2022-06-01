package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.interfaces.CategoryDao;
import com.example.demo.entity.Categories;
import com.example.demo.service.interfaces.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	
	public List<Categories> getAllCategory(){
		return categoryDao.selectCategory();
	}
}
