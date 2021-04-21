package com.spb.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spb.web.domain.Role;
import com.spb.web.dto.ResultDto;
import com.spb.web.service.RoleService;
import com.spb.web.utils.ResultUtil;

@RestController
@RequestMapping("/role")
public class RoleController extends BaseController{
	
	@Autowired
	RoleService roleService;

	@GetMapping("/list")
	public ResultDto findList(){
		return roleService.findList();
	}

	@GetMapping
	public ResultDto findListByPage(@RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
			@RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "sortName",  required = false, defaultValue = "createTime") String sortName,
			@RequestParam(value = "sortType", required = false, defaultValue = "1") String sortType) {
		try {
			return roleService.findListByPage(pageSize, pageNumber, sortName, sortType);
		}catch(Exception e) {
			return ResultUtil.returnFail(e.getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResultDto findById(@PathVariable String id) {
		try {
			return roleService.findById(id);
		}catch(Exception e) {
			return ResultUtil.returnFail(e.getMessage());
		}
	}
	
	@PostMapping
	public ResultDto add(@RequestBody Role role) {
		try {
			return roleService.add(role);
		}catch(Exception e) {
			return ResultUtil.returnFail(e.getMessage());
		}
	}
	
	@PutMapping
	public ResultDto update(@RequestBody Role role) {
		try {
			return roleService.update(role);
		}catch(Exception e) {
			return ResultUtil.returnFail(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResultDto deleteById(@PathVariable String id) {
		try {
			return roleService.delete(id);
		}catch(Exception e) {
			return ResultUtil.returnFail(e.getMessage());
		}
	}
	
}