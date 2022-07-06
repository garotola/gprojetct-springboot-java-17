package com.garotinho.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garotinho.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
