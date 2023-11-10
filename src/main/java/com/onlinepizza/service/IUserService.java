package com.onlinepizza.service;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.onlinepizza.dto.UserDTO;
import com.onlinepizza.entity.User;
import com.onlinepizza.exception.UserManagementException;
@EnableJpaRepositories
public interface IUserService {
	UserDTO registerUser(User user) throws UserManagementException;

	UserDTO signIn(String userName, String password) throws UserManagementException;

	
	
	public String signOut();
	
	// use session management accordingly
	
}
