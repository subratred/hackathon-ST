package com.hackathon.ShipmentTracker.model;


@EntityScan
public class PrdoDetails {

	private Long id;
	private String location;
	private String remarks;
	public PrdoDetails() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "PrdoDetails [id=" + id + ", location=" + location + ", remarks=" + remarks + "]";
	}
}
