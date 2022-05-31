package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.interfaces.ProductsDao;
import com.example.demo.service.interfaces.UpdateService;
@Service
public class UpdateServiceImp implements UpdateService{
	@Autowired
	private ProductsDao productsDao;
	
	public void update(Integer productId, Integer categoryId, String productName, Integer price,  String description) {
		productsDao.update(productId, categoryId, productName, price, description);
		
	}
}
