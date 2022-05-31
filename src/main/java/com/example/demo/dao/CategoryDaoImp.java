package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.interfaces.CategoryDao;
import com.example.demo.entity.Categories;

@Repository
public class CategoryDaoImp implements CategoryDao{
	
	private static final String SQL_SELECT_CATEGORY= "SELECT * FROM categories";
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public List<Categories> selectCategory(){
		
		String sql = SQL_SELECT_CATEGORY;
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		List<Categories>resultList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Categories>(Categories.class));
		
		return resultList.isEmpty()? null :resultList;
	}

}
