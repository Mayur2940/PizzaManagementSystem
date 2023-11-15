package com.onlinepizza.serviceimp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepizza.entity.Pizza;
import com.onlinepizza.entity.PizzaType;
import com.onlinepizza.entity.Toppings;
import com.onlinepizza.exception.PizzaServiceManagementException;
import com.onlinepizza.repository.PizzaRepository;

import com.onlinepizza.exception.PizzaServiceManagementException;import com.onlinepizza.repository.PizzaTypeRepository;
import com.onlinepizza.repository.ToppingsRepository;
import com.onlinepizza.service.IPizzaService;

@Service
public class IPizzaServiceImp implements IPizzaService { // all methods implemented

	@Autowired
	PizzaRepository pizzaRepository;

	@Autowired
	ToppingsRepository toppingsRepository;

	@Autowired
	PizzaTypeRepository pizzaTypeRepository;

	
	public Pizza addPizza(Pizza pizza) {
		
		pizzaRepository.save(pizza);
		return pizza;

	}


	public Toppings addToppings(Toppings toppings) {
		
		
		return toppingsRepository.save(toppings);

	}

	public PizzaType addPizzaType(PizzaType pizzaType) {

		PizzaType newPizzaType = new PizzaType();

		newPizzaType.setPizzaType(pizzaType.getPizzaType());
//		newPizzaType.setToppings(pizzaType.getToppings());

		pizzaTypeRepository.save(newPizzaType);

		return newPizzaType;

	}

	
	public Pizza updatePizza(Pizza pizza) {

//		Pizza updatePizza = new Pizza();
//		updatePizza.setPizzaCost(pizza.getPizzaCost());
//		updatePizza.setPizzaDescription(pizza.getPizzaDescription());
//		updatePizza.setPizzaId(pizza.getPizzaId());
//		updatePizza.setPizzaSize(pizza.getPizzaSize());
//		updatePizza.setPizzaName(pizza.getPizzaName());
//		//updatePizza.setPizzaType(pizza.getPizzaType());
		

		return pizzaRepository.save(pizza);
	}

	
	public Pizza viewPizzaById(Integer pizzaId) throws PizzaServiceManagementException{
		if(pizzaRepository.existsById(pizzaId)==false) {
			throw new PizzaServiceManagementException("Pizza not Available");
		}else
		return pizzaRepository.findById(pizzaId).get();
	}
	

	
	public List<Pizza> viewPizzaByPizzaType(String pizzaType) throws PizzaServiceManagementException {
		List<Pizza> pizzaByType =pizzaRepository.findAll().stream().filter(e -> e.getPizzaType().getPizzaType().equals(pizzaType)).collect(Collectors.toList());
		if(!pizzaByType.isEmpty()) {
			return pizzaByType;
		}
		else {
			throw new PizzaServiceManagementException("Pizza type doesnot exist");
		}
	}
	

	
	public List<Pizza> viewPizzaByPizzaSize(String pizzaSize) {
		return pizzaRepository.findAll().stream().filter(e -> e.getPizzaSize().toString().equals(pizzaSize))
				.collect(Collectors.toList());
	}

	
	public List<Pizza> viewPizzaByPrice(Double minPrice, Double maxPrice) {
		return pizzaRepository.findAll().stream()
				.filter(e -> e.getPizzaCost() >= minPrice || e.getPizzaCost() <= maxPrice).collect(Collectors.toList());
	}

	
	public List<Pizza> viewAllPizza() {
		return pizzaRepository.findAll();
	}

	
	public List<Toppings> viewToppings() {

		return toppingsRepository.findAll();
	}

	
	public Toppings viewToppingByID(Integer toppingsID) throws PizzaServiceManagementException{

		 if(toppingsRepository.existsById(toppingsID)==false) {
				throw new PizzaServiceManagementException("Invalid id");
			}
			else {
			return toppingsRepository.findById(toppingsID).get();
			}
		
	}

	
	public PizzaType viewPizzaTypeById(Integer pizzaTypeId) {

		return pizzaTypeRepository.findById(pizzaTypeId).get();
	}

	
	public List<PizzaType> viewAllPizzaTypes() {

		return pizzaTypeRepository.findAll();
	}

}
