package com.assignment.thinkify.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
 public CabDriver currentDriver;
 public User currentRider;
 Location source;
 Location destination;
 double distance;
 double tripBill;
}
