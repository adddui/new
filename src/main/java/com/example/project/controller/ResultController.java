package com.example.project.controller;


import com.example.project.entity.Result;
import com.example.project.service.ResultServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api
public class ResultController {
    @Autowired
    ResultServiceImpl resultService;

    @RequestMapping(value = "findAllResult")
    @ApiOperation("查找所有")
    List<Result> findAll() {return resultService.findAll();}

    @RequestMapping(value = "addResult")
    @ApiOperation("新增数据")
        //新增数据
    int add(Result result) {return resultService.add(result);}

    @RequestMapping(value = "deleteResult")
    @ApiOperation("删除数据")
        //删除数据
    int delete(int id) {
        return resultService.delete(id);
    }

    @RequestMapping(value = "findResultById")
    @ApiOperation("根据id查找")
        //根据id查找
    Result findById(int id) {return resultService.findById(id);}


    @RequestMapping(value = "updateResult")
    @ApiOperation("更新数据")
        //更新数据
    int update(Result result) {return resultService.update(result);}
}
