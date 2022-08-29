package com.example.project.service;

import com.example.project.entity.Notice;
import com.example.project.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface NoticeDaoService {
    List<Notice> findAll();
    //新增数据
    int add(Notice notice);
    //删除数据
    int delete(int id);
    //根据id查找
    Notice findNoticeById(int id);
    //更新数据
    int update(Notice notice);
}
