package com.onlinepizza.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepizza.entity.PizzaType;
import com.onlinepizza.exception.PizzaTypeManagementException;
import com.onlinepizza.repository.PizzaTypeRepository;
import com.onlinepizza.service.IPizzaTypeService;

@Service
public class IPizzaTypeServiceImp implements IPizzaTypeService {

	@Autowired
	PizzaTypeRepository pizzaTypeRepository;

	@Override
	public String addPizzaType(PizzaType pizzaType)  throws PizzaTypeManagementException  {
		// Check if the pizza type can'y be empty, and if it does, throw an exception.
		if (pizzaType.equals(null)) {
			throw new PizzaTypeManagementException("PizzaType cannot be null.");
		} else

		{
			pizzaTypeRepository.save(pizzaType);
			return "Added PizzaType successfully";
		}

	}

	@Override
	public String deleteById(Integer pizzaTypeId) throws PizzaTypeManagementException
	{ 
		if(pizzaTypeRepository.findById(pizzaTypeId).isEmpty())
		{
			throw new PizzaTypeManagementException("PizzaType does not exist");
		}
		else
			
			pizzaTypeRepository.deleteById(pizzaTypeId);
			return "PizzaType Removed";
		
	}

	@Override
	public List<PizzaType> viewPizzaType() {

		return pizzaTypeRepository.findAll();
	}

}
