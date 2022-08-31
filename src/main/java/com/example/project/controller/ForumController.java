package com.example.project.controller;

import com.example.project.entity.Forum;
import com.example.project.service.ForumDaoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api
public class ForumController {
    @Autowired
    ForumDaoServiceImpl forumDaoService;

    @RequestMapping(value = "findAllForum")
    @ResponseBody
    @ApiOperation("查找所有")
    List<Forum> findAll() {
        return forumDaoService.findAll();
    }

    @RequestMapping(value = "addForum")
    @ApiOperation("新增数据")
        //新增数据
    int add(Forum forum) {
        return forumDaoService.add(forum);
    }

    @RequestMapping(value = "deleteForum")
    @ApiOperation("删除数据")
        //删除数据
    int delete(int id) {
        return forumDaoService.delete(id);
    }

    @RequestMapping(value = "findForumById")
    @ApiOperation("根据id查找")
        //根据id查找
    Forum findUserById(int id) {
        return forumDaoService.findForumById(id);
    }

    @RequestMapping(value = "updateForum")
    @ApiOperation("更新数据")
        //更新数据
    int update(Forum forum) {
        return forumDaoService.update(forum);
    }
}
