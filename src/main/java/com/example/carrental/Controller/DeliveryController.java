package com.example.carrental.Controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carrental.Entity.Car;
import com.example.carrental.Service.DeliveryService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api")
public class DeliveryController {
	private final DeliveryService deliveryService;

    public DeliveryController(@Qualifier("deliveryService") DeliveryService deliveryService) {
		super();
		this.deliveryService = deliveryService;
	}

	@PostMapping("/delivery/{username}/{carId}")
    public Car pickUpTheCar(@PathVariable String username,@PathVariable Long carId) {
            return deliveryService.pickUpTheCar(username,carId);
    }

}
