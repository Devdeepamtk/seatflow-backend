 package com.seatflow.venue.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateVenueRequest {
	@NotBlank(message="Venue name is required")
    @Size( max=100, message="Venue name cannot exceed 100 charachter")
    private String name;
	@NotBlank(message="Venue city is required")
    private String city;
	@NotBlank(message="Venue address is required")
    private String address;

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
