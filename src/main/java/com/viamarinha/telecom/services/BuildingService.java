package com.viamarinha.telecom.services;

import com.viamarinha.telecom.daos.BuildingDao;
import com.viamarinha.telecom.models.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {

    private  BuildingDao buildingDao;

    @Autowired
    public BuildingService(BuildingDao buildingDao) {
        this.buildingDao = buildingDao;
    }

    public List<Building> getAllBuildings() {
        return buildingDao.getAllBuildings();
    }

    public Building getBuildingById(int id) {
       return buildingDao.getBuildingById(id);
    }

    public void editBuilding(int id, Building updatedBuilding) {
        buildingDao.updateBuilding(id, updatedBuilding);
    }

    public void deleteBuilding(int id) {
        buildingDao.deleteBuilding(id);
    }
}
