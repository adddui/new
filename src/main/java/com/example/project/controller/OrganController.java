package com.example.project.controller;

import com.example.project.entity.Organ;
import com.example.project.service.OrganDaoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api
public class OrganController {
    @Autowired
    OrganDaoServiceImpl organDaoService;

    @RequestMapping(value = "findAllOrgan")
    @ApiOperation("查找所有")
    List<Organ> findAll() {
        return organDaoService.findAll();
    }

    @RequestMapping(value = "addOrgan")
    @ApiOperation("新增数据")
        //新增数据
    int add(Organ organ) {
        return organDaoService.add(organ);
    }

    @RequestMapping(value = "deleteOrgan")
    @ApiOperation("删除数据")
        //删除数据
    int delete(int id) {
        return organDaoService.delete(id);
    }

    @RequestMapping(value = "findOrganById")
    @ApiOperation("根据id查找")
        //根据id查找
    Organ findUserById(int id) {
        return organDaoService.findOrganById(id);
    }

    @RequestMapping(value = "updateOrgan")
    @ApiOperation("更新数据")
        //更新数据
    int update(Organ organ) {
        return organDaoService.update(organ);
    }
}
