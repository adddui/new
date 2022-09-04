package com.example.project.controller;

import com.example.project.entity.Forum;
import com.example.project.entity.ForumVO;
import com.example.project.service.ForumDaoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("authority")
@Api
public class ForumController {
    @Autowired
    ForumDaoServiceImpl forumDaoService;

    @RequestMapping(value = "findAllForum")
    @ResponseBody
    @ApiOperation("查找所有Forum")
    List<ForumVO> findAll() {
        return forumDaoService.findAll();
    }

    @PostMapping(value = "addForum")
    @ApiOperation("新增Forum数据")
        //新增数据
    int add(@RequestBody HashMap <String,String> map) {

        int builder = Integer.parseInt(map.get("builder"));
        String message = map.get("message");
        String title = map.get("title");

        Timestamp timestamp=new Timestamp(Calendar.getInstance().get(
                Calendar.YEAR) - 1900, Calendar.getInstance().get(
                Calendar.MONTH), Calendar.getInstance().get(
                Calendar.DATE), Calendar.getInstance().get(
                Calendar.HOUR), Calendar.getInstance().get(
                Calendar.MINUTE), Calendar.getInstance().get(
                Calendar.SECOND), 0);
        Forum forum = new Forum(builder,timestamp,message,title);
        return forumDaoService.add(forum);
    }

    @PostMapping(value = "deleteForum")
    @ApiOperation("删除Forum数据")
        //删除数据
    int delete(int id) {
        return forumDaoService.delete(id);
    }

    @PostMapping(value = "findForumByUid")
    @ApiOperation("根据uid查找Forum")
        //根据Uid查找该用户所发的论坛
    Forum findUserByUid(@RequestBody HashMap<String, String> map) {
        int uid=Integer.parseInt(map.get("uid"));
        return forumDaoService.findForumByUid(uid);
    }
    @PostMapping(value = "updateForum")
    @ApiOperation("更新Forum数据")
        //更新数据
    int update(Forum forum) {
        return forumDaoService.update(forum);
    }
}
