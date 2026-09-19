package com.seatflow.venue.dto;

import com.seatflow.venue.domain.SeatType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateSeatRequest {
	@NotBlank(message="Row lable is required")
	private String rowlable;
	
	@NotNull(message="Seat number is required")
	@Min(value=1 ,message="Seat number must be greater than 0")
	private Integer seatNumber;
	
	@NotNull(message="Seat type is required")
	private SeatType seatType;

	public String getRowlable() {
		return rowlable;
	}

	public void setRowlable(String rowlable) {
		this.rowlable = rowlable;
	}

	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
	
	
	
	
	
	
	
	

}
