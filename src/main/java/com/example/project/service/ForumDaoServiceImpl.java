package com.example.project.service;

import com.example.project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ForumDaoServiceImpl implements ForumDaoService{
    @Autowired
    ForumDaoService forumDaoService;
    @Override
    public List<User> findAll() {
        return forumDaoService.findAll();
    }

    @Override
    public int add(User user) {
        return forumDaoService.add(user);
    }

    @Override
    public Integer delete(int id) {
        return forumDaoService.delete(id);
    }

    @Override
    public User findUserById(int id) {
        return forumDaoService.findUserById(id);
    }

    @Override
    public int update(User user) {
        return forumDaoService.update(user);
    }
}
