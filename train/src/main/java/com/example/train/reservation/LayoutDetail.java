package com.example.train.reservation;

import java.util.List;

import lombok.Data;

@Data
public class LayoutDetail {
	
	private WagonDetail wagonDetail;

	public LayoutDetail(WagonDetail wagonDetail) {
		this.wagonDetail = wagonDetail;
	}
	
	
}
