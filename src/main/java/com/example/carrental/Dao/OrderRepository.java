package com.example.carrental.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.carrental.Entity.PlacedOrder;

public interface OrderRepository extends JpaRepository<PlacedOrder, Long> {
	
}

