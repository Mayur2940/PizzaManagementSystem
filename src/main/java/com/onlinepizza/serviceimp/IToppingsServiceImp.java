package com.onlinepizza.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepizza.entity.Toppings;
import com.onlinepizza.repository.ToppingsRepository;
import com.onlinepizza.service.IToppingsService;

@Service
public class IToppingsServiceImp implements IToppingsService{

	@Autowired
	ToppingsRepository toppingsRepository;
	@Override
	public String addToppings(Toppings topping) {
		
		toppingsRepository.save(topping);
		return "Toppings added";
	}
	@Override
	public String deleteToppingsById(Integer toppingsId) {
		toppingsRepository.deleteById(toppingsId);
		return "Toppings Removed Successfully";
	}

	

	

}
