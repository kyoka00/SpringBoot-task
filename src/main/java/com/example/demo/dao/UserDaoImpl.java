package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.interfaces.UserDao;
import com.example.demo.entity.Users;

@Repository
public class UserDaoImpl implements UserDao{
	
	private static final String SQL_LOGINSEARCH="SELECT login_id, password, name FROM users WHERE login_id = :id AND password= :password";
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
	public Users loginSearch(String id, String pass) {
		String sql = SQL_LOGINSEARCH;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);
		param.addValue("password", pass);
		
		List<Users>resultList = jdbcTemplate.query(sql,param, new BeanPropertyRowMapper<Users>(Users.class));
		return resultList.isEmpty()? null: resultList.get(0);
	}
}
