package com.example.project.controller;

import com.example.project.entity.Notice;
import com.example.project.entity.User;
import com.example.project.service.NoticeDaoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api
public class NoticeController {
    @Autowired
    NoticeDaoServiceImpl noticeDaoService;

    @RequestMapping(value = "findAllNotice")
    @ApiOperation("查找所有")
    List<Notice> findAll() {
        return noticeDaoService.findAll();
    }

    @RequestMapping(value = "addNotice")
    @ApiOperation("新增数据")
        //新增数据
    int add(Notice notice) {
        return noticeDaoService.add(notice);
    }

    @RequestMapping(value = "deleteNotice")
    @ApiOperation("删除数据")
        //删除数据
    int delete(int id) {
        return noticeDaoService.delete(id);
    }

    @RequestMapping(value = "findNoticeById")
    @ApiOperation("根据id查找")
        //根据id查找
    Notice findUserById(int id) {
        return noticeDaoService.findNoticeById(id);
    }

    @RequestMapping(value = "updateNotice")
    @ApiOperation("更新数据")
        //更新数据
    int update(Notice notice) {
        return noticeDaoService.update(notice);
    }
}
