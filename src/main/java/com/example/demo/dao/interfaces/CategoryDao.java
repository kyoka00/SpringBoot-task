package com.example.demo.dao.interfaces;

import java.util.List;

import com.example.demo.entity.Categories;

public interface CategoryDao {
	
	public List<Categories> selectCategory();
}
