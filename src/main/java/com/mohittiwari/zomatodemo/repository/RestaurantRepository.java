package com.mohittiwari.zomatodemo.repository;

import com.mohittiwari.zomatodemo.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query(value = "select distinct location from restaurant", nativeQuery = true)
    List<String> findLocationOfRestaurants();
}
