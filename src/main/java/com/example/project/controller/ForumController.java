package com.example.project.controller;

import com.example.project.entity.Forum;
import com.example.project.service.ForumDaoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@RestController
@Api
public class ForumController {
    @Autowired
    ForumDaoServiceImpl forumDaoService;

    @RequestMapping(value = "findAllForum")
    @ResponseBody
    @ApiOperation("查找所有Forum")
    List<Forum> findAll() {
        return forumDaoService.findAll();
    }

    @PostMapping(value = "addForum")
    @ApiOperation("新增Forum数据")
        //新增数据
    int add(int builder, String message, String title) {
        Timestamp timestamp=new Timestamp(Calendar.getInstance().get(
                Calendar.YEAR) - 1900, Calendar.getInstance().get(
                Calendar.MONTH), Calendar.getInstance().get(
                Calendar.DATE), Calendar.getInstance().get(
                Calendar.HOUR), Calendar.getInstance().get(
                Calendar.MINUTE), Calendar.getInstance().get(
                Calendar.SECOND), 0);
        Forum forum=new Forum(builder,timestamp,message,title);
        return forumDaoService.add(forum);
    }

    @PostMapping(value = "deleteForum")
    @ApiOperation("删除Forum数据")
        //删除数据
    int delete(int id) {
        return forumDaoService.delete(id);
    }

    @PostMapping(value = "findForumById")
    @ApiOperation("根据id查找Forum")
        //根据id查找
    Forum findUserById(int id) {
        return forumDaoService.findForumById(id);
    }

    @PostMapping(value = "updateForum")
    @ApiOperation("更新Forum数据")
        //更新数据
    int update(Forum forum) {
        return forumDaoService.update(forum);
    }
}
