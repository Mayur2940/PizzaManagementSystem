package com.onlinepizza.service;

import java.util.List;

import com.onlinepizza.dto.CustomerDTO;
import com.onlinepizza.entity.Customer;

public interface ICustomerService {
	Customer registerCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

	Customer viewCustomerByPhone(Long phoneNo);

	List<Customer> viewAllCustomer();
	
	Customer viewCustomerById(Integer customerId);

}
