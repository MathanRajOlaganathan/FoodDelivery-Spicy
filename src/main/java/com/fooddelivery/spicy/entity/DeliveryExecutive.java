package com.fooddelivery.spicy.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 02-11-2020
 */
@Entity
@Data
@RequiredArgsConstructor
public class DeliveryExecutive {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String deId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Double todayEarnings;
    private Double weeklyEarnings;
    private Double monthlyEarnings;

    public DeliveryExecutive(String deId, String firstName, String lastName, String phoneNumber, Double todayEarnings, Double weeklyEarnings, Double monthlyEarnings) {
        this.deId = deId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.todayEarnings = todayEarnings;
        this.weeklyEarnings = weeklyEarnings;
        this.monthlyEarnings = monthlyEarnings;
    }
}
