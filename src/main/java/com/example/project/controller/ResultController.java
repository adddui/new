package com.example.project.controller;


import com.example.project.entity.Result;
import com.example.project.service.ResultServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api
public class ResultController {
    @Autowired
    ResultServiceImpl resultService;

    @PostMapping(value = "findAllResult")
    @ApiOperation("查找所有Result")
    List<Result> findAll() {
        return resultService.findAll();
    }

    @PostMapping(value = "addResult")
    @ApiOperation("新增Result数据")
        //新增数据
    int add(Result result) {
        return resultService.add(result);
    }

    @PostMapping(value = "deleteResult")
    @ApiOperation("删除Result数据")
        //删除数据
    int delete(int id) {
        return resultService.delete(id);
    }

    @PostMapping(value = "findResultById")
    @ApiOperation("根据id查找Result")
        //根据id查找
    Result findResultById(int id) {
        return resultService.findResultById(id);
    }

    @PostMapping(value = "findResultByUid")
    @ApiOperation("根据id查找Result")
        //根据id查找
    Result findResultByUid(int uid) {
        return resultService.findResultByUid(uid);
    }

    @PostMapping(value = "updateResult")
    @ApiOperation("更新Result数据")
        //更新数据
    int update(Result result) {
        return resultService.update(result);
    }
}
