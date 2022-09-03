package com.example.project.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Return_mess {
    int id;
    int uid;
    double temp;//体温
    String pod;
    String destination;
    Date buildTime;
    Date startTime;
    Date endTime;

    public Return_mess(int uid, double temp, String pod, String destination, Date buildTime, Date startTime, Date endTime) {
        this.uid = uid;
        this.temp = temp;
        this.pod = pod;
        this.destination = destination;
        this.buildTime = buildTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }

}
