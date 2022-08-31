package com.example.project.controller;

import com.example.project.dao.UserDAO;
import com.example.project.entity.User;
import com.example.project.utils.MD5Util;
import com.power.common.util.RandomUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {
    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "register")
    @ResponseBody
    @ApiOperation("注册")
    public String register(String username, String password) {
        int id= RandomUtil.randomInt(10000);
        String code=RandomUtil.randomString(10);
        String salt=RandomUtil.randomString(10);
        String finalPassword = MD5Util.formPassToDBPass(password, salt);
//        User users=new User(id,username,finalPassword,code,salt);
//        userDao.addUser(users);
        return "注册成功";
    }
}
