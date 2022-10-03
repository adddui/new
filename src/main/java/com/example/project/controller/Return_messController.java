package com.example.project.controller;

import com.example.project.entity.Return_mess;
import com.example.project.service.Return_messServiceImpl;
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
public class Return_messController {
    @Autowired
    Return_messServiceImpl returnMessService;

    @PostMapping(value = "findAllReturn_mess")
    @ApiOperation("查找所有Return_mess")
    List<Return_mess> findAll() {
        return returnMessService.findAll();
    }

    @PostMapping(value = "addReturn_mess")
    @ApiOperation("新增Return_mess数据")
        //新增数据
    int add(@RequestBody HashMap<String, String> map) {
        int uid = Integer.parseInt(map.get("uid"));
        double temp = Double.parseDouble(map.get("temp"));//体温
        String pod = map.get("pod");
        String destination = map.get("destination");
        Date buildTime = Date.valueOf("buildTime");
        Date startTime = Date.valueOf("startTime");
        Date endTime = Date.valueOf("endTime");
        Return_mess return_mess = new Return_mess(uid, temp, pod, destination, buildTime, startTime, endTime);
        return returnMessService.add(return_mess);
    }

    @PostMapping(value = "deleteReturn_messById")
    @ApiOperation("删除Return_mess数据")
        //删除数据
    int delete(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        return returnMessService.delete(id);
    }

    @PostMapping(value = "findReturn_messById")
    @ApiOperation("根据id查找Return_mess")
        //根据id查找
    Return_mess findReturn_messById(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        return returnMessService.findReturn_messById(id);
    }

    @PostMapping(value = "findReturn_messByUid")
    @ApiOperation("根据uid查找Return_mess")
        //根据id查找
    Return_mess findReturn_messByUid(@RequestBody HashMap<String, String> map) {
        int uid = Integer.parseInt(map.get("uid"));
        return returnMessService.findReturn_messById(uid);
    }

    @PostMapping(value = "updateReturn_mess")
    @ApiOperation("更新Return_mess数据")
        //更新数据
    int update(Return_mess return_mess) {
        return returnMessService.update(return_mess);
    }
}
