package com.onlinepizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinepizza.entity.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

	
}
