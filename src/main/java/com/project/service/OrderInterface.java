package com.project.service;

import java.util.HashMap;
import java.util.List;

import com.project.domain.entity.Order;


public interface OrderInterface {
	Order createOrder(String userId, HashMap<String, Integer> products);
    Order getOrderById(String orderId);
    List<Order> getOrdersByUserId(String userId);
    List<Order> getOrdersByStatus(String status);
    List<Order> getAllOrders();
    Order updateOrderStatus(String orderId, String status);
}
