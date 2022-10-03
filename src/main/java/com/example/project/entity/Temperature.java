package com.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Temperature {
    int id;
    int uid;
    double temp;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date postTime;

    public Temperature(int uid, double temp, Date postTime) {
        this.uid = uid;
        this.temp = temp;
        this.postTime = postTime;
    }
}
