package com.example.project.controller;

import com.example.project.entity.User;
import com.example.project.service.UserDAOService;
import com.example.project.service.UserDAOServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api
public class UserController {
    @Autowired
    UserDAOServiceImpl userDAOService;

    @PostMapping(value = "findAllUser")
    @ResponseBody
    @ApiOperation("查找所有User")
    List<User> findAll() {
        return userDAOService.findAll();
    }

    @PostMapping(value = "addUser")
    @ApiOperation("新增User数据")
        //新增数据
    int add(User user) {
        return userDAOService.add(user);
    }

    @PostMapping(value = "deleteUser")
    @ApiOperation("删除User数据")
        //删除数据
    int delete(int id) {
        return userDAOService.delete(id);
    }

    @PostMapping(value = "findUserById")
    @ApiOperation("根据id查找User")
        //根据id查找
    User findUserById(int id) {
        return userDAOService.findUserById(id);
    }

    @PostMapping(value = "findUserByName")
    @ApiOperation("根据name查找User")
        //根据name查找
    User findUserByName(String name) {
        return userDAOService.findUserByName(name);
    }

    @PostMapping(value = "updateUser")
    @ApiOperation("更新User数据")
        //更新数据
    int update(User user) {
        return userDAOService.update(user);
    }
}
