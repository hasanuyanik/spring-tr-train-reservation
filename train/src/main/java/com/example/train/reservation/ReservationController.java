package com.example.train.reservation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1.0")
public class ReservationController {

	ReservationResponse reservationResponse;
	
	@PostMapping("/reservation")
	ReservationResponse reservationControl(@Valid @RequestBody Reservation reservation){
		int numberOfPeopleToBookForReservation = reservation.getNumberOfPeopleToBook(); 
		int wagonPiece = reservation.getTrain().getWagon().size();
		ReservationResponse rResponse = new ReservationResponse();	
		List<WagonDetail> layoutDetail = new ArrayList<WagonDetail>();
		for(int piece=0; piece<=wagonPiece; piece++){
			rResponse.setReservationStatus(true);
			String wagonName = reservation.getTrain().getWagon().get(piece).getWagonName();
			int capacity = reservation.getTrain().getWagon().get(piece).getCapacity();
			int fullness = reservation.getTrain().getWagon().get(piece).getFullness();
			int wagonLimit = (capacity/100)*70;
			int emptyArea = wagonLimit-fullness;
			if(fullness > wagonLimit) {	emptyArea = 0; }
			if(emptyArea > 0) {
				if(reservation.isPersonsCanBePlacedOnDifferentWagons()) {
					int reservePeople;
					if(emptyArea < numberOfPeopleToBookForReservation) {
					reservePeople = emptyArea;
					numberOfPeopleToBookForReservation = numberOfPeopleToBookForReservation - emptyArea;
					}else {
					reservePeople = numberOfPeopleToBookForReservation;
					numberOfPeopleToBookForReservation = 0;	
					}
					//layoutDetail.add(piece, new LayoutDetail(new WagonDetail("", 1)));
					layoutDetail.add(piece, new WagonDetail(wagonName, reservePeople));
				}else if(emptyArea > numberOfPeopleToBookForReservation){
					//layoutDetail.add(piece, new LayoutDetail(wagonName, numberOfPeopleToBookForReservation));
				}			
			}
		}
		rResponse.setLayoutDetail(layoutDetail);
		rResponse.getLayoutDetail().size();
		if(numberOfPeopleToBookForReservation > 0) {
			rResponse.setReservationStatus(false);
			rResponse.setLayoutDetail(null);
		}
		return rResponse;
	}
	
	
	
}
