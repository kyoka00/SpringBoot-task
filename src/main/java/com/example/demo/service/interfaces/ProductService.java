package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.entity.Products;

public interface ProductService {
	
	public void delete(Integer productId);
	public int insert(Products products);
	public List<Products> select(String searchKey);
	public void update(Products products);
	public List<Object> selectAll();
	public Products findById(Integer id);
}
