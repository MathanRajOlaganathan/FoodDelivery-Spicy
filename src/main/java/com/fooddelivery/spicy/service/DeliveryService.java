package com.fooddelivery.spicy.service;

import com.fooddelivery.spicy.entity.DeliveryExecutive;
import com.fooddelivery.spicy.entity.Order;
import com.fooddelivery.spicy.entity.enums.CurrentState;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 02-11-2020
 */
public interface DeliveryService {

    public DeliveryExecutive findByDeId(String deId);

    public Order getAcceptedOrderById(String deId);

    public List<Order> getAllOrders(String deId);

    public List<Order> getAllNewOrders();

    public void updateOrderState(String orderId, CurrentState state);




}
