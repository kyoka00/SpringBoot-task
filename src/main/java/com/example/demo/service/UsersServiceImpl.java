package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.interfaces.UserDao;
import com.example.demo.entity.Users;
import com.example.demo.service.interfaces.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UserDao userDao;
	
	public String loginUser(String loginId, String password) {
		
		Users u = userDao.loginSearch(loginId, password);
		
		return u==null ? "": u.getName();
	}
	
	/*public boolean loginCheck(String loginId, String password) {
		Users u = userDao.loginSearch(loginId, password);
		if(u.getPassword() != null) {
			
		}
	}*/
}
