package com.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

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
