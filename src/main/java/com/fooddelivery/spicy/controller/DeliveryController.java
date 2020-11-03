package com.fooddelivery.spicy.controller;

import com.fooddelivery.spicy.entity.DeliveryExecutive;
import com.fooddelivery.spicy.entity.Order;
import com.fooddelivery.spicy.entity.enums.CurrentState;
import com.fooddelivery.spicy.service.DeliveryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.fooddelivery.spicy.common.ApplicationConstants.DE_ROOT_PATH;

/**
 *The Controller provides api for the delivery executive dashboard .
 * @author Mathan Raj O
 * @version 1.0
 * @since 02-11-2020
 */
@RestController
@RequestMapping(path=DE_ROOT_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class DeliveryController {

    private DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("{deId}")
    @ApiOperation("Retrieves delivery executive details using de id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful retrieval of delivery executive details")})
    public DeliveryExecutive getDeById(@PathVariable String deId) {
        return deliveryService.findByDeId(deId);
    }

    @GetMapping("order/{deId}")
    @ApiOperation("Retrieves the accepted order details using de id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful retrieval of accepted order details")})
    public Order getAcceptedOrder(@PathVariable String deId) {
        return deliveryService.getAcceptedOrderById(deId);
    }

    @GetMapping("history/{deId}")
    @ApiOperation("Retrieves all the orders handled by the delivery executive using de id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful retrieval of all the order details handled by the de ")})
    public List<Order> getAllorders(@PathVariable String deId) {
        return deliveryService.getAllOrders(deId);
    }

    @GetMapping("allOrders")
    @ApiOperation("Retrieves all the newly created orders")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful retrieval of all the newly created orders ")})
    public List<Order> getAllNewOrders() {
        return deliveryService.getAllNewOrders();
    }

    @PatchMapping("update/{deId}")
    @ApiOperation("Update the order state using the order id and state")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful update of the order state")})
    public String updateOrder(@PathVariable String deId,@RequestParam("state")CurrentState state,@RequestParam("orderId")String orderId) {
        deliveryService.updateOrderState(orderId, state);
        return "Order state changed to "+state+" successfully";
    }

    }
