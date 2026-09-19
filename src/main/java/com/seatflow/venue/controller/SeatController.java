package com.seatflow.venue.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.seatflow.venue.dto.CreateSeatRequest;
import com.seatflow.venue.dto.SeatResponse;
import com.seatflow.venue.service.SeatService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/venues/{venueId}/seats")
public class SeatController {
	private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }
    
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public SeatResponse createSeat(@PathVariable Long venueId,@Valid @RequestBody CreateSeatRequest  request) {
		  return seatService.createSeat(venueId, request);
	}

	
	 @GetMapping
	    public List<SeatResponse> getSeats(
	            @PathVariable Long venueId) {

	        return seatService.getSeatsByVenue(venueId);
	    }
}
