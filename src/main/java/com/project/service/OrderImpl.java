package com.project.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.codeReturn.Codes;
import com.project.domain.entity.*;

import com.project.domain.repo.*;
import com.project.dto.*;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderImpl implements OrderInterface {

	private final OrderRepo orderRepo;

	@Autowired
	public OrderImpl(OrderRepo orderRepo) {
		this.orderRepo = orderRepo;
	}

	@Override
	public Codes createOrder(String uuid, HashMap<String, Integer> products) {
		String orderId = UUID.randomUUID().toString();
		LocalDateTime createdDate = LocalDateTime.now();
		LocalDateTime dateExpected = LocalDateTime.now();
		Codes status = Codes.OK;

		Order order = new Order(orderId, uuid, products, createdDate, dateExpected, status);


	    Order savedOrder = orderRepo.save(order);
	    return savedOrder != null ? Codes.OK : Codes.WRONG;
	}

	@Override
	public OrderDto getOrderById(String orderId) {
		Optional<Order> optionalOrder = orderRepo.findByOrderId(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
           
            OrderDto orderDto = new OrderDto();
            orderDto.setUserId(order.getUuid());
            orderDto.setProducts(mapToProductDTOs(order.getProducts()));
            orderDto.setStatus(order.getStatus());
            return orderDto;
        } else {
            throw new RuntimeException("Order not found.");
        }
    }
	

	@Override
    public List<OrderDto> getOrdersByUserId(String userId) {
        List<Order> orders = orderRepo.findByUserId(userId);
        return mapToOrderDTOs(orders);
    }

    @Override
    public List<OrderDto> getOrdersByStatus(Codes status) {
        List<Order> orders = orderRepo.findAllByStatus(status);
        return mapToOrderDTOs(orders);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepo.findAll();
        return mapToOrderDTOs(orders);
    }

    @Override
    public Codes updateOrderStatus(String orderId, Codes status) {
        Optional<Order> optionalOrder = orderRepo.findByOrderId(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setStatus(status);
            orderRepo.save(order);
            return Codes.OK;
        } else {
            return Codes.WRONG;
        }
    }

    private List<OrderDto> mapToOrderDTOs(List<Order> orders) {
        List<OrderDto> orderDTOs = new ArrayList<>();
        for (Order order : orders) {
            OrderDto orderDto = new OrderDto();
            orderDto.setUserId(order.getUuid());
            orderDto.setProducts(mapToProductDTOs(order.getProducts()));
            orderDto.setStatus(order.getStatus());
            orderDTOs.add(orderDto);
        }
        return orderDTOs;
    }

    private List<ProductDTO> mapToProductDTOs(HashMap<String, Integer> products) {
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            ProductDTO productDTO = new ProductDTO();
            productDTOs.add(productDTO);
        }
        return productDTOs;
    }
}
