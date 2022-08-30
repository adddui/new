package com.example.project.service;



import com.example.project.entity.Return_mess;

import java.util.List;


public interface Return_messService {
    List<Return_mess> findAll();

    //新增
    int add(Return_mess return_mess);

    //删除
    int delete(int id);

    //更新数据
    int update(Return_mess return_mess);

    //查找数据
    Return_mess findById(int id);
}
