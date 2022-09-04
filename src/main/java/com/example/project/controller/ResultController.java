package com.example.project.controller;


import com.example.project.entity.Result;
import com.example.project.service.ResultServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("authority")
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
    int add(@RequestBody HashMap<String, String> map) {
        int uid=Integer.parseInt(map.get("uid"));
        String resultStatus=map.get("resultStatus");//核酸阴阳性
        Date sampleTime=Date.valueOf(map.get("sampleTime"));//采样时间
        int oid=Integer.parseInt(map.get("oid"));
        Date checkTime=Date.valueOf(map.get("checkTime"));//检查时间
        Result result=new Result(uid,resultStatus,sampleTime,oid,checkTime);
        return resultService.add(result);
    }

    @PostMapping(value = "deleteResultById")
    @ApiOperation("删除Result数据ById")
        //删除数据
    int delete(@RequestBody HashMap<String, String> map) {
        int id=Integer.parseInt(map.get("id"));
        return resultService.delete(id);
    }

    @PostMapping(value = "findResultById")
    @ApiOperation("根据id查找Result")
        //根据id查找
    Result findResultById(@RequestBody HashMap<String, String> map) {
        int id=Integer.parseInt(map.get("id"));
        return resultService.findResultById(id);
    }

    @PostMapping(value = "findResultByUid")
    @ApiOperation("根据uid查找Result")
        //根据id查找
    Result findResultByUid(@RequestBody HashMap<String, String> map) {
        int uid=Integer.parseInt(map.get("uid"));
        System.out.println("uid: "+uid);
        System.out.println("result: "+resultService.findResultByUid(uid));
        return resultService.findResultByUid(uid);
    }

    @PostMapping(value = "updateResult")
    @ApiOperation("更新Result数据")
        //更新数据
    int update(Result result) {
        return resultService.update(result);
    }
}
