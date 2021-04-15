package com.spb.web.service;

import java.util.List;

import com.spb.web.dto.ResultDto;

public interface BaseService<T>{
	
	public ResultDto findList();
	
	public ResultDto findById(String id);
	
	public ResultDto add(T t);
	
	public ResultDto update(T t);
	
	public ResultDto delete(String id);
	
}