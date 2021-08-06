package com.example.train;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.train.shared.GenericResponse;

@RestController
@RequestMapping("/api/1.0")
public class ReservationController {
	
	@PostMapping("/reservation")
	public GenericResponse reservationControl(@Valid @RequestBody Reservation reservation){
		return new GenericResponse("TEST");
	}
	
	
	
}
