package com.seatflow.venue.dto;

import com.seatflow.venue.domain.SeatType;

public class SeatResponse {

	 private Long id;
	    private String rowLabel;
	    private Integer seatNumber;
	    private SeatType seatType;
	    private Long venueId;
	    
	    
	    public SeatResponse(Long id,String rowLable,Integer seatNumber,SeatType seatType,Long venueId) {
	    	this.id=id;
	    	this .rowLabel=rowLable;
	    	this.seatNumber=seatNumber;
	    	this.seatType=seatType;
	    	this.venueId=venueId;
			// TODO Auto-generated constructor stub
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getRowLabel() {
			return rowLabel;
		}
		public void setRowLabel(String rowLabel) {
			this.rowLabel = rowLabel;
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
		public Long getVenueId() {
			return venueId;
		}
		public void setVenueId(Long venueId) {
			this.venueId = venueId;
		}
	    
	    
	    
}
