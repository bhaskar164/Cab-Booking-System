package com.assignment.thinkify.services;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import com.assignment.thinkify.models.User;
import com.assignment.thinkify.repository.UserRepository;

//Repo/database access

public class UserService {

	UserRepository userRepository;
	
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	public void add_user(User user) {
		userRepository.addUser(user);
	}


	public User findUserByName(String userName) throws Exception {
		return userRepository.findByName(userName);
		
	}
}
