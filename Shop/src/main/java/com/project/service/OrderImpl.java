package com.project.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domain.entity.Collection;
import com.project.domain.entity.Order;
import com.project.domain.repo.OrderRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderImpl implements OrderInterface{
	 @Autowired
	    private OrderRepo orderRepo;

	 @Override
	 public Order createOrder(String uuid, HashMap<String, Integer> products) {
	     String orderId = UUID.randomUUID().toString();
	     LocalDateTime createdDate = LocalDateTime.now();
	     LocalDateTime dateExpected = LocalDateTime.now();
	     String status = "created";

	     Order order = new Order(orderId, uuid, products, createdDate, dateExpected, status);

	     return orderRepo.save(order);
	 }

	    @Override
	    public Order getOrderById(String orderId) {
	        Optional<Order> optionalOrder = orderRepo.findByOrderId(orderId);
	        if (optionalOrder.isPresent()) {
	            return optionalOrder.get();
	        } else {
	            throw new RuntimeException("Order not found.");
	        }
	    }

	    @Override
	    public List<Order> getOrdersByUserId(String uuid) {
	        return orderRepo.findByUserId(uuid);
	    }

	    @Override
	    public List<Order> getOrdersByStatus(String status) {
	        return orderRepo.findAllByStatus(status);
	    }

	    @Override
	    public List<Order> getAllOrders() {
	        return orderRepo.findAll();
	    }

	    @Override
	    public Order updateOrderStatus(String orderId, String status) {
	        Order order = getOrderById(orderId);
	        order.setStatus(status);
	        return orderRepo.save(order);
	    }
}
