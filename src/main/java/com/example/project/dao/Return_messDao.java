package com.example.project.dao;

import com.example.project.entity.Return_mess;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface Return_messDao {
    List<Return_mess> findAll();

    //新增
    int add(Return_mess return_mess);

    //删除
    int delete(int id);

    //更新数据
    int update(Return_mess return_mess);

    //查找数据
    Return_mess findReturn_messById(int id);

    Return_mess findReturn_messByUid(int uid);
}
