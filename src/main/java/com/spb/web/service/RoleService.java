package com.spb.web.service;

import org.springframework.data.domain.Page;

import com.spb.web.domain.Role;

public interface RoleService {

	public Page<Role> findListByPage();
	
}
