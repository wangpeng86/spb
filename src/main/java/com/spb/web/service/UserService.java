package com.spb.web.service;

import java.util.Map;

import org.springframework.data.domain.Page;

import com.spb.web.domain.User;

public interface UserService{
	
	public Page<User> findListByPage(Integer pageSize, Integer pageNumber, String sortName, String sortType, String loginName, String phone, Integer status);
	
	public User findById(String id);
	
	public void add(User user);
	
	public void update(User user);
	
	public void delete(String id);
	
}