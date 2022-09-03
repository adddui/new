package com.example.project.controller;

import com.example.project.entity.User;
import com.example.project.service.UserDAOService;
import com.example.project.service.UserDAOServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("authority")
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
    int add(@RequestBody HashMap<String, String> map) {
        String name = map.get("name");
        String code = map.get("code");
        String password = map.get("password");
        String salt = map.get("salt");
        String account = map.get("account");
        Date lastTime = Date.valueOf("lastTime");
        String idcard = map.get("idcard");
        String res = map.get("res");
        String gender = map.get("gender");
        String img = map.get("img");
        String address = map.get("address");
        String phone = map.get("phone");
        String trace = map.get("trace");
        User user = new User(name, code, password, salt, account, lastTime, idcard, res, gender, img, address, phone, trace);
        return userDAOService.add(user);
    }

    @PostMapping(value = "deleteUser")
    @ApiOperation("删除User数据")
        //删除数据
    int delete(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        return userDAOService.delete(id);
    }

    @PostMapping(value = "findUserById")
    @ApiOperation("根据id查找User")
        //根据id查找
    User findUserById(@RequestBody HashMap<String, String> map) {
        int id = Integer.parseInt(map.get("id"));
        return userDAOService.findUserById(id);
    }

    @PostMapping(value = "findUserByName")
    @ApiOperation("根据name查找User")
        //根据name查找
    User findUserByName(@RequestBody HashMap<String, String> map) {
        String name = map.get("name");
        return userDAOService.findUserByName(name);
    }

    @PostMapping(value = "findUserByAccount")
        //根据account查找
    User findUserByAccount(@RequestBody HashMap<String, String> map) {
        String account = map.get("account");
        return userDAOService.findUserByAccount(account);
    }

    @PostMapping(value = "findExistByAccount")
        //查找是否存在账户
    Boolean findExistByAccount(@RequestBody HashMap<String, String> map) {
        String account = map.get("account");
        return userDAOService.findExistByAccount(account);
    }

    @PostMapping(value = "updateUser")
    @ApiOperation("更新User数据")
        //更新数据
    int update(@RequestBody HashMap<String, String> map) {
        String name = map.get("name");
        String idcard = map.get("idcard");
        String address = map.get("address");
        String gender = map.get("gender");
        String phone = map.get("phone");
        String trace = map.get("trace");
        User user = new User(name, null, null, null, null, null, idcard, null, gender, null, address, phone, trace);
        return userDAOService.update(user);
    }
}
