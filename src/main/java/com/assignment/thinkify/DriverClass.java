package com.assignment.thinkify;

import com.assignment.thinkify.controllers.DriverController;
import com.assignment.thinkify.controllers.UserController;
import com.assignment.thinkify.repository.DriversRepository;
import com.assignment.thinkify.repository.UserRepository;
import com.assignment.thinkify.services.AppUtilities;
import com.assignment.thinkify.services.DriverServices;
import com.assignment.thinkify.services.UserService;

public class DriverClass {

	public static void main(String[] args) {
		System.out.println("Running Main Class...\n\n\n");
		UserRepository userRepository = new UserRepository();
		UserService userService = new UserService(userRepository);
		DriversRepository driversRepository = new DriversRepository();
		DriverServices driverServices = new DriverServices(driversRepository);
		AppUtilities appUtilities = new AppUtilities(userRepository, driversRepository);
		UserController userController = new UserController(userService, appUtilities);
		DriverController driverController = new DriverController(driverServices);

		userController.registerUser("Abhishek", 'M', 22);
		userController.updateUserLocation("Abhishek", 0, 0);
		userController.registerUser("Rahul", 'M', 29);
		userController.updateUserLocation("Rahul", 10, 0);
		userController.registerUser("Nandini", 'F', 22);
		userController.updateUserLocation("Nandini", 15, 6);

		driverController.registerDriver("Driver1", 'M', 22, "Swift", "KA-01-12345", 10, 1);
		driverController.registerDriver("Driver2", 'M', 29, "Swift", "KA-01-12345", 11, 10);
		driverController.registerDriver("Driver3", 'M', 24, "Swift", "KA-01-12345", 5, 3);

		userController.findAride("Abhishek", 0, 0, 20, 1);

		userController.findAride("Rahul", 10, 0, 15, 3);
		userController.chooseAride("Rahul", "Driver1");
		userController.calculateBill("Rahul");
		driverController.changeDriverSatatus("Driver1", false);

		userController.findAride("Nandini", 15, 6, 20, 4);

		driverController.alDriversEarning();
	}

}
