package com.example.project.service;

import com.example.project.dao.ForumDao;
import com.example.project.entity.Forum;
import com.example.project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ForumDaoServiceImpl")
public class ForumDaoServiceImpl implements ForumDaoService{
    @Autowired
    ForumDao forumDao;
    @Override
    public List<Forum> findAll() {
        return forumDao.findAll();
    }

    @Override
    public int add(Forum forum) {
        return forumDao.add(forum);
    }

    @Override
    public int delete(int id) {
        return forumDao.delete(id);
    }

    @Override
    public Forum findForumById(int id) {
        return forumDao.findForumById(id);
    }

    @Override
    public int update(Forum forum) {
        return forumDao.update(forum);
    }
}
