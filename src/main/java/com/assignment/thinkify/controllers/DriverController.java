package com.assignment.thinkify.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.thinkify.models.CabDriver;
import com.assignment.thinkify.models.Location;
import com.assignment.thinkify.models.Vehicle;
import com.assignment.thinkify.services.DriverServices;

@RestController
public class DriverController {

	public static int driverId;
	DriverServices driverServices;

	public DriverController(DriverServices driverServices) {
		this.driverServices = driverServices;
	}

	@PostMapping(value = "/driver/register")
	public void registerDriver(String driverName, char gender, int age, String carName, String carNumber,
			int xCordinate, int yCordinate) {
		System.out.println("Registering new driver in to the system.....");
		driverId++;
		Vehicle vehicle = new Vehicle(carName, carNumber);
		Location location = new Location(xCordinate, yCordinate);
		CabDriver driver = new CabDriver(driverName, driverId, gender, age, true, location, vehicle,
				new ArrayList<Double>());
		driverServices.add_driver(driver);
		System.out.println("Driver Successfully Added!!");
	}

	@PostMapping(value = "/driver/updateLocation")
	public void updateDriverLocation(String userName, int xCordinate, int yCordinate) {
		System.out.println("Updating driver's Location.....");
		try {
			CabDriver foundDriver = driverServices.findDriverByName(userName);
			Location updatedLocation = new Location(xCordinate, yCordinate);
			foundDriver.setLocation(updatedLocation);
			System.out.println("Location Updated Successflly!!" + foundDriver.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostMapping(value = "/driver/changeStatus")
	public void changeDriverSatatus(String driverName, boolean status) {
		System.err.println("Changing driver's status to " + status);
		try {
			driverServices.findDriverByName(driverName).setAvailabile(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping(value = "/admin/allDriversEarning")
	public void alDriversEarning() {
		System.out.println("Calculating total Earnings by each driver.....");
		ArrayList<Map<String, Double>> earningDetails = driverServices.getListOfAllDriversEarning();
		for (Map<String, Double> map : earningDetails) {
			System.out.println(map.toString());
		}
	}

}
