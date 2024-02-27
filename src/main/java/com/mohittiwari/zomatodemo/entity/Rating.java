package com.mohittiwari.zomatodemo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rating;
    @ManyToOne
    User user;
    @ManyToOne
    Restaurant restaurant;
}
