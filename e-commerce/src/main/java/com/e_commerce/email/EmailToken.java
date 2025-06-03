package com.e_commerce.email;

import java.time.LocalDateTime;

import com.e_commerce.models.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class EmailToken {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String token;
	private LocalDateTime creationDate;
	private LocalDateTime expirationDate;
	private LocalDateTime confirmationDate;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private User user;
	public EmailToken() {
		super();
	}

	public EmailToken(int id, String token, LocalDateTime creationDate, LocalDateTime expirationDate,
			LocalDateTime confirmationDate, User user) {
		super();
		this.id = id;
		this.token = token;
		this.creationDate = creationDate;
		this.expirationDate = expirationDate;
		this.confirmationDate = confirmationDate;
		this.user = user;
	}

	public EmailToken(String token, LocalDateTime creationDate, LocalDateTime expirationDate,
			 User user) {
		super();
		this.token = token;
		this.creationDate = creationDate;
		this.expirationDate = expirationDate;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	public LocalDateTime getConfirmationDate() {
		return confirmationDate;
	}

	public void setConfirmationDate(LocalDateTime confirmationDate) {
		this.confirmationDate = confirmationDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
}
