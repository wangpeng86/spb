package com.spb.web.controller;

import com.spb.web.domain.Menu;
import com.spb.web.dto.ResultDto;
import com.spb.web.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: wangpeng
 * @time: 2021/4/14 11:25
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController{

    @Autowired
    MenuService menuService;

    @GetMapping
    public ResultDto findListByPage(@RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                                    @RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
                                    @RequestParam(value = "sortName",  required = false, defaultValue = "createTime") String sortName,
                                    @RequestParam(value = "sortType", required = false, defaultValue = "1") String sortType){
        return menuService.findListByPage(pageSize, pageNumber, sortName, sortType);
    }

    @GetMapping("/{id}")
    public ResultDto findById(@PathVariable String id){
        return menuService.findById(id);
    }

    @PostMapping
    public ResultDto add(@RequestBody Menu menu){
        return menuService.add(menu);
    }

    @PutMapping
    public ResultDto update(@RequestBody Menu menu){
        return menuService.update(menu);
    }

    @DeleteMapping("/{id}")
    public ResultDto delete(@PathVariable String id){
        return menuService.delete(id);
    }

}
