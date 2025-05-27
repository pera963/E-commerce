package com.e_commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_commerce.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
