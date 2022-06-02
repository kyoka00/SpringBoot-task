package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.interfaces.ProductsDao;
import com.example.demo.entity.Products;
import com.example.demo.service.interfaces.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductsDao productsDao;
	
	public void delete(Integer productId){
		productsDao.delete(productId);
	}
	
	public void insert(Products products){
		productsDao.insert(products);
	}
	
	public List<Products> select(String searchKey){
		return productsDao.select(searchKey);
	}
	public void update(Products products) {
		productsDao.update(products);
		
	}
	
	public List<Object> selectAll(){
		List<Products> p = select("");
		int count = p.size();
		List<Object> list = new ArrayList<>();
		list.add(p);
		list.add(count);
		
		return list;
		
	}
}
