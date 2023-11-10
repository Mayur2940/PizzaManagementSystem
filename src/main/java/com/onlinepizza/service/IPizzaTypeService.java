package com.onlinepizza.service;

import java.util.List;

import com.onlinepizza.entity.PizzaType;
import com.onlinepizza.exception.PizzaTypeManagementException;

public interface IPizzaTypeService {
	
	String addPizzaType(PizzaType pizzaType) throws PizzaTypeManagementException;
	String deleteById(Integer pizzaTypeId)throws PizzaTypeManagementException;
	List<PizzaType> viewPizzaType();

}
