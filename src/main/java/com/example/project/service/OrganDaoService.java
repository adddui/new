package com.example.project.service;

import com.example.project.entity.Organ;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface OrganDaoService {
    List<Organ> findAll();

    //新增数据
    int add(Organ organ);

    //删除数据
    Integer delete(int id);

    //根据id查找
    Organ findOrganById(int id);

    //根据用户找到最近的一次核酸测量结果，在根据oid找到检测机构
    Organ findOrganByUid(int uid);

    //更新数据
    int update(Organ organ);
}
