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

@RestController
@RequestMapping("/role")
public class RoleController extends BaseController{
	
	@Autowired
	RoleService roleService;
	
	@GetMapping
	public ResultDto findListByPage(@RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
			@RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "sortName",  required = false, defaultValue = "createTime") String sortName,
			@RequestParam(value = "sortType", required = false, defaultValue = "1") String sortType) {
		return roleService.findListByPage(pageSize, pageNumber, sortName, sortType);
	}
	
	@GetMapping("/{id}")
	public ResultDto findById(@PathVariable String id) {
		return roleService.findById(id);
	}
	
	@PostMapping
	public ResultDto add(@RequestBody Role role) {
		return roleService.add(role);
	}
	
	@PutMapping
	public ResultDto update(@RequestBody Role role) {
		return roleService.update(role);
	}
	
	@DeleteMapping("/{id}")
	public ResultDto deleteById(@PathVariable String id) {
		return roleService.delete(id);
	}
	
}