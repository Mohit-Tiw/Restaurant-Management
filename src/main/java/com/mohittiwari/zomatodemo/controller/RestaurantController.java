package com.mohittiwari.zomatodemo.controller;

import com.mohittiwari.zomatodemo.dto.RestaurantRequest;
import com.mohittiwari.zomatodemo.entity.Restaurant;
import com.mohittiwari.zomatodemo.exceptions.LocationNotFound;
import com.mohittiwari.zomatodemo.service.RestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
@RestController
@Slf4j
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/locations")
    public List<String> findAllLocations(){
        return restaurantService.getAllLocations();
    }


    @GetMapping("/restaurant")
    public List<Restaurant> searchRestaurant(@RequestParam(required = true) String name, @RequestParam String location){
        log.info("search for {}", name);
        return restaurantService.getRestaurant(name,location);
    }
    @PostMapping("/restaurant")
    public Restaurant addRestaurant(@RequestBody RestaurantRequest restaurantRequest){
        return restaurantService.addRestaurant(restaurantRequest);
    }
    @GetMapping("/restaurant/location/{location}")
    public List<Restaurant> getAllRestaurant(@PathVariable String location){
        return restaurantService.getAllRestaurants(location);
    }
    @ExceptionHandler(LocationNotFound.class)
    public String handleException(LocationNotFound ex, WebRequest request){
        return ex.getMessage();
    }

}
