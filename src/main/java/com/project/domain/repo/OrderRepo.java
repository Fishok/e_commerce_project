package com.project.domain.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.codeReturn.Codes;
import com.project.domain.entity.*;



@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    Optional<Order> findByOrderId(String orderId);
 
    List<Order> findByUserId(String uuid);

    List<Order> findAllByStatus(Codes status);

    @Override
    List<Order> findAll();

    
    Order addOrder( String orderId,  String userId,  String status,  HashMap<String, Integer> products);
}