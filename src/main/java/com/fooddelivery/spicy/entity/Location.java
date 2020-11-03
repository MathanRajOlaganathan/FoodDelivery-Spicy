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
public class Location {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String locality;
    private String city;
    private String latitude;
    private String longitude;
    private String zipcode;
    private String countryId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cust_location_id")
    private Customer customer;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="rest_location_id")
    private Restaurant restaurant;

    public Location(String address, String locality, String city, String latitude, String longitude, String zipcode, String countryId, Restaurant restaurant) {
        this.address = address;
        this.locality = locality;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.zipcode = zipcode;
        this.countryId = countryId;
        this.restaurant = restaurant;
    }

    public Location(String address, String locality, String city, String latitude, String longitude, String zipcode, String countryId, Customer customer) {
        this.address = address;
        this.locality = locality;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.zipcode = zipcode;
        this.countryId = countryId;
        this.customer = customer;
    }
}
