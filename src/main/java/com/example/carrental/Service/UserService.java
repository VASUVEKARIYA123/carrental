package com.example.carrental.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.carrental.Entity.User;
import com.example.carrental.Dao.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	public UserService(UserRepository repo) {
		super();
		this.repo = repo;
	}

	public List<User> findAll(){
		return repo.findAll();
	}
	
	public Optional<User> find(int id) {
		
		return repo.findById((long)id);
	}
	
	public Boolean addUser(User usr) {
		if( repo.save(usr) != null )
			return true;
		else
			return false;
	}
	
	public User editUser(User usr) {
		repo.save(usr);
		return usr;
	}
}
