package com.project.domain.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.project.domain.entity.*;

import jakarta.transaction.Transactional;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    Optional<Order> findByOrderId(String orderId);
    @Query("SELECT o FROM Order o WHERE o.uuid = :uuid")
    List<Order> findByUserId(String uuid);

    List<Order> findAllByStatus(String status);

    @Override
    List<Order> findAll();

    @Modifying
    @Query(value = "INSERT INTO `Order`(order_id, user_id, status, products) VALUES (:orderId, :userId, :status, :products)", nativeQuery = true)
    @Transactional
    Order addOrder(@Param("orderId") String orderId, @Param("userId") String userId, @Param("status") String status, @Param("products") HashMap<String, Integer> products);
}