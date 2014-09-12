package com.example.myproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.myproject.dao.UserDao;
import com.example.myproject.domain.User;

@Service
public class UserService {
	
	@Autowired
	@Qualifier("userRespostory")
	private UserDao userDao;
	
	
	@Transactional
	public List<User> findAll()
	{
		//userDao.save(new User("xiaojun", 10, 10));
		//userDao.save(new User("xiaoqiang", 20, 10));
		return userDao.findAll();
	}
}
