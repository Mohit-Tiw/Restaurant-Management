package com.mohittiwari.zomatodemo.controller;

import com.mohittiwari.zomatodemo.entity.Restaurant;
import com.mohittiwari.zomatodemo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/locations")
    public List<String> findAll(){
        return restaurantService.getAllLocations();
    }
}
