package com.example.train;

import java.util.List;

import lombok.Data;

@Data
public class Reservation {
	
	private Train train;
	
	private int numberOfPeopleToBook;
	
	private boolean personsCanBePlacedOnDifferentWagons;
	
}
