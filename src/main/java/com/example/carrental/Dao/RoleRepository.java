package com.example.carrental.Dao;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.carrental.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

//    Optional<Role> findByName(String name);
		
}
