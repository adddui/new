package com.example.project.service;

import com.example.project.entity.Out_mess;


import java.util.List;


public interface Out_messService {
    List<Out_mess>  findAll();

    //新增
    int add(Out_mess out_mess);

    //删除
    int delete(int id);

    //更新数据
    int update(Out_mess out_mess);

    //查找数据
    Out_mess findById(int id);
}
