package com.example.carrental.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.carrental.Dao.CreditCardRepository;
import com.example.carrental.Entity.CreditCard;



@Service
public class CreditCardService {

	private CreditCardRepository repo;
	
	@Autowired
	public CreditCardService(@Qualifier("creditCardRepositoy")CreditCardRepository theRepo) {
		super();
		repo = theRepo;
	}
	
	public Optional<CreditCard> getCreditCard(Long id) {
		return repo.findById(id);
	}
	
	
}
