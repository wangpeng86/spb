package com.spb.web.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.spb.web.domain.Role;
import com.spb.web.dto.ResultDto;
import com.spb.web.repository.RoleRepository;
import com.spb.web.service.BaseService;
import com.spb.web.service.RoleService;
import com.spb.web.utils.ResultUtil;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public List<Role> findList() {
		return roleRepository.findAll();
	}
	
	@Override
	public ResultDto findById(String id) {
		Role role = roleRepository.getOne(id);
		return ResultUtil.returnSuccess(role);
	}
	
	@Override
	public ResultDto add(Role t) {
		t.setCreateTime(new Date());
		t.setStatus(1);
		roleRepository.save(t);
		return ResultUtil.returnSuccess();
	}
	
	@Override
	public ResultDto update(Role role) {
		Role oldRole = roleRepository.getOne(role.getId());
		oldRole.setMenuIds(role.getMenuIds());
		oldRole.setCode(role.getCode());
		oldRole.setName(role.getName());
		roleRepository.save(oldRole);
		return ResultUtil.returnSuccess();
	}
	
	@Override
	public ResultDto delete(String id) {
		roleRepository.deleteById(id);;
		return ResultUtil.returnSuccess();
	}
	
	@Override
	public ResultDto findListByPage(Integer pageSize, Integer pageNumber, String sortName, String sortType) {
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by(sortType.equals("desc") ? Direction.DESC : Direction.ASC , sortName));
		Page<Role> pageData = roleRepository.findAll(new Specification<Role>() {
			
			@Override
			public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				return null;
			}
		}, pageable);
		return ResultUtil.returnSuccess(pageData);
	}
	
}