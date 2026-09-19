package com.seatflow.venue;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seatflow.venue.domain.Seat;


public interface SeatRepository extends JpaRepository<Seat, Long>{
	List<Seat> findByVenueId(Long  venue);
	
	boolean existsByVenueIdAndRowLabelAndSeatNumber(
	        Long venueId,
	        String rowLabel,
	        Integer seatNumber);

}
