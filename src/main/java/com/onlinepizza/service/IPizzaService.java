package com.onlinepizza.service;

import java.util.List;

import com.onlinepizza.dto.PizzaDTO;
import com.onlinepizza.dto.PizzaTypeDTO;
import com.onlinepizza.dto.ToppingsDTO;
import com.onlinepizza.entity.Pizza;
import com.onlinepizza.entity.PizzaType;
import com.onlinepizza.entity.Toppings;

public interface IPizzaService { // all methods implemented
	Pizza addPizza(Pizza pizza);  //done

	Toppings addToppings(Toppings toppings);

	PizzaType addPizzaType(PizzaType pizzaType);

	Pizza updatePizza(Pizza pizza); // done

	Pizza viewPizzaById(Integer pizzaId); //done

	List<Pizza> viewPizzaByPizzaType(String pizzaType); //

	List<Pizza> viewPizzaByPizzaSize(String pizzaSize); //

	List<Pizza> viewPizzaByPrice(Double minPrice, Double maxPrice); //

	List<Pizza> viewAllPizza(); //done

	List<Toppings> viewToppings();

	Toppings viewToppingByID(Integer toppingsID);

	PizzaType viewPizzaTypeById(Integer pizzaTypeId);

	List<PizzaType> viewAllPizzaTypes();
}
