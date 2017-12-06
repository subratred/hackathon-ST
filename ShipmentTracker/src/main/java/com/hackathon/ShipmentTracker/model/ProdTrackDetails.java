package com.hackathon.ShipmentTracker.model;

import java.util.List;

public class ProdTrackDetails {

	private Long orderNUmber;
	private String lastUpdated;
	private ProdInfo source;
	private List<ProdInfo> intermediateLocations;
	private ProdInfo destination;
	private int zoom;
	public ProdTrackDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProdTrackDetails(Long orderNUmber, String lastUpdated, ProdInfo source, List<ProdInfo> intermediateLocations,
			ProdInfo destination, int zoom) {
		super();
		this.orderNUmber = orderNUmber;
		this.lastUpdated = lastUpdated;
		this.source = source;
		this.intermediateLocations = intermediateLocations;
		this.destination = destination;
		this.zoom = zoom;
	}
	public Long getOrderNUmber() {
		return orderNUmber;
	}
	public void setOrderNUmber(Long orderNUmber) {
		this.orderNUmber = orderNUmber;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public ProdInfo getSource() {
		return source;
	}
	public void setSource(ProdInfo source) {
		this.source = source;
	}
	public List<ProdInfo> getIntermediateLocations() {
		return intermediateLocations;
	}
	public void setIntermediateLocations(List<ProdInfo> intermediateLocations) {
		this.intermediateLocations = intermediateLocations;
	}
	public ProdInfo getDestination() {
		return destination;
	}
	public void setDestination(ProdInfo destination) {
		this.destination = destination;
	}
	public int getZoom() {
		return zoom;
	}
	public void setZoom(int zoom) {
		this.zoom = zoom;
	}
	@Override
	public String toString() {
		return "ProdTrackDetails [orderNUmber=" + orderNUmber + ", lastUpdated=" + lastUpdated + ", source=" + source
				+ ", intermediateLocations=" + intermediateLocations + ", destination=" + destination + ", zoom=" + zoom
				+ "]";
	}
	
}
