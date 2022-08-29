package com.example.project.service;

import com.example.project.entity.Forum;
import com.example.project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ForumDaoServiceImpl")
public class ForumDaoServiceImpl implements ForumDaoService{
    @Autowired
    ForumDaoService forumDaoService;
    @Override
    public List<Forum> findAll() {
        return forumDaoService.findAll();
    }

    @Override
    public int add(Forum forum) {
        return forumDaoService.add(forum);
    }

    @Override
    public int delete(int id) {
        return forumDaoService.delete(id);
    }

    @Override
    public Forum findForumById(int id) {
        return forumDaoService.findForumById(id);
    }

    @Override
    public int update(Forum forum) {
        return forumDaoService.update(forum);
    }
}
