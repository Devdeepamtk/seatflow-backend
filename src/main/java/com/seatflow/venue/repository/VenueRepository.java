package com.seatflow.venue.repository;

import com.seatflow.venue.domain.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  VenueRepository extends JpaRepository<Venue, Long> {

}
