package com.mohittiwari.zomatodemo.repository;

import com.mohittiwari.zomatodemo.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query(value = "select distinct location from restaurant", nativeQuery = true)
    List<String> findLocationOfRestaurants();
    @Query(value = "select * from restaurant where name like :name AND location = :location", nativeQuery = true)
    List<Restaurant> getRestaurantByName(String name, String location);

    List<Restaurant> findByLocation(String location);
    @Query(value = "select location from restaurant where location = :location" , nativeQuery = true)
    List<String> getLocation(String location);


}
