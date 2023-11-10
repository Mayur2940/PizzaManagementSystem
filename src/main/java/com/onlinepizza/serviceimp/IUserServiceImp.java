package com.onlinepizza.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepizza.dto.UserDTO;
import com.onlinepizza.entity.User;
import com.onlinepizza.exception.UserManagementException;
import com.onlinepizza.repository.UserRepository;
import com.onlinepizza.service.IUserService;

@Service
public class IUserServiceImp implements IUserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDTO registerUser(User user) throws UserManagementException{
		if(userRepository.save(user)==null) {
			throw new UserManagementException("Invalid User");
		}
		else {
			
		
		UserDTO object= new UserDTO();
		object.setUserId(user.getUserId());
		object.setUserName(user.getUserName());
		object.setUserRole(user.getUserRole());
		userRepository.save(user);
		
		return object;
	}
	}
	
	

	@Override
	public UserDTO signIn(String userName, String password)  throws UserManagementException{
		if(userRepository.findByUserName(userName)==null) {
			throw new UserManagementException("Invalid User"); 	
		}
		User user=userRepository.findByUserName(userName);
		
		if(!user.getPassword().equals(password)) {
			throw new UserManagementException("Invalid Password");
		}
		else {
		UserDTO userDto= new UserDTO();
		
		if((user.getPassword().equals(password))) {
			userDto.setUserId(user.getUserId());
			userDto.setUserName(user.getUserName());
			userDto.setUserRole(user.getUserRole());
			
			return userDto;
		}
		return null;
		
		}

	}	
	

	@Override
	public String signOut() {
		
		return "Signed out succesully";
	}

	
	

}
