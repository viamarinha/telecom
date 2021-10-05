package com.viamarinha.telecom.controllers;

import com.viamarinha.telecom.models.Onu;
import com.viamarinha.telecom.services.OnuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/onus")
public class OnuController {

    private final OnuService onuService;

    @Autowired
    public OnuController(OnuService onuService) {
        this.onuService = onuService;
    }


    @GetMapping("/getAllOnus")
    public String getAllOnus(Model model) {
        model.addAttribute("onus", onuService.getAllOnus());
        return "onus/getAllOnus";
    }

    @GetMapping("/getOnuById/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        model.addAttribute("onu", onuService.getOnuById(id));
        return "onus/showOnu";
    }

    @GetMapping("/newOnu")
    public String newOnu(Model model) {
        model.addAttribute("onu", new Onu());
        return "onus/newOnu";
    }

    @PostMapping("/createOnu")
    public String createOnu(@ModelAttribute("onu") Onu onu){
        onuService.createOnu(onu);
        return "redirect: /onus/getAllOnus";
    }

    @GetMapping("/edit/{id}")
    public String editOnu( @PathVariable("id") int id, Model model){
        model.addAttribute("onu", onuService.getOnuById(id));
        return "onus/updateOnu";
    }

    @PatchMapping("/update/{id}")
    public String updateOnu(@PathVariable("id") int id, @ModelAttribute("onu") Onu onu){
        onuService.updateOnu(id, onu);

        return "redirect: /onus/getAllOnus";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model){
        model.addAttribute("onu", onuService.getOnuById(id));
        return "onus/delete";
    }

    @DeleteMapping("/deleteOnu/{id}")
    public String deleteOnu(@PathVariable("id") int id){
        onuService.deleteOnu(id);
        return "redirect: /onus/getAllOnus";
    }
}
