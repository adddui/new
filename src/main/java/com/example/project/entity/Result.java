package com.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    int id;
    int uid;
    String resultStatus;//核酸阴阳性
    Date sampleTime;//采样时间
    int oid;
    Date checkTime;//检查时间

    public Result(int uid, String resultStatus, Date sampleTime, int oid, Date checkTime) {
        this.uid = uid;
        this.resultStatus = resultStatus;
        this.sampleTime = sampleTime;
        this.oid = oid;
        this.checkTime = checkTime;
    }
}
