package com.example.project.service;

import com.example.project.dao.ResultDao;
import com.example.project.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ResultServiceImpl")
public class ResultServiceImpl implements ResultService{
    @Autowired
    ResultDao resultDao;

    @Override
    public List<Result> findAll() {
        return resultDao.findAll();
    }

    @Override
    public int add(Result result) {
        return resultDao.add(result);
    }

    @Override
    public int delete(int id) {
        return resultDao.delete(id);
    }

    @Override
    public int update(Result result) {
        return resultDao.update(result);
    }

    @Override
    public Result findResultById(int id) {
        return resultDao.findResultById(id);
    }

    @Override
    public Result findResultByUid(int uid) {
        return resultDao.findResultByUid(uid);
    }

}
