package com.spb.web.service.impl;

import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import org.springframework.util.StringUtils;

import com.google.common.collect.Maps;
import com.spb.web.domain.User;
import com.spb.web.dto.ResultDto;
import com.spb.web.repository.UserRepository;
import com.spb.web.service.UserService;
import com.spb.web.utils.ResultUtil;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Page<User> findListByPage(Integer pageSize, Integer pageNumber, String sortName, String sortType, String loginName, String phone, Integer status) {
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by(Direction.ASC, sortName));
		return userRepository.findAll(new Specification<User>() {
			
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				List<Predicate> predicateList = new ArrayList<>();
				if(!StringUtils.isEmpty(loginName)) {
					predicateList.add(criteriaBuilder.equal(root.get("loginName"), loginName));
				}
				if(!StringUtils.isEmpty(phone)) {
					predicateList.add(criteriaBuilder.equal(root.get("phone"), phone));
				}
				if(!StringUtils.isEmpty(status)) {
					predicateList.add(criteriaBuilder.equal(root.get("status"), status));
				}
				Predicate[] predicates = new Predicate[predicateList.size()];
				return criteriaBuilder.and(predicateList.toArray(predicates));
			}
		}, pageable);
	}
	
	@Override
	public User findById(String id) {
		return userRepository.getOne(id);
	}
	
	@Override
	public ResultDto add(User user) {
		user.setPassword("1");
		user.setCreateTime(new Date());
		user.setStatus(1);
		userRepository.save(user);
		return ResultUtil.returnSuccess();
	}
	
	@Override
	public ResultDto update(User user) {
		userRepository.save(user);
		return ResultUtil.returnSuccess();
	}
	
	@Override
	public ResultDto delete(String id) {
		userRepository.deleteById(id);
		return ResultUtil.returnSuccess();
	}
	
	
}