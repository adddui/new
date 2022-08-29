package com.example.project.service;

import com.example.project.dao.NoticeDao;
import com.example.project.entity.Notice;
import com.example.project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("NoticeDaoServiceImpl")
public class NoticeDaoServiceImpl implements NoticeDaoService{
    @Autowired
    NoticeDao noticeDao;
    @Override
    public List<Notice> findAll() {
        return noticeDao.findAll();
    }

    @Override
    public int add(Notice notice) {
        return noticeDao.add(notice);
    }

    @Override
    public int delete(int id) {
        return noticeDao.delete(id);
    }

    @Override
    public Notice findNoticeById(int id) {
        return noticeDao.findNoticeById(id);
    }

    @Override
    public int update(Notice notice) {
        return noticeDao.update(notice);
    }
}
