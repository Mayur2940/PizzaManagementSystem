package com.onlinepizza.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepizza.dto.UserDTO;
import com.onlinepizza.entity.User;
import com.onlinepizza.exception.UserManagementException;
import com.onlinepizza.serviceimp.IUserServiceImp;

@RestController
@RequestMapping("/user")
public class IUserController {
	
	@Autowired
	IUserServiceImp iUserServiceImp;
	
	
	@PostMapping("/reguser")
	
	public UserDTO registerUser(@Valid @RequestBody User user) throws UserManagementException{
		return iUserServiceImp.registerUser(user);
		
	}
	
    
	@GetMapping("/signin/{userName}/{password}")
	public UserDTO signIn(@PathVariable ("userName") String userName, @PathVariable ("password")String password) throws UserManagementException {
		return iUserServiceImp.signIn(userName, password);
		
	}
	
	@GetMapping("/signout")
	public  String signOut() {
		return iUserServiceImp.signOut();
		
	}

}
