package com.example.carrental.Dao;

import java.util.Optional;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.carrental.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByuserName(String username);

}