package com.example.project.dao;
import com.example.project.entity.User;
import com.example.project.entity.Organ_info;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public class Organ_infoDao {
    public interface Organ_inforDao {
        /**
         *
         * @return
         */
        List<Organ_info> findAll();

        /**
         *
         * @param Organ_info
         * @return
         */
        //新增数据
        int add(Organ_info organ_info);

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
        Organ_info findOrganById(int id);

        /**
         *
         * @param Organ_info
         * @return
         */
        //更新数据
        int update(Organ_info organ_info);
    }

}
