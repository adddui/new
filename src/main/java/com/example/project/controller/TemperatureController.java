package com.example.project.controller;

import com.example.project.entity.Temperature;
import com.example.project.service.TemperatureDaoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api
public class TemperatureController {
    @Autowired
    TemperatureDaoServiceImpl TemperatureDaoService;

    @RequestMapping(value = "findAllTemperature")
    @ApiOperation("查找所有")
    List<Temperature> findAll() {
        return TemperatureDaoService.findAll();
    }

    @RequestMapping(value = "addTemperature")
    @ApiOperation("新增数据")
        //新增数据
    int add(Temperature temperature) {
        return TemperatureDaoService.add(temperature);
    }

    @RequestMapping(value = "deleteTemperature")
    @ApiOperation("删除数据")
        //删除数据
    int delete(int id) {
        return TemperatureDaoService.delete(id);
    }

    @RequestMapping(value = "findTemperatureById")
    @ApiOperation("根据id查找")
        //根据id查找
    Temperature findUserById(int id) {
        return TemperatureDaoService.findTemperatureById(id);
    }

    @RequestMapping(value = "updateTemperature")
    @ApiOperation("更新数据")
        //更新数据
    int update(Temperature temperature) {
        return TemperatureDaoService.update(temperature);
    }
}
