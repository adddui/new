package com.example.project.service;
import com.example.project.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TempreatureDaoServiceimpl {
    @Autowired
    Tempreature tempreature;
    @Override
    public List<Tempreature> findAll() {
        return tempreature.findAll();
    }

    @Override
    public int add(Tempreature tempreature) {
        return tempreature.add(tempreature);
    }

    @Override
    public Integer delete(int id) {
        return tempreature.delete(id);
    }

    @Override
    public Tempreature findTempreturedById(int id) {
        return tempreature.findTempreatureById(id);
    }

    @Override
    public int update(Tempreature tempreature) {
        return Tempreature.update(tempreature);
    }







}
