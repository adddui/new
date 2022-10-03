package com.example.project.service;


import com.example.project.dao.Out_messDao;
import com.example.project.entity.Out_mess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service("Out_messServiceImpl")
public class Out_messServiceImpl implements Out_messService {
    @Autowired
    Out_messDao outmessDao;

    @Override
    public List<Out_mess> findAll() {
        return outmessDao.findAll();
    }

    @Override
    public int add(Out_mess out_mess) {
        return outmessDao.add(out_mess);
    }

    @Override
    public int delete(int id) {
        return outmessDao.delete(id);
    }

    @Override
    public int update(Out_mess out_mess) {
        return outmessDao.update(out_mess);
    }

    @Override
    public Out_mess findOut_messById(int id) {
        return outmessDao.findOut_messById(id);
    }

    @Override
    public Out_mess findOut_messByUid(int uid) {
        return outmessDao.findOut_messByUid(uid);
    }
}
