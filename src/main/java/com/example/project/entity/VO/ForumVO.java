package com.example.project.entity.VO;

import com.example.project.entity.Forum;

public class ForumVO extends Forum {
    String name;

    public String getUser_name() {
        return name;
    }

    public void setUser_name(String name) {
        this.name = name;
    }
}
