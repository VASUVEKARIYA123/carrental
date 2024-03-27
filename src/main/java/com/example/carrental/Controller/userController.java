package com.example.carrental.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carrental.Entity.User;
import com.example.carrental.Service.UserService;


@RestController
@RequestMapping("/api")
public class userController {

	private UserService service;
	
	@Autowired
	public userController(UserService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("user/{id}")
	public Optional<User> findById(@PathVariable("id") int id) {		
		return service.find(id);
		
	}
	
	@GetMapping("users")
	public List<User> findAllUsers(){
		return service.findAll();
	}
	
	@PostMapping("user")
	public Boolean addUser(@RequestBody User usr) {
		usr.setId((long)0);
		return service.addUser(usr);
	}
	
	@PutMapping("user")
	public User editUser(@RequestBody User usr){
		return service.editUser(usr);
	}

	
}
