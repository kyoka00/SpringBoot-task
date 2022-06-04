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
	
	public int delete(Integer productId){
		return productsDao.delete(productId);
	}
	
	public int insert(Products products){
		return productsDao.insert(products);
	}
	
	public List<Products> select(String searchKey){
		var list = productsDao.select(searchKey);
		return list.isEmpty()?null : list;
	}
	public int update(Products products) {
		return productsDao.update(products);
		
	}
	
	public List<Object> selectAll(){
		List<Products> p = select("");
		int count = p.size();
		List<Object> list = new ArrayList<>();
		list.add(p);
		list.add(count);
		
		return list;
		
	}
	
	public Products findById(Integer id){
		var list = productsDao.findById(id);
		return list;
	}
}
