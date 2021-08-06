package com.example.train;


import java.util.List;

import lombok.Data;

@Data
public class Train {
	
	private String trainName;
	
	private List<Wagon> wagon;
	
}
