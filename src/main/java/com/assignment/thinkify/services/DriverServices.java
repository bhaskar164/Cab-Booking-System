package com.assignment.thinkify.services;

import java.util.ArrayList;
import java.util.Map;

import com.assignment.thinkify.models.CabDriver;
import com.assignment.thinkify.repository.DriversRepository;

public class DriverServices {

	DriversRepository driversRepository;

	public DriverServices(DriversRepository driversRepository) {
		this.driversRepository = driversRepository;
	}

	public void add_driver(CabDriver driver) {
		driversRepository.addCabDrivers(driver);
	}

	public CabDriver findDriverByName(String userName) throws Exception {
		return driversRepository.findByName(userName);
	}

	public ArrayList<Map<String, Double>> getListOfAllDriversEarning() {
		return driversRepository.getListOfDriversEarning();
	}

}
