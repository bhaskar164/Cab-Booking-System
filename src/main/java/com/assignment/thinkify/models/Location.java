package com.assignment.thinkify.models;

public class Location {
	double xCordinate;
	double yCordinate;
	
	public Location() {
		this.xCordinate = 0;
		this.yCordinate = 0;
	}
	
	public Location(int xCordinate, int yCordinate) {
		super();
		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate;
	}
	public double getxCordinate() {
		return xCordinate;
	}
	public void setxCordinate(int xCordinate) {
		this.xCordinate = xCordinate;
	}
	public double getyCordinate() {
		return yCordinate;
	}
	public void setyCordinate(int yCordinate) {
		this.yCordinate = yCordinate;
	}
	
	@Override
	public String toString() {
		return "Location [xCordinate=" + xCordinate + ", yCordinate=" + yCordinate + "]";
	}
}
