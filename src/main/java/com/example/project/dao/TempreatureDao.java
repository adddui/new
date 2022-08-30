package com.example.project.dao;
import com.example.project.entity.User;
import com.example.project.entity.Tempreature;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public class TempreatureDao {
    public interface TempreatureDao {
        /**
         *
         * @return
         */
        List< Tempreature> findAll();

        /**
         *
         * @param Organ_infor
         * @return
         */
        //新增数据
        int add( Tempreature organ_info);

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
        Tempreature findOrganById(int id);

        /**
         *
         * @param Organ_infor
         * @return
         */
        //更新数据
        int update( Tempreature organ_info);
    }


}
