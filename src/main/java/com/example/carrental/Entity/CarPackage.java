package com.example.carrental.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "car_package")
public class CarPackage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "package_name", nullable = false)
	private String packageName;
	
	@Column(name = "price_per_hour", nullable = false)
	private Integer pricePerHour;
	
	@OneToMany(mappedBy = "carPackage", cascade = CascadeType.ALL)
	private List<Car> cars;
}

