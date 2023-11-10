package com.onlinepizza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepizza.entity.Customer;
import com.onlinepizza.serviceimp.ICustomerServiceImp;

@RestController
@RequestMapping("/customerservice")
public class ICustomerServiceController {

	@Autowired
	ICustomerServiceImp icustomerserviceimp;
	
	@PostMapping("/regcustomer")
	public Customer registerCustomer(@RequestBody Customer customer) {
		return icustomerserviceimp.registerCustomer(customer);
		
	}
	
	@PutMapping("/updatecustomer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return icustomerserviceimp.updateCustomer(customer);
		
	}
	
	@GetMapping("/viewbyphone/{phoneNo}")
	public Customer viewCustomerByPhone(@PathVariable ("phoneNo") Long phoneNo) {
		return icustomerserviceimp.viewCustomerByPhone(phoneNo);
		
	}
	
	@GetMapping("/viewallcustomer")
	public List<Customer> viewAllCustomer(){
		return icustomerserviceimp.viewAllCustomer();
		
	}
	
	@GetMapping("/viewcbyid/{customerId}")
	public Customer viewCustomerById(@PathVariable ("customerId") Integer customerId) {
		return icustomerserviceimp.viewCustomerById(customerId);
		
	}
	
}
