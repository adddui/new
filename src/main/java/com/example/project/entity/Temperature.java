package com.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Temperature {
    int id;
    int uid;
    double temp;
    Date postTime;

    public Temperature(int uid, double temp, Date postTime) {
        this.uid = uid;
        this.temp = temp;
        this.postTime = postTime;
    }
}
