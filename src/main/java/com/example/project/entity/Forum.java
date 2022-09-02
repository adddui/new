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

    public Forum(int id) {
        new Forum(id, 0);
    }

    public Forum(int id, int builder) {
        new Forum(id, builder, null);
    }

    public Forum(int id, int builder, Date sendTime) {
        new Forum(id, builder, sendTime, null);
    }

    public Forum(int id, int builder, Date sendTime, String message) {
        new Forum(id,builder,sendTime,message,null);
    }
}
