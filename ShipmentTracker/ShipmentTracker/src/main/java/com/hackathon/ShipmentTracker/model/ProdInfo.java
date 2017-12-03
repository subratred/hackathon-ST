package com.hackathon.ShipmentTracker.model;

public class ProdInfo {

	private String source;
	private String destination;
	private String currentLocation;
	private String currentStatus;
	
	public ProdInfo() {
		super();
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	@Override
	public String toString() {
		return "ProdInfo [source=" + source + ", destination=" + destination + ", currentLocation=" + currentLocation
				+ ", currentStatus=" + currentStatus + "]";
	}
}
