package com.seatflow.venue.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.seatflow.common.exception.DuplicateResourceException;
import com.seatflow.common.exception.ResourceNotFoundException;
import com.seatflow.venue.SeatRepository;
import com.seatflow.venue.domain.Seat;
import com.seatflow.venue.domain.Venue;
import com.seatflow.venue.dto.CreateSeatRequest;
import com.seatflow.venue.dto.SeatResponse;
import com.seatflow.venue.repository.VenueRepository;

@Service
public class SeatService {
	private final SeatRepository seatRepository;
	private final VenueRepository venueRepository;
	
	public SeatService( SeatRepository seatRepository,
            VenueRepository venueRepository) {
		this.seatRepository=seatRepository;
		this.venueRepository=venueRepository;
		// TODO Auto-generated constructor stub
	}

	
	public SeatResponse createSeat(Long venueId,CreateSeatRequest request) {
		 Venue venue =venueRepository.findById(venueId).orElseThrow(() ->
        new ResourceNotFoundException(
                "Venue not found with id: " + venueId));
		 
		 boolean alreadyExists =
		            seatRepository.existsByVenueIdAndRowLabelAndSeatNumber(
		                    venueId,
		                    request.getRowlable(),
		                    request.getSeatNumber());

		    if (alreadyExists) {
		        throw new DuplicateResourceException(
		                "Seat " +
		                request.getRowlable() +
		                request.getSeatNumber() +
		                " already exists in this venue");
		    }

		 
		 Seat seat= new Seat( request.getRowlable(),
	                request.getSeatNumber(),
	                request.getSeatType(),
	                venue);
		 Seat savedSeat= seatRepository.save(seat);
		 return toResponse(savedSeat);
		
	}
	public List<SeatResponse> getSeatsByVenue(Long venueId){
		if(!venueRepository.existsById(venueId))
			throw new ResourceNotFoundException(
                    "Venue not found with id: " + venueId);
		
		return seatRepository.findByVenueId(venueId).stream().map(this::toResponse).toList();
	}
	
	 private SeatResponse toResponse(Seat seat) {

	        return new SeatResponse(
	                seat.getId(),
	                seat.getRowLable(),
	                seat.getSeatNumber(),
	                seat.getType(),
	                seat.getVenue().getId());
	 }
}
