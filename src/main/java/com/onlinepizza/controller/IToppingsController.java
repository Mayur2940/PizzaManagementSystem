package com.onlinepizza.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepizza.entity.Toppings;
import com.onlinepizza.exception.PizzaToppingsManagementException;
import com.onlinepizza.serviceimp.IToppingsServiceImp;

@RestController
@RequestMapping("/toppings")
public class IToppingsController {
	
	@Autowired
	IToppingsServiceImp iToppingsServiceImp;
	
	@PostMapping("/add")
	public String addToppings(@Valid @RequestBody Toppings topping) throws PizzaToppingsManagementException {
		return iToppingsServiceImp.addToppings(topping);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteToppingsById(@PathVariable ("id") Integer toppingsId) throws PizzaToppingsManagementException {
		return iToppingsServiceImp.deleteToppingsById(toppingsId);
 
	}

}
