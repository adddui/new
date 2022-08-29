package com.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String code;
    private String password;
    private String salt;
    private String account;
    private String lastTime;
    private String idcard;
    private String res;
    private String gender;
    private String img;
    private String address;
}
