package com.viamarinha.telecom.services;

import com.viamarinha.telecom.daos.StatusDao;
import com.viamarinha.telecom.models.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    private  StatusDao statusDao;

    public StatusService(StatusDao statusDao) {
        this.statusDao = statusDao;
    }

    public List<Status> getAllStatuses() {

        return statusDao.getAllStatuses();
    }

    public Status getStatusById(int id) {
        return statusDao.getStatusById(id);
    }

    public void addNewStatus(Status status) {
        statusDao.addNewStatus(status);
    }

    public void update(Status status, int id) {
        statusDao.update(status, id);
    }

    public void delete(int id) {
        statusDao.delete(id);
    }
}
