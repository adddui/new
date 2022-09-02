package com.example.project.controller;


import com.example.project.entity.Out_mess;
import com.example.project.service.Out_messServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@Api
public class Out_messController {
    @Autowired
    Out_messServiceImpl outMessService;

    @PostMapping(value = "findAllOut_mess")
    @ApiOperation("查找所有Out_mess")
    List<Out_mess> findAll() {
        return outMessService.findAll();
    }

    @PostMapping(value = "addOut_mess")
    @ApiOperation("新增Out_mess数据")
        //新增数据
    int add(int uid, double temp, String pod, String destination, Date buildTime, Date startTime, Date endTime) {
        Out_mess out_mess=new Out_mess(uid,temp,pod,destination,buildTime,startTime,endTime);
        return outMessService.add(out_mess);
    }

    @PostMapping(value = "deleteOut_mess")
    @ApiOperation("删除Out_mess数据")
        //删除数据
    int delete(int id) {
        return outMessService.delete(id);
    }

    @PostMapping(value = "findOut_messById")
    @ApiOperation("根据id查找Out_mess")
        //根据id查找
    Out_mess findOut_messById(int id) {return outMessService.findOut_messById(id);}


    @PostMapping(value = "updateOut_mess")
    @ApiOperation("更新数据Out_mess")
        //更新数据
    int update(Out_mess out_mess) {
        return outMessService.update(out_mess);
    }
}
