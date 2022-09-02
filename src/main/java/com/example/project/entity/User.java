package com.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String code;
    private String password;
    private String salt;
    private String account;
    private Date lastTime;
    private String idcard;

    public User(String name, String code, String password, String salt, String account, Date lastTime, String idcard, String res, String gender, String img, String address, String phone, String trace) {
        this.name = name;
        this.code = code;
        this.password = password;
        this.salt = salt;
        this.account = account;
        this.lastTime = lastTime;
        this.idcard = idcard;
        this.res = res;
        this.gender = gender;
        this.img = img;
        this.address = address;
        this.phone = phone;
        this.trace = trace;
    }

    private String res;
    private String gender;
    private String img;
    private String address;
    private String phone;
    private String trace;
}
