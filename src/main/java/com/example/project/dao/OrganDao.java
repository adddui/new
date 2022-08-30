package com.example.project.dao;

import com.example.project.entity.Organ;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrganDao {
    List<Organ> findAll();

    //新增数据
    int add(Organ organ);

    //删除数据
    int delete(int id);

    //根据id查找
    Organ findOrganById(int id);

    //更新数据
    int update(Organ organ);
}


