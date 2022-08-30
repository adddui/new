package com.example.project.entity;

import java.sql.Timestamp;

public class Out_mess {
    int id;
    int uid;
    double temp;//体温
    String pod;//出发地
    String destination;
    Timestamp buildTime;
    Timestamp startTime;
    Timestamp endTime;

    public double getTemp() {return temp;}

    public void setTemp(double temp) {this.temp = temp;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Timestamp getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(Timestamp buildTime) {
        this.buildTime = buildTime;
    }

    public Timestamp getStartime() {
        return startTime;
    }

    public void setStartime(Timestamp startime) {
        this.startTime = startime;
    }

    public Timestamp getEndtime() {
        return endTime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endTime = endtime;
    }


}
