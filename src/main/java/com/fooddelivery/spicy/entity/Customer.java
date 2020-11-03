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
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customer")
    private Location custLocation;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order custOrder;

    public Customer(String firstName, String lastName, String phoneNumber, Order custOrder) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.custOrder = custOrder;
    }
}
