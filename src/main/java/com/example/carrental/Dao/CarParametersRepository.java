package com.example.carrental.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.carrental.Entity.CarParameters;

public interface CarParametersRepository extends JpaRepository<CarParameters, Long> {
}
