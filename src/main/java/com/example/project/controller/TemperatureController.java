package com.example.project.controller;

import com.example.project.entity.Temperature;
import com.example.project.service.TemperatureDaoServiceImpl;
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
public class TemperatureController {
    @Autowired
    TemperatureDaoServiceImpl TemperatureDaoService;

    @PostMapping(value = "findAllTemperature")
    @ApiOperation("查找所有Temperature")
    List<Temperature> findAll() {
        return TemperatureDaoService.findAll();
    }

    @PostMapping(value = "addTemperature")
    @ApiOperation("新增Temperature数据")
        //新增数据
    int add(@RequestBody HashMap<String, String> map) {
        int uid=Integer.parseInt(map.get("uid"));
        double temp=Double.parseDouble(map.get("temp"));
        Date postTime=Date.valueOf(map.get("postTime"));
        Temperature temperature=new Temperature(uid, temp, postTime);
        return TemperatureDaoService.add(temperature);
    }

    @PostMapping(value = "deleteTemperature")
    @ApiOperation("删除Temperature数据")
        //删除数据
    int delete(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        return TemperatureDaoService.delete(id);
    }

    @PostMapping(value = "findTemperatureByUid")
    @ApiOperation("根据id查找Temperature")
        //根据id查找
    Temperature findTemperatureByUid(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        return TemperatureDaoService.findTemperatureByUid(id);
    }

    @PostMapping(value = "updateTemperature")
    @ApiOperation("更新Temperature数据")
        //更新数据
    int update(Temperature temperature) {
        return TemperatureDaoService.update(temperature);
    }
}
