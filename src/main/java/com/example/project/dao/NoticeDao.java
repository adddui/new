package com.example.project.dao;

import com.example.project.entity.Notice;
import com.example.project.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface NoticeDao {
    /**
     *
     * @return
     */
    List<Notice> findAll();
    /**
     *
     * @param notice
     * @return
     */
    //新增数据
    int add(Notice notice);
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
     * @return Notice
     */
    //根据id查找
    Notice findUserById(int id);
    //更新数据
    /**
     *
     * @param notice
     * @return
     */
    int update(Notice notice);
}
