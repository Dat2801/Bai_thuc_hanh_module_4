package com.codegym.baithmd4.controller;


import com.codegym.baithmd4.model.City;
import com.codegym.baithmd4.model.Country;
import com.codegym.baithmd4.service.city.ICityService;
import com.codegym.baithmd4.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private ICityService cityService;

    @Autowired
    private ICountryService countryService;

    @ModelAttribute("listCountry")
    public List<Country> countries() {
        return countryService.findAll();
    }

    @GetMapping("")
    public ModelAndView ShowAll() {
        ModelAndView modelAndView = new ModelAndView("city/list");
        List<City> cities = cityService.findAll();
        modelAndView.addObject("city", cities);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView showFormEdit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("city/edit");
        modelAndView.addObject("city", cityService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editCity(@PathVariable Long id, @ModelAttribute City city) {
        cityService.save(city);
        return new ModelAndView("redirect:/cities");
    }

    @GetMapping("delete/{id}")
    public ModelAndView deleteCity(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/cities");
        cityService.deleteById(id);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("city/create");
        modelAndView.addObject("c", new City());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCity(@Validated @ModelAttribute City city, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("city/create");
//            modelAndView.addObject("c",city);
            return modelAndView;
        }
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("redirect:/cities");
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewDetail(@PathVariable Long id) {
        return new ModelAndView("city/view", "city", cityService.findById(id));
    }
}
