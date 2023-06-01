package com.project.controllers;

import com.project.codeReturn.Codes;
import com.project.domain.entity.Order;
import com.project.dto.OrderDto;
import com.project.service.OrderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static com.project.api.ApiConstants.*;

@RestController
public class OrderController  {

    @Autowired
    OrderInterface service;

    @PutMapping(value = ADD_Order)
    public Codes createOrder(@RequestParam String userId, HashMap<String, Integer> products) {
        return null;//TODO
    }

    @GetMapping(value = GET_OrderById)
    public OrderDto getOrderById(@RequestParam String orderId) {
        return service.getOrderById(orderId);
    }

    @GetMapping(value = GET_OrderByUserId)
    public List<OrderDto> getOrdersByUserId(@RequestParam String userId) {
        return service.getOrdersByUserId(userId);
    }

    @GetMapping(value = GET_OrdersByStatus)
    public List<OrderDto> getOrdersByStatus(@RequestParam Codes status) {
        return service.getOrdersByStatus(status);
    }

    @GetMapping(value = GET_AllOrders)
    public List<OrderDto> getAllOrders() {
        return service.getAllOrders();
    }

    @PostMapping(value = SET_OrderStatus)
    public Codes updateOrderStatus(@RequestParam String orderId,@RequestParam Codes status) {
        return service.updateOrderStatus(orderId,status);
    }
}
