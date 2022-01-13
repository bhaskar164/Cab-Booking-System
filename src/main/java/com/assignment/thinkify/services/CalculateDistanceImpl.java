package com.assignment.thinkify.services;

import com.assignment.thinkify.models.Location;

public class CalculateDistanceImpl implements CalculateDistance {

	public double distanceFormula(Location source, Location destination) {
		double x1 = source.getxCordinate();
		double y1 = source.getyCordinate();
		double x2 = destination.getxCordinate();
		double y2 = destination.getyCordinate();
		double distance = Math.sqrt( Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
//		System.out.println("Calculated Distance: "+distance);
		return distance;
	}

}
