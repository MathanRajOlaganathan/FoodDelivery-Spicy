package com.fooddelivery.spicy.service;

import com.fooddelivery.spicy.entity.Order;
import com.fooddelivery.spicy.entity.enums.CurrentState;
import com.fooddelivery.spicy.exception.OrderNotAvaialableException;
import com.fooddelivery.spicy.repository.DeliveryExecutiveRepository;
import com.fooddelivery.spicy.repository.OrderRepository;
import com.fooddelivery.spicy.service.impl.DeliveryServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 02-11-2020
 */
public class DeliveryServiceTest {


    private DeliveryServiceImpl deliveryServiceMock;

    private DeliveryExecutiveRepository deliveryRepositoryMock;

    private OrderRepository orderRepositoryMock;

    @Before
    public void setUp() {
        deliveryRepositoryMock = Mockito.mock(DeliveryExecutiveRepository.class);
        orderRepositoryMock = Mockito.mock(OrderRepository.class);
        deliveryServiceMock = new DeliveryServiceImpl(deliveryRepositoryMock,orderRepositoryMock);
    }

    @Test
    public void getAllOrders() throws ParseException {
        Order order1 = new Order("b45453a2-21b2-9589-ac45-a949845ad254","AD254",new SimpleDateFormat("dd/MM/yyyy").parse("01/11/2020"), CurrentState.ACCEPTED,"c783");
        Order order2 = new Order("asdsd656-45as-7894-s565-2asd2asds655","DS655",new SimpleDateFormat("dd/MM/yyyy").parse("01/10/2020"), CurrentState.DELIVERED,"c783");
        when(orderRepositoryMock.findAllByDeId("c783")).thenReturn(Optional.of(List.of(order1,order2)));
        List<Order> orders = deliveryServiceMock.getAllOrders("c783");
        assertNotNull(orders);
    }
}
