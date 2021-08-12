package com.viamarinha.telecom.controllers;

import com.viamarinha.telecom.models.City;
import com.viamarinha.telecom.services.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cities")
public class CitiesController {

    private CitiesService citiesService;

    @Autowired
    public CitiesController(CitiesService citiesService) {
        this.citiesService = citiesService;
    }

    @GetMapping("/getAllCities")
    public String getAllCities(Model model) {
        model.addAttribute("cities", citiesService.getAllCities());
        return "/cities/allCities";
    }

    @GetMapping("/createNewCity")
    public String createNewCity(Model model) {
        model.addAttribute("city", new City());
        return "/cities/newCity";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("city") City city) {
        citiesService.addNewCity(city);
        return "redirect:/cities/getAllCities";
    }


    @GetMapping("/findById/{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        model.addAttribute("city", citiesService.findCityById(id));
        return "/cities/show";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("city", citiesService.findCityById(id));
        return "/cities/edit";
    }

    @PatchMapping("/update/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("city") City city) {
        citiesService.updateCity(id, city);
        return "redirect:/cities/getAllCities";
    }

    @GetMapping("/deleteCity/{id}")
    public String deleteCity(@PathVariable("id") int id, Model model) {
        model.addAttribute("city", citiesService.findCityById(id));
        return "cities/delete";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        citiesService.delete(id);
        return "redirect:/cities/getAllCities";
    }
}
