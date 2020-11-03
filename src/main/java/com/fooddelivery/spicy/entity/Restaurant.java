package com.fooddelivery.spicy.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 02-11-2020
 */

@Entity
@Data
@RequiredArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private Location resLocation;
    private String phoneNumber;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="restaurant_id")
    private Order restaurantOrder;

    public Restaurant(String name, String url, String phoneNumber, Order restaurantOrder) {
        this.name = name;
        this.url = url;
        this.phoneNumber = phoneNumber;
        this.restaurantOrder = restaurantOrder;
    }
}
