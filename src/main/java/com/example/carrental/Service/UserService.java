package com.example.carrental.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.carrental.Entity.User;
import com.example.carrental.Dao.CreditCardRepository;
import com.example.carrental.Dao.UserRepository;

@Service
public class UserService {
	
	private UserRepository repo;
	private CreditCardRepository cardRepo;
	
	@Autowired
	public UserService(@Qualifier("userRepository")UserRepository theRepo,@Qualifier("creditCardRepository")CreditCardRepository theCardRepo) {
		super();
		repo = theRepo;
		cardRepo = theCardRepo;
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
