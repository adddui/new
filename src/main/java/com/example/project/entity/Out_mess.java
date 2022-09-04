package com.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT-8" )
    Date buildTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT-8" )
    Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT-8" )
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
