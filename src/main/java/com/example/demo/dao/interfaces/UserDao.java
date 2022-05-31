package com.example.demo.dao.interfaces;

import com.example.demo.entity.Users;

public interface UserDao {
	
	public Users loginSearch(String loginId, String password);

}
