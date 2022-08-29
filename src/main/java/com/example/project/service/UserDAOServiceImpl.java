package com.example.project.service;

import com.example.project.dao.UserDAO;
import com.example.project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("UserDAOServiceImpl")
public class UserDAOServiceImpl implements UserDAOService{
    @Autowired
    UserDAO userDAO;
    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public int add(User user) {
        return userDAO.add(user);
    }

    @Override
    public int delete(int id) {
        return userDAO.delete(id);
    }

    @Override
    public User findUserById(int id) {
        return userDAO.findUserById(id);
    }

    @Override
    public User findUserByName(String name) {
        return userDAO.findUserByName(name);
    }

    @Override
    public int update(User user) {
        return userDAO.update(user);
    }
}
