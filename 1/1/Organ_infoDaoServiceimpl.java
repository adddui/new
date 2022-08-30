package com.example.project.service;
import com.example.project.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Organ_infoDaoServiceimpl {
    @Autowired
    Organ_inforDaoService organ_inforDaoService;
    @Override
    public List<User> findAll() {
        return organ_inforDao.findAll();
    }

    @Override
    public int add(organ_info organ_info) {
        return organ_inforDaoService.add(organ_info);
    }

    @Override
    public Integer delete(int id) {
        return organ_inforDaoService.delete(id);
    }

    @Override
    public Organ_info findOrganById(int id) {
        return organ_inforDaoService.findOrganById(id);
    }

    @Override
    public int update(Organ_info organ_info) {
        return organ_inforDaoService.update(organ_info);
    }
}

