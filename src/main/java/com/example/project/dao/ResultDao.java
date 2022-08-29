package com.example.project.dao;

import com.example.project.entity.Result;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResultDao {
    List<Result> findAll();

    //新增
    int add(Result result);

    //删除
    int delete(int id);

    //更新数据
    int update(Result result);

    //查找数据
    Result findById(int id);
}
