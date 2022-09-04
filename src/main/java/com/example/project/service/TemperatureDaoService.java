package com.example.project.service;

import com.example.project.entity.Temperature;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TemperatureDaoService {
        List<Temperature> findAll();
        //新增数据
        int add(Temperature temperature);
        //删除数据
        Integer delete(int id);
        //根据id查找
        Temperature findTemperatureById(int id);
        //更新数据
        int update(Temperature temperature);
}
