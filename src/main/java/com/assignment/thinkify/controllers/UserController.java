package com.assignment.thinkify.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.thinkify.models.Location;
import com.assignment.thinkify.models.Trip;
import com.assignment.thinkify.models.User;
import com.assignment.thinkify.services.AppUtilities;
import com.assignment.thinkify.services.CalculateDistanceImpl;
import com.assignment.thinkify.services.UserService;

@RestController
public class UserController {
	public static int userID;
	UserService userService;
	AppUtilities appUtilities;
	Trip currentTrip; 
	
	public UserController(UserService userService, AppUtilities appUtilities) {
		this.userService = userService;
		this.appUtilities = appUtilities;
	}
	
	@PostMapping(value="/user/register")
	public void registerUser(String userName, char gender, int age) {
		System.out.println("Registering new user in the system....");
		userID++;
		userService.add_user(new User(userName,userID,new Location(0,0), gender, age));
	}
	
	@PostMapping(value="/user/updateLocation")
	public void updateUserLocation(String userName, int xCordinate, int yCordinate) {
		System.out.println("Updating Location.....");
		try {
			User foundUser = userService.findUserByName(userName);
			Location updatedLocation = new Location(xCordinate,yCordinate);
			foundUser.setLocation(updatedLocation);
			System.out.println("Location Updated Successflly!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * find A Ride
	 */
	@PostMapping(value="/user/findAride")
	public void findAride(String userName, int x1Cordinate, int y1Cordinate, int x2Cordinate, int y2Cordinate) {
		System.out.println("Finding Available Rides for "+userName);
		Location source = new Location(x1Cordinate,y1Cordinate);
		Location destination = new Location(x2Cordinate, y2Cordinate);
		appUtilities.findRide(userName, source, destination);
		try {
			currentTrip = new Trip(null, userService.findUserByName(userName), source, destination, 0.00, 0.00);
			CalculateDistanceImpl calcDistance = new CalculateDistanceImpl();
			currentTrip.setDistance(calcDistance.distanceFormula(source, destination));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//should initialize class Trip it will store all info related to 
		//current trip
	}
	
	/*
	 * Choose a ride
	 */
	@PostMapping(value = "/user/chooseAride")
	public void chooseAride(String userName, String driverName) {
		System.out.println("Processing selected Ride...");
		appUtilities.chooseRide(userName, driverName, currentTrip);
		System.out.println("Ride Startded "+currentTrip.toString());
		
		
	}
	
	@PostMapping(value = "/user/calculate_bill")
	public void calculateBill(String userName) {
		System.out.println("Calculating Bill");
		double tripCost = appUtilities.calculateBill(userName, currentTrip);
		System.out.println("Ride Ended, Bill Amount:"+tripCost);
	}
	
}
