package com.example.project.dao;

import com.example.project.entity.Out_mess;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Out_messDao {
    List<Out_mess>  findAll();

    //新增
    int add(Out_mess out_mess);

    //删除
    int delete(int id);

    //更新数据
    int update(Out_mess out_mess);

    //查找数据
    Out_mess findOut_messById(int id);
}
