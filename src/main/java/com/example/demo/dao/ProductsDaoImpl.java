package com.example.demo.dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.interfaces.ProductsDao;
import com.example.demo.entity.Products;

@Repository
public class ProductsDaoImpl implements ProductsDao{
	
	
	private static final String SQL_WHERE = "SELECT p.product_id, p.name AS product_name,"
			+ "c.id AS category_id,c.name AS category_name, p.price, p.description "
			+ "FROM products p JOIN categories c ON p.category_id = c.id WHERE p.name LIKE :keyword OR "
			+ "c.name LIKE :keyword ORDER BY p.product_id";
	
	private static final String SQL_INSERT = "INSERT INTO products (product_id, category_id, name, price, description, created_at)"
			+ " VALUES (:productId, :categoryId, :productName, :price, :description, :createdAt)" ;
	
	private static final String SQL_UPDATE ="UPDATE products SET product_id = :productId,  name= :productName, "
			+ "price = :price, category_id = :categoryId, description= :description, updated_at = :updatedAt "
			+ "WHERE product_id = :idInsert";
	
	private static final String SQL_DELETE ="DELETE FROM products WHERE product_id = :productId";
	private static final String SQL_FINDBYID= "SELECT p.product_id, p.name AS product_name,"
			+ "c.id AS category_id,c.name AS category_name, p.price, p.description "
			+ "FROM products p JOIN categories c ON p.category_id = c.id WHERE p.product_id= :id";
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public List<Products> select(String searchKey){
		String sql = SQL_WHERE;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("keyword", '%'+searchKey+ '%');
		
		List<Products> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Products>(Products.class));
		
		return resultList.isEmpty() ? null :resultList;
	}
	
	/*
	 * public List<Products> countSelect (String searchKey) { String sql =
	 * SQL_COUNT;
	 * 
	 * MapSqlParameterSource param = new MapSqlParameterSource();
	 * param.addValue("likeProductName", searchKey);
	 * param.addValue("likeCategoryName", searchKey);
	 * 
	 * List<Products> resultList = jdbcTemplate.query(sql, param, new
	 * BeanPropertyRowMapper<Products>(Products.class));
	 * 
	 * return resultList.isEmpty() ? null :resultList.get(0); }
	 */
	public int insert(Products products) {
		String sql = SQL_INSERT;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("productId",products.getProductId());
		param.addValue("categoryId", products.getCategoryId());
		param.addValue("productName", products.getProductName());
		param.addValue("price", products.getPrice());
		param.addValue("description", products.getDescription());
		param.addValue("createdAt", new Timestamp(System.currentTimeMillis()));

		 return jdbcTemplate.update(sql, param);

	}

	public int update(Products products) {
		String sql = SQL_UPDATE;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("productId",products.getProductId());
		param.addValue("categoryId", products.getCategoryId());
		param.addValue("productName", products.getProductName());
		param.addValue("price", products.getPrice());
		param.addValue("description", products.getDescription());
		param.addValue("updatedAt", new Timestamp(System.currentTimeMillis()));
		param.addValue("idInsert", products.getProductId());

		return jdbcTemplate.update(sql, param);
	}

	public int delete(Integer productId) {
		String sql = SQL_DELETE;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("productId",productId);
		
		return jdbcTemplate.update(sql, param);
	}
	
	public Products findById(Integer id){
		String sql = SQL_FINDBYID;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id",id);
		
		List<Products> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Products>(Products.class));
		
		return resultList.isEmpty() ? null : resultList.get(0);
	}
}
