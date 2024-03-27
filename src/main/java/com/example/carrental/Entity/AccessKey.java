package com.example.carrental.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "access_key")
public class AccessKey {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique =true, nullable = false)
	private Long id;
	
	@Column(name = "car_package", nullable = false)
	private String carPackage;
	
	@Column(name = "hours", nullable = false)
	private Integer hours;
	
	@OneToOne(mappedBy = "accesskey")
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarPackage() {
		return carPackage;
	}

	public void setCarPackage(String carPackage) {
		this.carPackage = carPackage;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AccessKey(Long id, String carPackage, Integer hours, User user) {
		super();
		this.id = id;
		this.carPackage = carPackage;
		this.hours = hours;
		this.user = user;
	}

	public AccessKey() {
		super();
	}
	
	
}

