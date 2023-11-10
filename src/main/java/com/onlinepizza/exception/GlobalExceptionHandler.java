package com.onlinepizza.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value=UserManagementException.class)
	public ResponseEntity<String> handleUserManagementException(UserManagementException userManagementException){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userManagementException.getMessage());		
	}
	
	@ExceptionHandler(value=PizzaCustomerManagementException.class)
	public ResponseEntity<String> handlePassengerManagementException(PizzaCustomerManagementException pizzaCustomerManagementException){
		return new ResponseEntity<>(pizzaCustomerManagementException.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = PizzaOrderManagementException.class)
	public ResponseEntity<String> handlePassengerManagementException(PizzaOrderManagementException pizzaOrderManagementException)
	{
		return new ResponseEntity<>(pizzaOrderManagementException.getMessage(),HttpStatus.NOT_FOUND);
	}
}