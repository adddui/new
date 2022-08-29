package com.example.project.dao;

import com.example.project.entity.Forum;
import com.example.project.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ForumDao {
    /**
     *
     * @return
     */
    List<Forum> findAll();

    /**
     *
     * @param forum
     * @return
     */
    //新增数据
    int add(Forum forum);

    /**
     *
     * @param id
     * @return
     */
    //删除数据
    Integer delete(int id);

    /**
     *
     * @param id
     * @return
     */
    //根据id查找
    Forum findUserById(int id);

    /**
     *
     * @param forum
     * @return
     */
    //更新数据
    int update(Forum forum);
}
