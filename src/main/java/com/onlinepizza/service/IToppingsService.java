package com.onlinepizza.service;

import com.onlinepizza.entity.Toppings;


public interface IToppingsService {
	String addToppings(Toppings topping);
	String deleteToppingsById(Integer toppingsId);

}
