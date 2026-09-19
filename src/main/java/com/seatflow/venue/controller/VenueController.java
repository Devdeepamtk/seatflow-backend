package com.seatflow.venue.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.seatflow.venue.domain.Venue;
import com.seatflow.venue.dto.CreateVenueRequest;
import com.seatflow.venue.dto.VenueResponse;
import com.seatflow.venue.service.VenueService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/venues")
public class VenueController {
	private final VenueService venueService;
	
	public VenueController(  VenueService venueService) {
		this.venueService=venueService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public VenueResponse createVenue(@Valid @RequestBody CreateVenueRequest venue) {
		return venueService.createVenue(venue);
	}
	
	@GetMapping
	public List<VenueResponse> getAllVenues(){
		return venueService.getAllVenues();
	}

}
