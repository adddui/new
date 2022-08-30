package com.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Forum {
    private int id;
    private int builder;
    private Date sendTime;
    private String message;
    private String title;
}
