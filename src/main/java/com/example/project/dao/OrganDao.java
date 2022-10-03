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

    //根据用户找到最近的一次核酸测量结果，在根据oid找到检测机构
    Organ findOrganByUid(int uid);

    //更新数据
    int update(Organ organ);
}


