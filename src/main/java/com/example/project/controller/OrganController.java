package com.example.project.controller;

import com.example.project.entity.Organ;
import com.example.project.service.OrganDaoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api
public class OrganController {
    @Autowired
    OrganDaoServiceImpl organDaoService;

    @PostMapping(value = "findAllOrgan")
    @ApiOperation("查找所有Organ")
    List<Organ> findAll() {
        return organDaoService.findAll();
    }

    @PostMapping(value = "addOrgan")
    @ApiOperation("新增Organ数据")
        //新增数据
    int add(Organ organ) {
        return organDaoService.add(organ);
    }

    @PostMapping(value = "deleteOrgan")
    @ApiOperation("删除Organ数据")
        //删除数据
    int delete(int id) {
        return organDaoService.delete(id);
    }

    @PostMapping(value = "findOrganById")
    @ApiOperation("根据id查找Organ")
        //根据id查找
    Organ findUserById(int id) {
        return organDaoService.findOrganById(id);
    }

    @PostMapping(value = "findOrganByUid")
    @ApiOperation("根据uid查找Organ")
        //根据id查找
    Organ findOrganByUid(int uid) {
        return organDaoService.findOrganByUid(uid);
    }

    @PostMapping(value = "updateOrgan")
    @ApiOperation("更新数据Organ")
        //更新数据
    int update(Organ organ) {
        return organDaoService.update(organ);
    }
}
