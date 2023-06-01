package com.project.service;

import java.util.HashMap;
import java.util.List;

import com.project.codeReturn.Codes;
import com.project.domain.entity.Order;
import com.project.dto.OrderDto;

public interface OrderInterface {
	Codes createOrder(String userId, HashMap<String, Integer> products);
    OrderDto getOrderById(String orderId);
    List<OrderDto> getOrdersByUserId(String userId);
    List<OrderDto> getOrdersByStatus(Codes status);
    List<OrderDto> getAllOrders();
    Codes updateOrderStatus(String orderId, Codes status);
}
