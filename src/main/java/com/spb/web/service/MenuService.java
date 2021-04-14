package com.spb.web.service;

import com.spb.web.domain.Menu;
import com.spb.web.dto.ResultDto;

/**
 * @description:
 * @author: wangpeng
 * @time: 2021/4/14 10:37
 */
public interface MenuService extends BaseService<Menu>{

    ResultDto findListByPage(Integer pageSize, Integer pageNumber, String sortName, String sortType);

}
