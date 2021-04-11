package com.spb.web.service;

import java.util.Map;

import org.springframework.data.domain.Page;

import com.spb.web.domain.User;
import com.spb.web.dto.ResultDto;

public interface UserService{
	
	public Page<User> findListByPage(Integer pageSize, Integer pageNumber, String sortName, String sortType, String loginName, String phone, Integer status);
	
	public User findById(String id);
	
	public ResultDto add(User user);
	
	public ResultDto update(User user);
	
	public ResultDto delete(String id);
	
}