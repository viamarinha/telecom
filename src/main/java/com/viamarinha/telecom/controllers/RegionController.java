package com.viamarinha.telecom.controllers;

import com.viamarinha.telecom.models.Region;
import com.viamarinha.telecom.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/regions")
public class RegionController {


    private RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/allRegions")
    public String getAllRegions(Model model) {
        model.addAttribute("regions", regionService.getAllRegions());
        return "regions/allRegions";
    }

    @GetMapping("/getRegionById/{id}")
    public String getRegionById(@PathVariable("id") int id, Model model) {
        model.addAttribute("region", regionService.getRegionById(id));
        return "regions/showRegion";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("region", regionService.getRegionById(id));
        return "regions/update";
    }

    @PatchMapping("/update/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("region") Region region) {
        regionService.updateRegion(id, region);
        return "redirect:/regions/allRegions";
    }

    @GetMapping("delete/{id}")
        public String delete(@PathVariable("id") int id, Model model){
           model.addAttribute("region", regionService.getRegionById(id));
        return "/regions/delete";
        }

}
