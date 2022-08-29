package com.example.project.dao;

import com.example.project.entity.Forum;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ForumDao {
    /**
     *
     * @return Forum
     */
    List<Forum> findAll();

    /**
     *
     * @param forum
     * @return int
     */
    //新增数据
    int add(Forum forum);

    /**
     *
     * @param id
     * @return int
     */
    //删除数据
    int delete(int id);

    /**
     *
     * @param id
     * @return Forum
     */
    //根据id查找
    Forum findForumById(int id);

    /**
     *
     * @param forum
     * @return int
     */
    //更新数据
    int update(Forum forum);
}
