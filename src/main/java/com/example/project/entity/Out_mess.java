package com.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Out_mess {
    int id;
    int uid;
    double temp;//体温
    String pod;//出发地
    String destination;
    Date buildTime;
    Date startTime;
    Date endTime;

    public Out_mess(int uid, double temp, String pod, String destination, Date buildTime, Date startTime, Date endTime) {
        this.uid = uid;
        this.temp = temp;
        this.pod = pod;
        this.destination = destination;
        this.buildTime = buildTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
