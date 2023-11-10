package com.onlinepizza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepizza.entity.PizzaType;
import com.onlinepizza.exception.PizzaTypeManagementException;
import com.onlinepizza.serviceimp.IPizzaTypeServiceImp;

@RestController
@RequestMapping("/pizzatype")
public class IPizzaTypeController {
	
	@Autowired
	IPizzaTypeServiceImp iPizzaTypeServiceImp;
	
	@PostMapping("/addpizzatype")
	public String addPizzaType(@RequestBody PizzaType pizzaType) throws PizzaTypeManagementException{
		return iPizzaTypeServiceImp.addPizzaType(pizzaType);
		
	}
	
	@DeleteMapping("/ptypedelete/{ptypeid}")
	public String deleteById(@PathVariable ("ptypeid") Integer pizzaTypeId) throws PizzaTypeManagementException{
		return iPizzaTypeServiceImp.deleteById(pizzaTypeId);
		
	}
	
	@GetMapping("/viewptypelist")
	public List<PizzaType> viewPizzaType(){
		return iPizzaTypeServiceImp.viewPizzaType();
		
	}

}
