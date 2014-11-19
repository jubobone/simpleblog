package com.twpnn.demo.simpleblog.model;

public final class AvailabilityStatus {

	private boolean available;
	private String status;
	
	public AvailabilityStatus(String status, boolean available) {
		this.status = status;
		this.available = available;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public String getStatus() {
		return status;
	}

	
}
