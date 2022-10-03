package com.example.project.dao;

import com.example.project.entity.Temperature;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TemperatureDao {

    List<Temperature> findAll();

    //新增数据
    int add(Temperature temperature);

    //删除数据
    int delete(int id);

    //根据id查找
    Temperature findTemperatureByUid(int id);

    //更新数据
    int update(Temperature temperature);
}



