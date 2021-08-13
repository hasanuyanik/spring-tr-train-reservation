package com.example.train.reservation;

import com.example.train.Train;

import lombok.Data;

@Data
public class Reservation {
	
	private Train train;
	
	private int numberOfPeopleToBook;
	
	private boolean personsCanBePlacedOnDifferentWagons;
	
}
