package com.example.train;

import java.util.List;

import lombok.Data;

@Data
public class ReservationResponse {

	private boolean reservationStatus;
	
	private List<LayoutDetail> layoutDetail;
	
}
