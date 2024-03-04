package com.mohittiwari.zomatodemo.service;

import com.mohittiwari.zomatodemo.dto.RestaurantRequest;
import com.mohittiwari.zomatodemo.entity.Rating;
import com.mohittiwari.zomatodemo.entity.Restaurant;
import com.mohittiwari.zomatodemo.exceptions.LocationNotFound;
import com.mohittiwari.zomatodemo.repository.RestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<String> getAllLocations(){
        return restaurantRepository.findLocationOfRestaurants();
    }


    public List<Restaurant> getRestaurant(String name, String location){
        if (name.isBlank()) {
            throw new RuntimeException("Name is Empty");
        }
        name = name.toLowerCase();
        name = name + "%";
        log.info("name is {}", name);
        return restaurantRepository.getRestaurantByName(name,location);
    }


    public Restaurant addRestaurant(RestaurantRequest restaurantRequest){
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantRequest.getName());
        restaurant.setLocation(restaurantRequest.getLocation());
        List<Rating> list = new ArrayList<>();
        Rating rating = new Rating();
        rating.setRating(restaurantRequest.getRating());
        list.add(rating);
        restaurant.setRatings(list);
        log.info("before saving {}", restaurant);
        restaurant = restaurantRepository.save(restaurant);
        log.info("After saving {}", restaurant);
        return restaurant;
    }

    public List<Restaurant> getAllRestaurants(String location) {
        if(location.isEmpty() || restaurantRepository.getLocation(location).isEmpty()){
            throw new LocationNotFound("Invalid location");
        }
        return restaurantRepository.findByLocation(location);
    }
}
