package com.example.project.service;

import com.example.project.dao.Return_messDao;
import com.example.project.entity.Return_mess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service("Return_messImpl")
public class Return_messServiceImpl implements Return_messService{
    @Autowired
    Return_messDao return_messDao;

    @Override
    public List<Return_mess> findAll() {
        return return_messDao.findAll();
    }

    @Override
    public int add(Return_mess return_mess) {
        return return_messDao.add(return_mess);
    }

    @Override
    public int delete(int id) {
        return return_messDao.delete(id);
    }

    @Override
    public int update(Return_mess return_mess) {
        return return_messDao.update(return_mess);
    }

    @Override
    public Return_mess findById(int id) {
        return return_messDao.findById(id);
    }
}
