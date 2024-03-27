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
@Table(name = "credit_card")
public class CreditCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique =true, nullable = false)
	private Long id;
	
	@Column(name = "card_number", nullable = false)
	private Long cardNumber;
	
	@Column(name = "month", nullable = false)
	private Integer month;
	
	@Column(name = "year", nullable = false)
	private Integer year;
	
	@Column(name = "cvv", nullable = false)
	private Integer cvv;
	
	@Column(name = "account_balance", nullable = false)
	private Long accountBalance;
	
	@OneToOne(mappedBy = "creditCard", cascade = CascadeType.ALL)
	private User user;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public CreditCard(Long id, Long cardNumber, Integer month, Integer year, Integer cvv, Long accountBalance,
			User user) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.month = month;
		this.year = year;
		this.cvv = cvv;
		this.accountBalance = accountBalance;
		this.user = user;
	}
	
	public CreditCard() {
		super();
	}

	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", cardNumber=" + cardNumber + ", month=" + month + ", year=" + year + ", cvv="
				+ cvv + ", accountBalance=" + accountBalance + "]";
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public Long getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
}

