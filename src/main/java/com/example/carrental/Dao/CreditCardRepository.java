package com.example.carrental.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.carrental.Entity.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
