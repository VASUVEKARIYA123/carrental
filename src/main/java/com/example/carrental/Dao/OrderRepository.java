package com.example.carrental.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.carrental.Entity.PlacedOrder;

public interface OrderRepository extends JpaRepository<PlacedOrder, Long> {
	
	List<PlacedOrder> findByuserId(Long uid);
}

