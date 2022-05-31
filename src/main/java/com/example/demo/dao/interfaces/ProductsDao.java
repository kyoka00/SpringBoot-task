package com.example.demo.dao.interfaces;

import java.util.List;

import com.example.demo.entity.Products;

public interface ProductsDao {
	
	public List<Products> select(String searchKey);
	//public int countSelect(String a); //これはDB使わなくてもいけるかも
	public void insert(Integer productId, Integer categoryId, String productName, Integer price, String description);
	public void update(Integer productId, Integer categoryId, String productName, Integer price, String description);
	public void delete(Integer productId);

}
