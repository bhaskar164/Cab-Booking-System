package com.assignment.thinkify.services;

import com.assignment.thinkify.constants.Constants;
import com.assignment.thinkify.models.Trip;

public class CalculateBillImpl implements CalculateBill {

	@Override
	public double billingCalcFormula(Trip trip) {
		
		return Math.ceil(trip.getDistance() * Constants.PER_UNIT_DISTANCE_COST);
	}

}
