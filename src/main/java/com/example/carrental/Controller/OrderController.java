package com.example.carrental.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.carrental.Entity.AccessKey;
import com.example.carrental.Entity.PlacedOrder;
import com.example.carrental.Service.OrderService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	private final OrderService orderService;
	
	@Autowired
	public OrderController(OrderService theorderService) {
		orderService = theorderService;
	}
    @GetMapping("/orders/{username}")
    public List<PlacedOrder> getOrders(@PathVariable String username) {
        return orderService.getOrders(username);
    }

    @PostMapping("/orders/{username}/{carPackage}/{hours}")
    public AccessKey submitOrder(@PathVariable String username,@PathVariable String carPackage, @PathVariable Integer hours) {
        return orderService.submitOrder(username,carPackage, hours);
    }

}
