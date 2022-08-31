package com.example.project.controller;

import com.example.project.entity.Notice;
import com.example.project.entity.User;
import com.example.project.service.NoticeDaoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api
public class NoticeController {
    @Autowired
    NoticeDaoServiceImpl noticeDaoService;

    @PostMapping(value = "findAllNotice")
    @ApiOperation("查找所有Notice")
    List<Notice> findAll() {
        return noticeDaoService.findAll();
    }

    @PostMapping(value = "addNotice")
    @ApiOperation("新增Notice数据")
        //新增数据
    int add(Notice notice) {
        return noticeDaoService.add(notice);
    }

    @PostMapping(value = "deleteNotice")
    @ApiOperation("删除Notice数据")
        //删除数据
    int delete(int id) {
        return noticeDaoService.delete(id);
    }

    @PostMapping(value = "findNoticeById")
    @ApiOperation("根据id查找Notice")
        //根据id查找
    Notice findUserById(int id) {
        return noticeDaoService.findNoticeById(id);
    }

    @PostMapping(value = "updateNotice")
    @ApiOperation("更新Notice数据")
        //更新数据
    int update(Notice notice) {
        return noticeDaoService.update(notice);
    }
}
