package com.example.project.controller;


import com.example.project.entity.Out_mess;
import com.example.project.service.Out_messServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api
public class Out_messController {
    @Autowired
    Out_messServiceImpl outMessService;

    @RequestMapping(value = "findAllOut_mess")
    @ApiOperation("查找所有")
    List<Out_mess> findAll() {
        return outMessService.findAll();
    }

    @RequestMapping(value = "addOut_mess")
    @ApiOperation("新增数据")
        //新增数据
    int add(Out_mess out_mess) {
        return outMessService.add(out_mess);
    }

    @RequestMapping(value = "deleteOut_mess")
    @ApiOperation("删除数据")
        //删除数据
    int delete(int id) {
        return outMessService.delete(id);
    }

    @RequestMapping(value = "findOut_messById")
    @ApiOperation("根据id查找")
        //根据id查找
    Out_mess findById(int id) {return outMessService.findById(id);}


    @RequestMapping(value = "updateOut_mess")
    @ApiOperation("更新数据")
        //更新数据
    int update(Out_mess out_mess) {
        return outMessService.update(out_mess);
    }
}
