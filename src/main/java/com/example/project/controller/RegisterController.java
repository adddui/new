package com.example.project.controller;

import com.example.project.dao.UserDAO;
import com.example.project.entity.User;
import com.example.project.service.UserDAOServiceImpl;
import com.example.project.utils.MD5Util;
import com.power.common.util.RandomUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api
public class RegisterController {
    @Autowired
    private UserDAOServiceImpl userDAOService;

    @RequestMapping(value = "register")
    @ResponseBody
    @ApiOperation("注册")
    
    public String register(@RequestBody HashMap<String,String> map) {
        String name = map.get("name");
        String password = map.get("password");
        String account = map.get("account");
        
        System.out.println(name+"!"+password+"!"+account);
        if(userDAOService.findExistByAccount(account) != null) {
            return "account已存在";
        }else {
            String salt = RandomUtil.randomString(10);
            String finalPassword = MD5Util.formPassToDBPass(password, salt);
            User user = new User(name, null, finalPassword, salt, account, null, null, null,null, null, null, null, null);
            userDAOService.add(user);
            return "注册成功";
        }
    }
}
