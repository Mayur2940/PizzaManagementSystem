package com.onlinepizza.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepizza.entity.Toppings;
import com.onlinepizza.exception.PizzaToppingsManagementException;
import com.onlinepizza.repository.ToppingsRepository;
import com.onlinepizza.service.IToppingsService;

@Service
public class IToppingsServiceImp implements IToppingsService {

	@Autowired
	ToppingsRepository toppingsRepository;


	public String addToppings(Toppings topping) throws PizzaToppingsManagementException {
		Toppings savedTopping = toppingsRepository.save(topping);
		if (savedTopping == null || savedTopping.getToppingsId() == null)
		{
			throw new PizzaToppingsManagementException("Invalid Toppings: Toppings not saved properly");
		} else 
		
			return "Toppings added";
		
	}

	@Override
	public String deleteToppingsById(Integer toppingsId) throws PizzaToppingsManagementException {
		if (toppingsRepository.findById(toppingsId).isEmpty()) {
			throw new PizzaToppingsManagementException("Toppings not found");
		} else

			toppingsRepository.deleteById(toppingsId);
		return "Toppings Removed Successfully";
	}

}
