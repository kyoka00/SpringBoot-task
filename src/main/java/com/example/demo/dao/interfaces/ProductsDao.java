package com.example.demo.dao.interfaces;

import java.util.List;

import com.example.demo.entity.Products;

public interface ProductsDao {
	
	public List<Products> select(String searchKey);
	//public int countSelect(String a); //これはDB使わなくてもいけるかも
	public int insert(Products products);
	public int update(Products products);
	public int delete(Integer productId);
	public Products findById(Integer produtId);

}
