package com.example.train.reservation;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ReservationResponse {

	private boolean reservationStatus;
	
	private List<WagonDetail> layoutDetail;

	public ReservationResponse() {
		this.setReservationStatus(false);
		this.layoutDetail = new ArrayList<>();
	}
	
}
