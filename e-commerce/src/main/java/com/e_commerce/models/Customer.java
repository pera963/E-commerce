package com.e_commerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class Customer extends User {
	private int loyaltyPoints;
	private String bankAccount;
	
	

	public Customer() {
		super();
	}

	public Customer(int loyaltyPoints, String bankAccount) {
		super();
		this.loyaltyPoints = loyaltyPoints;
		this.bankAccount = bankAccount;
	}

	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
    
}
