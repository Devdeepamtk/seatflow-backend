package com.seatflow.venue.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.seatflow.venue.domain.Venue;
import com.seatflow.venue.dto.CreateVenueRequest;
import com.seatflow.venue.dto.VenueResponse;
import com.seatflow.venue.repository.VenueRepository;

@Service
public class VenueService {
	private final VenueRepository venueRepository ;
	public VenueService(VenueRepository venueRepository) {
		this.venueRepository=venueRepository;
	}
	public VenueResponse createVenue(CreateVenueRequest venueRequest) {
		Venue venue = new Venue(
		venueRequest.getName(),
		venueRequest.getCity(),
		venueRequest.getAddress());
		Venue savedVenue = venueRepository.save(venue);
		 return new VenueResponse(
			        savedVenue.getId(),
			        savedVenue.getName(),
			        savedVenue.getCity(),
			        savedVenue.getAddress()
			    );
	}
	
	public List<VenueResponse> getAllVenues(){
		
		return venueRepository.findAll().stream().map(p-> 
		new VenueResponse(p.getId(), p.getName(), p.getCity(), p.getAddress())).toList();
	}

}
