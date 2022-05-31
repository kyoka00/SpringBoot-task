package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.entity.Products;

public interface SearchService {
	public List<Products> select(String searchKey);
}
