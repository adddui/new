package com.example.project.controller;
import com.example.project.dao.UserDAO;
import com.example.project.entity.User;
import com.example.project.utils.JWTUtil;
import com.example.project.utils.MD5Util;
import com.example.project.utils.RedisUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    private UserDAO userDao;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "toLogin")
    @ResponseBody
    @ApiOperation("登录")
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "login")
    @ResponseBody
    @ApiOperation("登录")
    public String login(HttpServletResponse response, @RequestParam("username") String username, @RequestParam("password") String password, String validateCode, @RequestHeader String validateKey) {
        //验证码匹配
        String validateCodeRedis = (String) redisUtil.get(validateKey);
        if (validateCodeRedis.equals(validateCode)) {
            //查找用户
            userDao.findUserByName(username);
            User users = userDao.findUserByName(username);
            if (users != null) {
                String salt = users.getSalt();
                String finalPassword = MD5Util.formPassToDBPass(password, salt);
                if (finalPassword.equals(users.getPassword())) {
                    String token = JWTUtil.sign(users.getName(), users.getPassword());
                    response.setHeader("token", token);
                    return "登陆成功";
                } else {
                    return "密码错误";
                }
            } else {
                return "用户名无";
            }
        }else {
            return "验证码错误";
        }
    }

}
