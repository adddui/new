package com.example.project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class Forum {
    private int id;
    private int builder;
    private Timestamp sendTime;
    private String message;
    private String title;

    public Forum(int builder,Timestamp sendTime, String message, String title) {

        this.builder = builder;
        this.sendTime =sendTime;
        this.message = message;
        this.title = title;
    }
}
