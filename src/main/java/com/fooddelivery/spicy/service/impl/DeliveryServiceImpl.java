package com.fooddelivery.spicy.service.impl;

import com.fooddelivery.spicy.entity.DeliveryExecutive;
import com.fooddelivery.spicy.entity.Order;
import com.fooddelivery.spicy.entity.enums.CurrentState;
import com.fooddelivery.spicy.exception.OrderNotAvaialableException;
import com.fooddelivery.spicy.exception.RecordNotFoundException;
import com.fooddelivery.spicy.repository.DeliveryExecutiveRepository;
import com.fooddelivery.spicy.repository.OrderRepository;
import com.fooddelivery.spicy.service.DeliveryService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 02-11-2020
 */
@Service
@Slf4j
@NoArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {


    private DeliveryExecutiveRepository deliveryExecutiveRepository;

    private OrderRepository orderRepository;

    @Autowired
    public DeliveryServiceImpl(DeliveryExecutiveRepository deliveryExecutiveRepository, OrderRepository orderRepository) {
        this.deliveryExecutiveRepository = deliveryExecutiveRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public DeliveryExecutive findByDeId(String deId) {
        log.info("Fetching the DeliveryExecutive:DeliveryServiceImpl:findByDeId(): "+deId);
        return deliveryExecutiveRepository.getDeliveryExecutiveByDeId(deId).orElseThrow(()->new RecordNotFoundException("No Records found for this delivery executive id: "+deId));
    }

    @Override
    public Order getAcceptedOrderById(String deId) {
        log.info("Fetching the current order:DeliveryServiceImpl:getAcceptedOrderById(): "+deId);
        return orderRepository.findOrderByDeIdAndCurrentState(deId, CurrentState.ACCEPTED).orElseThrow(()-> new OrderNotAvaialableException("No Orders with accepted state available for this id: "+deId));
    }

    @Override
    public List<Order> getAllOrders(String deId) {
        log.info("Fetching all the orders:DeliveryServiceImpl:getAcceptedOrderById(): "+deId);
        return orderRepository.findAllByDeId(deId).orElseThrow(()->new OrderNotAvaialableException("No Orders available for this id: "+deId));
    }

    @Override
    public void updateOrderState(String orderId, CurrentState state) {
        log.info("Updating the Order state:DeliveryServiceImpl:updateOrderState(): "+orderId);
        orderRepository.updateOrderState(orderId,state);
    }

    @Override
    public List<Order> getAllNewOrders() {
        log.info("Fetching all the created orders:DeliveryServiceImpl:getOrders(): ");
         return orderRepository.findOrderByCurrentStateOrderByPlacedDateAsc(CurrentState.CREATED).orElseThrow(()-> new OrderNotAvaialableException("No Orders available with the created state"));

    }}
