package com.spb.web.service;

import org.springframework.data.domain.Page;

import com.spb.web.domain.Role;
import com.spb.web.dto.ResultDto;

public interface RoleService extends BaseService<Role>{

	public ResultDto findListByPage(Integer pageSize, Integer pageNumber, String sortName, String sortType);
	
}
