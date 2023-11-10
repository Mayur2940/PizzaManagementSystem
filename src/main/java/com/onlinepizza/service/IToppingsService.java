package com.onlinepizza.service;

import com.onlinepizza.entity.Toppings;
import com.onlinepizza.exception.PizzaToppingsManagementException;


public interface IToppingsService {
	String addToppings(Toppings topping);
	String deleteToppingsById(Integer toppingsId) throws PizzaToppingsManagementException;

}
