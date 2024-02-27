package com.mohittiwari.zomatodemo.service;

import com.mohittiwari.zomatodemo.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<String> getAllLocations(){
        return restaurantRepository.findLocationOfRestaurants();
    }
}
