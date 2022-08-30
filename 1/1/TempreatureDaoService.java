package com.example.project.service;
import com.example.project.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface TempreatureDaoService {

        List<Tempreature> findAll();
        //新增数据
        int add(Tempreature tempreature);
        //删除数据
        Integer delete(int id);
        //根据id查找
        Tempreature findTempreatureById(int id);
        //根据name查找
        Tempreature findTempreatureByName(String name);
        //更新数据
        int update(Tempreature user);
}
