package com.garotinho.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garotinho.course.entities.Category;
import com.garotinho.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}