package com.garotinho.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garotinho.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
