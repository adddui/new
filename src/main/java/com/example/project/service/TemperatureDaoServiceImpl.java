package com.example.project.service;

import com.example.project.dao.TemperatureDao;
import com.example.project.entity.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureDaoServiceImpl implements TemperatureDaoService {
    @Autowired
    TemperatureDao temperatureDao;

    @Override
    public List<Temperature> findAll() {
        return temperatureDao.findAll();
    }

    @Override
    public int add(Temperature temperature) {
        return temperatureDao.add(temperature);
    }

    @Override
    public Integer delete(int id) {
        return temperatureDao.delete(id);
    }

    @Override
    public Temperature findTemperatureByUid(int id) {
        return temperatureDao.findTemperatureByUid(id);
    }

    @Override
    public int update(Temperature temperature) {
        return temperatureDao.update(temperature);
    }


}
