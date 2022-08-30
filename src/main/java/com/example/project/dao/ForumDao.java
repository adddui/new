package com.example.project.dao;

import com.example.project.entity.Forum;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ForumDao {

    List<Forum> findAll();

    //新增数据
    int add(Forum forum);

    //删除数据
    int delete(int id);

    //根据id查找
    Forum findForumById(int id);

    //更新数据
    int update(Forum forum);
}
