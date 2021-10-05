package com.viamarinha.telecom.services;

import com.viamarinha.telecom.daos.OnuDao;
import com.viamarinha.telecom.models.Onu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OnuService {

    private OnuDao onuDao;

    @Autowired
    public OnuService(OnuDao onuDao) {
        this.onuDao = onuDao;
    }

    public List<Onu> getAllOnus(){
        return onuDao.getAllOnus();
    }

    public Onu getOnuById(int id) {
        return onuDao.getOnuById(id);
    }

    public void createOnu(Onu onu) {
        onuDao.createOnu(onu);
    }

    public void updateOnu(int id, Onu onu) {
        onuDao.updateOnu(id, onu);
    }

    public void deleteOnu(int id) {
        onuDao.deleteOnu(id);
    }
}
