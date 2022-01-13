package com.assignment.thinkify.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.assignment.thinkify.constants.Constants;
import com.assignment.thinkify.exceptions.UserNotFound;
import com.assignment.thinkify.models.CabDriver;
import com.assignment.thinkify.models.Location;
import com.assignment.thinkify.services.CalculateDistanceImpl;

public class DriversRepository {
	public ArrayList<CabDriver> cabDrivers;

	public DriversRepository() {
		this.cabDrivers = new ArrayList<>();
	}

	public ArrayList<CabDriver> getCabDrivers() {
		return cabDrivers;
	}

	public void setCabDrivers(ArrayList<CabDriver> cabDrivers) {
		this.cabDrivers = cabDrivers;
	}

	public void addCabDrivers(CabDriver driver) {
		cabDrivers.add(driver);
	}

	public CabDriver findByName(String driverName) throws Exception {
		for (CabDriver driver : cabDrivers) {
			if (driver.getDriverName().equals(driverName)) {
				return driver;
			}
		}
		throw new UserNotFound("Driver not found!!");
	}

	/*
	 * To find list out Nearest Located drivers 
	 */
	public ArrayList<CabDriver> findDriversNearLocation(Location source) {
		ArrayList<CabDriver> availableAndNearestDrivers = new ArrayList<>();
		CalculateDistanceImpl calculateDist = new CalculateDistanceImpl();
		for (CabDriver driver : cabDrivers) {
			if (calculateDist.distanceFormula(source, driver.getLocation()) <= Constants.ALLOWED_DISTANCE
					&& driver.isAvailabile()==true) {
				availableAndNearestDrivers.add(driver);
			}
		}
		return availableAndNearestDrivers;
	}

	public ArrayList<Map<String, Double>> getListOfDriversEarning() {
		ArrayList<Map<String, Double>> list = new ArrayList<>();
		
		for(CabDriver drivers: cabDrivers) {
			ArrayList<Double> allEarning =  drivers.getDailyEarnings();
			double totalEaredMoney = 0.00;
			for(Double money: allEarning) {
				totalEaredMoney += money;
			}
			Map<String, Double> mpMap = new HashMap();
			mpMap.put(drivers.getDriverName(), totalEaredMoney);
			list.add(mpMap);
		}
		
		return list;
	}
}
