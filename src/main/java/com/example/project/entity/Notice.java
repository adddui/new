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
public class Notice {
    private int id;
    private String context;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT-8" )
    private Timestamp postTime;
    private String title;
}
