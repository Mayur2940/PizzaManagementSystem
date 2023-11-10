package com.onlinepizza.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepizza.dto.UserDTO;
import com.onlinepizza.entity.User;
import com.onlinepizza.repository.UserRepository;
import com.onlinepizza.service.IUserService;

@Service
public class IUserServiceImp implements IUserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDTO registerUser(User user) {
		UserDTO object= new UserDTO();
		object.setUserId(user.getUserId());
		object.setUserName(user.getUserName());
		object.setUserRole(user.getUserRole());
		userRepository.save(user);
		
		return object;
	}
	
	

	@Override
	public UserDTO signIn(String userName, String password) {
		User user=userRepository.findByUserName(userName);
		UserDTO userDto= new UserDTO();
		if((user.getPassword().equals(password))) {
			userDto.setUserId(user.getUserId());
			userDto.setUserName(user.getUserName());
			userDto.setUserRole(user.getUserRole());
			
			return userDto;
		}
		return null;
	}
	
	

	@Override
	public String signOut() {
		
		return "Signed out succesully";
	}

	
	

}
