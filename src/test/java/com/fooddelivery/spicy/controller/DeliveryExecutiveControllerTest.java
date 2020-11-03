package com.fooddelivery.spicy.controller;


import com.fooddelivery.spicy.entity.DeliveryExecutive;
import com.fooddelivery.spicy.entity.Order;
import com.fooddelivery.spicy.entity.enums.CurrentState;
import com.fooddelivery.spicy.service.DeliveryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 02-11-2020
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = DeliveryController.class)
public class DeliveryExecutiveControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeliveryService deliveryService;

    @Test
    public void getDeByIdTest() throws Exception {
        String expected = "{deId:p343,firstName:Rahul,lastName:Raj,phoneNumber:abc,todayEarnings:200.00,weeklyEarnings:1000.00,monthlyEarnings:15000.00}";
        DeliveryExecutive deliveryExecutive = new DeliveryExecutive("p343", "Rahul", "Raj", "abc", 200.00, 1000.00, 15000.00);
        when(deliveryService.findByDeId("p343")).thenReturn(deliveryExecutive);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/de/p343")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        JSONAssert.assertEquals(expected, mvcResult.getResponse()
                .getContentAsString(), false);
    }

    @Test
    public void getAcceptedOrderTest() throws Exception {
        String expected = "{\"id\":null,\"orderId\":\"b45453a2-21b2-9589-ac45-a949845ad254\",\"displayId\":\"AD254\",\"placedDate\":\"01\\/11\\/2020\",\"currentState\":\"ACCEPTED\",\"item\":null,\"customer\":null,\"restaurant\":null,\"deId\":\"c783\"}";
        Order order2 = new Order("b45453a2-21b2-9589-ac45-a949845ad254","AD254",new SimpleDateFormat("dd/MM/yyyy").parse("01/11/2020"), CurrentState.ACCEPTED,"c783");
        when(deliveryService.getAcceptedOrderById("c783")).thenReturn(order2);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/de/order/c783")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        JSONAssert.assertEquals(expected, mvcResult.getResponse()
                .getContentAsString(), false);
    }

    @Test
    public void getCreatedOrderTest() throws Exception {
        String expected = "[{\"id\":null,\"orderId\":\"b45453a2-21b2-9589-ac45-a949845ad254\",\"displayId\":\"AD254\",\"placedDate\":\"01\\/11\\/2020\",\"currentState\":\"CREATED\",\"item\":null,\"customer\":null,\"restaurant\":null,\"deId\":\"c783\"},{\"id\":null,\"orderId\":\"asdsd656-45as-7894-s565-2asd2asds655\",\"displayId\":\"DS655\",\"placedDate\":\"01\\/10\\/2020\",\"currentState\":\"CREATED\",\"item\":null,\"customer\":null,\"restaurant\":null,\"deId\":\"c783\"}]";
        Order order1 = new Order("b45453a2-21b2-9589-ac45-a949845ad254","AD254",new SimpleDateFormat("dd/MM/yyyy").parse("01/11/2020"), CurrentState.CREATED,"c783");
        Order order2 = new Order("asdsd656-45as-7894-s565-2asd2asds655","DS655",new SimpleDateFormat("dd/MM/yyyy").parse("01/10/2020"), CurrentState.CREATED,"c783");
          when(deliveryService.getAllNewOrders()).thenReturn(List.of(order1,order2));
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/de/allOrders")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        JSONAssert.assertEquals(expected, mvcResult.getResponse()
                .getContentAsString(), false);
    }

    @Test
    public void getAllordersTest() throws Exception {
        String expected = "[{\"id\":null,\"orderId\":\"b45453a2-21b2-9589-ac45-a949845ad254\",\"displayId\":\"AD254\",\"placedDate\":\"01\\/11\\/2020\",\"currentState\":\"ACCEPTED\",\"item\":null,\"customer\":null,\"restaurant\":null,\"deId\":\"c783\"},{\"id\":null,\"orderId\":\"asdsd656-45as-7894-s565-2asd2asds655\",\"displayId\":\"DS655\",\"placedDate\":\"01\\/10\\/2020\",\"currentState\":\"DELIVERED\",\"item\":null,\"customer\":null,\"restaurant\":null,\"deId\":\"c783\"}]";
        Order order1 = new Order("b45453a2-21b2-9589-ac45-a949845ad254","AD254",new SimpleDateFormat("dd/MM/yyyy").parse("01/11/2020"), CurrentState.ACCEPTED,"c783");
        Order order2 = new Order("asdsd656-45as-7894-s565-2asd2asds655","DS655",new SimpleDateFormat("dd/MM/yyyy").parse("01/10/2020"), CurrentState.DELIVERED,"c783");
        when(deliveryService.getAllOrders("c783")).thenReturn(List.of(order1,order2));
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/de/history/c783")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        JSONAssert.assertEquals(expected, mvcResult.getResponse()
                .getContentAsString(), false);
    }


    @Test
    public void updateOrderTest() throws Exception {
        String expected = "[{\"id\":null,\"orderId\":\"b45453a2-21b2-9589-ac45-a949845ad254\",\"displayId\":\"AD254\",\"placedDate\":\"01\\/11\\/2020\",\"currentState\":\"ACCEPTED\",\"item\":null,\"customer\":null,\"restaurant\":null,\"deId\":\"c783\"},{\"id\":null,\"orderId\":\"asdsd656-45as-7894-s565-2asd2asds655\",\"displayId\":\"DS655\",\"placedDate\":\"01\\/10\\/2020\",\"currentState\":\"DELIVERED\",\"item\":null,\"customer\":null,\"restaurant\":null,\"deId\":\"c783\"}]";
        Order order1 = new Order("b45453a2-21b2-9589-ac45-a949845ad254","AD254",new SimpleDateFormat("dd/MM/yyyy").parse("01/11/2020"), CurrentState.ACCEPTED,"c783");
        Order order2 = new Order("asdsd656-45as-7894-s565-2asd2asds655","DS655",new SimpleDateFormat("dd/MM/yyyy").parse("01/10/2020"), CurrentState.DELIVERED,"c783");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.patch("/api/de/update/c783")
                .param("state","delivered")
                .param("orderId","b45453a2-21b2-9589-ac45-a949845ad254")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        assertEquals("Order state changed to DELIVERED successfully", mvcResult.getResponse().getContentAsString());

    }



}
