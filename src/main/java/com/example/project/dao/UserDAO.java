package com.example.project.dao;

import com.example.project.entity.User;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface UserDAO {
    /**
     *
     * @return User
     */
    List<User> findAll();
    //新增数据

    /**
     *
     * @param user
     * @return int
     */
    int add(User user);
    //删除数据

    /**
     *
     * @param id
     * @return Integer
     */
    int delete(int id);
    //根据id查找

    /**
     *
     * @param id
     * @return User
     */
    User findUserById(int id);
    //根据name查找

    /**
     *
     * @param name
     * @return User
     */
    User findUserByName(String name);
    //更新数据

    /**
     *
     * @param user
     * @return int
     */
    int update(User user);
}
