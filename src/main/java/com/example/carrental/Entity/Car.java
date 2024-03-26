package com.example.carrental.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "car")
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "registration_no", nullable = false)
	private String registrationNo;
	
	@Column(name = "brand", nullable = false)
	private String brand;
	
	@Column(name = "model", nullable = false)
	private String model;
	
	@Column(name = "is_available", nullable = false)
	private Boolean isAvailable;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "car_package_id")
	private CarPackage carPackage;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "car_parameter_id")
	private CarParameters carParameters;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public CarParameters getCarParameters() {
		return carParameters;
	}

	public void setCarParameters(CarParameters carParameters) {
		this.carParameters = carParameters;
	}

	public Car(Long id, String registrationNo, String brand, String model, Boolean isAvailable,
			CarParameters carParameters) {
		super();
		this.id = id;
		this.registrationNo = registrationNo;
		this.brand = brand;
		this.model = model;
		this.isAvailable = isAvailable;
		this.carParameters = carParameters;
	}

	public Car() {
		super();
	}
	
	
}

