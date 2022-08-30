package com.example.project.controller;

import com.example.project.entity.Return_mess;
import com.example.project.service.Return_messServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api
public class Return_messController {
    @Autowired
    Return_messServiceImpl returnMessService;

    @RequestMapping(value = "findAllReturn_mess")
    @ApiOperation("查找所有")
    List<Return_mess> findAll() {
        return returnMessService.findAll();
    }

    @RequestMapping(value = "addReturn_mess")
    @ApiOperation("新增数据")
        //新增数据
    int add(Return_mess return_mess) {
        return returnMessService.add(return_mess);
    }

    @RequestMapping(value = "deleteReturn_mess")
    @ApiOperation("删除数据")
        //删除数据
    int delete(int id) {
        return returnMessService.delete(id);
    }

    @RequestMapping(value = "findReturn_messById")
    @ApiOperation("根据id查找")
        //根据id查找
    Return_mess findById(int id) {return returnMessService.findById(id);}


    @RequestMapping(value = "updateReturn_mess")
    @ApiOperation("更新数据")
        //更新数据
    int update(Return_mess return_mess) {
        return returnMessService.update(return_mess);
    }
}
