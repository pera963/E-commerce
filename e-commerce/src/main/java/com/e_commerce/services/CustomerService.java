package com.e_commerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.e_commerce.DTOS.CustomerDTO;
import com.e_commerce.enums.Role;
import com.e_commerce.models.Customer;
import com.e_commerce.repositories.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Customer registration(CustomerDTO customerDto) {
	  Customer customer=new Customer();
	  customer.setFirstName(customerDto.getFirstName());
	  customer.setLastName(customerDto.getLastName());
	  customer.setEmail(customerDto.getEmail());
	  customer.setPhone(customerDto.getPhone());
	  customer.setPassword(passwordEncoder.encode(customerDto.getPassword()));
	  customer.setCountry(customerDto.getCountry());
	  customer.setCity(customerDto.getCity());
	  customer.setAddress(customerDto.getAddress());
	  customer.setDateOfBirth(customerDto.getDateOfBirth());
	  customer.setBankAccount(customerDto.getBankAccount());
	  customer.setLoyaltyPoints(0);
	  customer.setRole(Role.CUSTOMER);
	  return customerRepository.save(customer); 
	}
	
}
