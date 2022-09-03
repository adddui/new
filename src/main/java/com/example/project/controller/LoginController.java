package com.example.project.controller;

import com.example.project.entity.User;
import com.example.project.service.UserDAOServiceImpl;
import com.example.project.utils.JWTUtil;
import com.example.project.utils.MD5Util;
import com.example.project.utils.RedisUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Controller
@Api
public class LoginController {
    @Autowired
    private UserDAOServiceImpl userDAOService;
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
    public String login(HttpServletResponse response,@RequestBody HashMap<String, String> map) throws IOException {
        // 取得参数
        String password = map.get("password");
        String validateCode = map.get("validateCode");
        String validateKey = map.get("validateKey");
        String account = map.get("account");
        System.out.println(password+"~"+validateCode+"~"+validateKey+"~"+account);
        //验证码匹配
        String validateCodeRedis = (String) redisUtil.get(validateKey);

        if (validateCodeRedis.equals(validateCode)) {
            //查找用户
            userDAOService.findUserByAccount(account);
            User user = userDAOService.findUserByAccount(account);
            if (user != null) {
                //查找成功
                String salt = user.getSalt();
                String finalPassword = MD5Util.formPassToDBPass(password, salt);
                if (finalPassword.equals(user.getPassword())) {
                    Map<String,String> payload=new HashMap<>();
                    payload.put("account",account);
                    payload.put("password",password);
                    String token = JWTUtil.getToken(payload);
                    System.out.println("token:"+token);
                    response.setHeader("token", token);
                    // response.sendRedirect("index.html");
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
