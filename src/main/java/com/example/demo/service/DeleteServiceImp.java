package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.interfaces.ProductsDao;
import com.example.demo.service.interfaces.DeleteService;

@Service
public class DeleteServiceImp implements DeleteService{
	@Autowired
	private ProductsDao productsDao;
	
	public void delete(Integer productId){
		productsDao.delete(productId);
	}
}
