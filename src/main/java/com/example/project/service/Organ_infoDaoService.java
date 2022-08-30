package com.example.project.service;
import com.example.project.entity.Organ_info;
import com.example.project.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface Organ_infoDaoService {
    List<Organ_info> findAll();
    //新增数据
    int add(Organ_info organ_info);
    //删除数据
    Integer delete(int id);
    //根据id查找
   Organ_info findOrganById(int id);
    //根据name查找
   Organ_info findOrganByName(String name);
    //更新数据
    int update(Organ_info user);
}
