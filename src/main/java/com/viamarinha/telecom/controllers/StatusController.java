package com.viamarinha.telecom.controllers;


import com.viamarinha.telecom.models.Status;
import com.viamarinha.telecom.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

@RequestMapping("/status")
public class StatusController {

    private final StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/allStatuses")
    public String getAllStatuses(Model model) {

        model.addAttribute("status", statusService.getAllStatuses());
        return "statuses/allStatuses";
    }

    @GetMapping("/statusById/{id}")
    public String getStatusById(@PathVariable("id") int id, Model model) {

        model.addAttribute("status", statusService.getStatusById(id));
        return "statuses/showStatus";
    }

    @GetMapping("/createStatus")
    public String addNewStatus(@ModelAttribute("status") Status status) {
        return "statuses/create";
    }

    @PostMapping("/create")
    public String createStatus(@ModelAttribute("status") Status status) {
        statusService.addNewStatus(status);
        return "redirect:/status/allStatuses";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("status", statusService.getStatusById(id));
        return "/statuses/edit";
    }

    @PatchMapping("/update/{id}")
    public String update(@ModelAttribute("status") Status status, @PathVariable("id") int id) {
        statusService.update(status, id);
        return "redirect:/status/allStatuses";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        statusService.delete(id);
        return "redirect:/status/allStatuses";
    }

}














