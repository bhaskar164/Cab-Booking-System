package com.assignment.thinkify.repository;

import java.util.ArrayList;

import com.assignment.thinkify.exceptions.UserNotFound;
import com.assignment.thinkify.models.Location;
import com.assignment.thinkify.models.User;


public class UserRepository {
	public ArrayList<User> usersList;
	

	public UserRepository() {
		this.usersList = new ArrayList<>();
	}

	public ArrayList<User> getUsers() {
		return usersList;
	}
	
	public void addUser(User user) {
		usersList.add(user);
	    System.out.println("User Added Successfully!!");
	}
	
	public void updateUserLocation(String userName, Location location) {
		//
	}

	public User findByName(String userName) throws Exception {
		
			for(User user: usersList) {
				if(user.getUserName().equals(userName)) {
					return user;
				}
			}			
			throw new UserNotFound("User not found");
	}


}
