package com.example.project.service;

import com.example.project.dao.OrganDao;
import com.example.project.entity.Organ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrganDaoServiceImpl implements OrganDaoService {
    @Autowired
    OrganDao organDao;
    @Override
    public List<Organ> findAll() {
        return organDao.findAll();
    }

    @Override
    public int add(Organ organ) {
        return organDao.add(organ);
    }

    @Override
    public Integer delete(int id) {
        return organDao.delete(id);
    }

    @Override
    public Organ findOrganById(int id) {
        return organDao.findOrganById(id);
    }

    @Override
    public int update(Organ organ) {
        return organDao.update(organ);
    }
}

