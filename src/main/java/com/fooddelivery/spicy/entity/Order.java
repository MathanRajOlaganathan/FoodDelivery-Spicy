package com.fooddelivery.spicy.entity;

import com.fooddelivery.spicy.entity.enums.CurrentState;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 02-11-2020
 */
@Entity
@Data
@RequiredArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String orderId;
    private String displayId;
    @Temporal(TemporalType.DATE)
    private Date placedDate;
    @Enumerated(value = EnumType.STRING)
    private CurrentState currentState;
    @OneToMany(mappedBy = "orderItem",fetch = FetchType.LAZY)
    private List<Item> item;
    @OneToOne(mappedBy ="custOrder",fetch = FetchType.LAZY)
    private Customer customer;
    @OneToOne(mappedBy ="restaurantOrder",fetch = FetchType.LAZY)
    private Restaurant restaurant;
    private String deId;

    public Order(String orderId, String displayId, Date placedDate, CurrentState currentState, String deId) {
        this.orderId = orderId;
        this.displayId = displayId;
        this.placedDate = placedDate;
        this.currentState = currentState;
        this.deId = deId;
    }
}
