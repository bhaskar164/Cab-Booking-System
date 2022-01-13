package com.assignment.thinkify.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	String userName;
	int userId;
	Location location;
	char gender;
	int age;	

}
