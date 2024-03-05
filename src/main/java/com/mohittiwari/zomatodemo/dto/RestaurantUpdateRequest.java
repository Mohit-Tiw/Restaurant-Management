package com.mohittiwari.zomatodemo.dto;

import lombok.Data;

@Data
public class RestaurantUpdateRequest {
    private String name;
    private String location;
}
