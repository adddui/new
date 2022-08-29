package com.example.project.service;

import com.example.project.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserDAOService {
    List<User> findAll();
    //新增数据
    int add(User user);
    //删除数据
    int delete(int id);
    //根据id查找
    User findUserById(int id);
    //根据name查找
    User findUserByName(String name);
    //更新数据
    int update(User user);
}
