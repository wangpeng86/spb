package com.spb.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spb.web.domain.User;
import com.spb.web.dto.ResultDto;
import com.spb.web.enums.UserStatusEnum;
import com.spb.web.service.UserService;
import com.spb.web.utils.ResultUtil;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResultDto findListByPage(@RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
			@RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "sortName",  required = false, defaultValue = "createTime") String sortName,
			@RequestParam(value = "sortType", required = false, defaultValue = "1") String sortType,
			@RequestParam(value = "loginName", required = false) String loginName,
			@RequestParam(value = "phone", required = false) String phone,
			@RequestParam(value = "status", required = false) Integer status){
		try {
			return userService.findListByPage(pageSize, pageNumber, sortName, sortType, loginName, phone, status);
		}catch(Exception e) {
			return ResultUtil.returnFail(e.getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResultDto findById(@PathVariable String id) {
		try {
			return userService.findById(id);	
		}catch (Exception e) {
			return ResultUtil.returnFail(e.getMessage());
		}
	}
	
	@PostMapping
	public ResultDto add(@RequestBody User user) {
		try {
			return userService.add(user);
		}catch (Exception e) {
			return ResultUtil.returnFail(e.getMessage());
		}
	}
	
	@PutMapping
	public ResultDto update(@RequestBody User user) {
		try {
			return userService.update(user);
		}catch (Exception e) {
			return ResultUtil.returnFail(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResultDto deleteById(@PathVariable String id) {
		try {
			return userService.delete(id);
		}catch (Exception e) {
			return ResultUtil.returnFail(e.getMessage());
		}
	}
	
}