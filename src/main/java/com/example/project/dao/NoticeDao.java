package com.example.project.dao;

import com.example.project.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface NoticeDao {

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
