package com.spb.web.service.impl;

import com.spb.web.domain.Menu;
import com.spb.web.dto.ResultDto;
import com.spb.web.repository.MenuRepository;
import com.spb.web.service.MenuService;
import com.spb.web.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: wangpeng
 * @time: 2021/4/14 10:39
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuRepository menuRepository;

    @Override
    public ResultDto findList() {
        List<Menu> menuList = menuRepository.findAll();
        return ResultUtil.returnSuccess(menuList);
    }

    @Override
    public ResultDto findById(String id) {
        Menu menu = menuRepository.getOne(id);
        return ResultUtil.returnSuccess(menu);
    }

    @Override
    public ResultDto add(Menu menu) {
        menu.setCreateTime(new Date());
        menu.setStatus(1);
        menuRepository.save(menu);
        return ResultUtil.returnSuccess();
    }

    @Override
    public ResultDto update(Menu menu) {
        menuRepository.save(menu);
        return ResultUtil.returnSuccess();
    }

    @Override
    public ResultDto delete(String id) {
        menuRepository.deleteById(id);
        return ResultUtil.returnSuccess();
    }

    @Override
    public ResultDto findListByPage(Integer pageSize, Integer pageNumber, String sortName, String sortType) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, sortName));
        Page<Menu> pageData = menuRepository.findAll(new Specification<Menu>() {
            @Override
            public Predicate toPredicate(Root<Menu> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return null;
            }
        }, pageable);
        return ResultUtil.returnSuccess(pageData);
    }
}
