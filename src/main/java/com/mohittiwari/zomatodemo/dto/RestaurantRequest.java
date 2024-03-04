package com.mohittiwari.zomatodemo.dto;

import lombok.Data;

@Data
public class RestaurantRequest {
    private String name;
    private String location;
    private String rating;
}
