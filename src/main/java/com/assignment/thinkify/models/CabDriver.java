package com.assignment.thinkify.models;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabDriver {
	String driverName;
	int driverId;
	char gender;
	int age;
	boolean availabile;
	Location location;
	Vehicle vehicle;
	ArrayList<Double> dailyEarnings;
}
