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
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer quantity;
    private Double amount;
    @ManyToOne
    @JoinColumn(name="order_id")
    private Order orderItem;

    public Item(String title, Integer quantity, Double amount, Order orderItem) {
        this.title = title;
        this.quantity = quantity;
        this.amount = amount;
        this.orderItem = orderItem;
    }
}
