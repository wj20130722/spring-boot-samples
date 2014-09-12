package com.example.myproject.dao;

import java.util.List;

import com.example.myproject.domain.User;

public interface UserDao {
	int save(User user);
	
	List<User> findAll();
	
	User findById(int id);
}
