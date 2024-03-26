package com.example.carrental.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "placed_order")
public class PlacedOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "user_id", nullable = false)
	private Long userId;
	
	@Column(name = "car_id", nullable = false)
	private Long carId;
	
	@Column(name = "order_time", nullable = false)
	private LocalDateTime orderTime;
	
	@Column(name = "start_time", nullable = false)
	private LocalDateTime startTime;
	
	@Column(name = "end_time", nullable = false)
	private LocalDateTime endTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "PlacedOrder [id=" + id + ", userId=" + userId + ", carId=" + carId + ", orderTime=" + orderTime
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

	public PlacedOrder(Long id, Long userId, Long carId, LocalDateTime orderTime, LocalDateTime startTime,
			LocalDateTime endTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.carId = carId;
		this.orderTime = orderTime;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public PlacedOrder() {
		super();
	}
	
	
}
