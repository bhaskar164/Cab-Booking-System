package com.assignment.thinkify.services;

import java.util.ArrayList;

import com.assignment.thinkify.models.CabDriver;
import com.assignment.thinkify.models.Location;
import com.assignment.thinkify.models.Trip;
import com.assignment.thinkify.repository.DriversRepository;
import com.assignment.thinkify.repository.UserRepository;

public class AppUtilities {

	UserRepository userRepository;
	DriversRepository driversRepository;

	public AppUtilities(UserRepository userRepository, DriversRepository driversRepository) {
		this.userRepository = userRepository;
		this.driversRepository = driversRepository;
	}

	public void findRide(String userName, Location source, Location destination) {
		ArrayList<CabDriver> availableDrivers =  driversRepository.findDriversNearLocation(source);
		if(availableDrivers.size()>0) {
			for(CabDriver driver: availableDrivers) {
				if(driver.isAvailabile()) {
					System.out.println(driver.getDriverName()+"[Available]");
				}else {
					System.out.println(driver.getDriverName()+"[Not Available]");
				}
			}
		}else {
			System.out.println("Sorry No Ride Found!!");
		}
		
		
	}

	public void chooseRide(String userName, String driverName, Trip currentTrip) {
		CabDriver currentDriver;
		try {
			currentDriver = driversRepository.findByName(driverName);
			if(currentDriver.isAvailabile()) {
				currentDriver.setAvailabile(false);
				currentTrip.setCurrentDriver(currentDriver);
			}else {
				System.out.println("Trip cannot start as" + currentDriver+" set to not available");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public double calculateBill(String userName, Trip currentTrip) {
		CalculateBill newBill = new CalculateBillImpl();
		double bill = newBill.billingCalcFormula(currentTrip);
		//update Location of current User
		currentTrip.getCurrentRider().setLocation(currentTrip.getDestination());
		currentTrip.getCurrentDriver().setLocation(currentTrip.getDestination());
		
		//updating earnings wallet of driver
		currentTrip.getCurrentDriver().getDailyEarnings().add(bill);
		return bill;
	}

//	public void calculateBill(String userName) {}
}
