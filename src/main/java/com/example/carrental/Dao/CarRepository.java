package com.example.carrental.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.example.carrental.Entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

//  @Query("Select c From Car c")
//List<Car> findCars(Pageable page);
//
//@Query("Select c From Car c Where c.isAvailable = true")
//List<Car> findAvailableCars(Pageable page);

}
