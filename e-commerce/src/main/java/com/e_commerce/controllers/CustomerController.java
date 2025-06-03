package com.e_commerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_commerce.DTOS.CustomerDTO;
import com.e_commerce.models.Customer;
import com.e_commerce.services.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/register")
	public ResponseEntity<Customer> customerRegistration(@RequestBody CustomerDTO customerdto){
	    Customer customer = customerService.registration(customerdto);
	    if(customer == null){
	        return ResponseEntity.badRequest().build();
	   }
	   return ResponseEntity.ok(customer);
	}
}
