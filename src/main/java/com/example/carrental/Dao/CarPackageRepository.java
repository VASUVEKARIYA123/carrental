package com.example.carrental.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.carrental.Entity.CarPackage;
import com.google.protobuf.Option;

public interface  CarPackageRepository extends JpaRepository<CarPackage,Long>{

	Optional<CarPackage> findByPackageName(String name);
}
