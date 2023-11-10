package com.onlinepizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinepizza.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByCustomerMobile(Long phoneNo);
//
	Customer findByuserId(Integer customerId);


//	Customer findByCustomerName(String username); // Check once
}
