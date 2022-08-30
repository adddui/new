package com.example.project.service;

import com.example.project.entity.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResultService {
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
