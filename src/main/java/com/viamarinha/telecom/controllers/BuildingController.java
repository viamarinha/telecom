package com.viamarinha.telecom.controllers;

import com.viamarinha.telecom.models.Building;
import com.viamarinha.telecom.services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("building")
public class BuildingController {

    private BuildingService buildingService;

    @Autowired
    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @GetMapping("/getAllBuildings")
    public String getAllBuildings(Model model) {
        model.addAttribute("buildings", buildingService.getAllBuildings());
        return "buildings/allBuildings";
    }
    @GetMapping("getBuildingById/{id}")
    public String getBuildingById(Model model, @PathVariable("id") int id){
        model.addAttribute("building", buildingService.getBuildingById(id));
        return "buildings/showBuilding";
    }
    @GetMapping("/edit/{id}")
    public String editBuilding(@PathVariable("id") int id, Model model){
        model.addAttribute("building", buildingService.getBuildingById(id));
        return "buildings/edit";
    }
    @PatchMapping("/update/{id}")
    public String edit(@PathVariable("id") int id, @ModelAttribute("building") Building updatedBuilding){
        buildingService.editBuilding(id, updatedBuilding);
        return "redirect:/building/getAllBuildings";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model){
        model.addAttribute("building", buildingService.getBuildingById(id));
        return "buildings/deleteBuilding";
    }
    @DeleteMapping("/deleteBuilding/{id}")
    public  String  deleteBuilding(@PathVariable("id") int id){
        buildingService.deleteBuilding(id);
        return "redirect:/building/getAllBuildings";
    }

}
