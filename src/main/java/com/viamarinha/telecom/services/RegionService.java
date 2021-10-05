package com.viamarinha.telecom.services;

import com.viamarinha.telecom.daos.RegionDao;
import com.viamarinha.telecom.models.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    private RegionDao regionDao;

    @Autowired
    public RegionService(RegionDao regionDao) {
        this.regionDao = regionDao;
    }

    public List<Region> getAllRegions() {
        return regionDao.getAllRegions();
    }

    public Region getRegionById(int id) {
        return regionDao.getRegionById(id);
    }

    public void updateRegion(int id, Region region) {
        regionDao.updateRegion(id, region);
    }

    public void addNewRegion(Region region) {
        regionDao.addNewRegion(region);
    }
}
