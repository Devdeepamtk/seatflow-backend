package com.seatflow.venue.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "seats", uniqueConstraints = {
		@UniqueConstraint(name = "uk_venue_row_seat", columnNames = { "venue_id", "row_lable", "seat_number" }) })
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "row_lable", nullable = false)
	private String rowLabel;
	
	@Column(name = "seat_number", nullable = false)
	private Integer seatNumber;

	@Enumerated(EnumType.STRING)
	@Column(name = "seat_Type", nullable = false)
	private SeatType type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "venue_id", nullable = false)
	private Venue venue;

	public Seat() {

	}

	public Seat(String rowLable, Integer seatNumber, SeatType type, Venue venue) {
		this.rowLabel = rowLable;
		this.seatNumber = seatNumber;
		this.type = type;
		this.venue = venue;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRowLable() {
		return rowLabel;
	}

	public void setRowLable(String rowLable) {
		this.rowLabel = rowLable;
	}

	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	public SeatType getType() {
		return type;
	}

	public void setType(SeatType type) {
		this.type = type;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

}
