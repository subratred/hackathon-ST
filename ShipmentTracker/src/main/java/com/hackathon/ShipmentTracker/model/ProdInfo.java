package com.hackathon.ShipmentTracker.model;

public class ProdInfo {

	private String area;
	private String latitude;
	private String longitude;
	private String status;
	
	public ProdInfo() {
		super();
	}

	public ProdInfo(String area, String latitude, String longitude, String status) {
		super();
		this.area = area;
		this.latitude = latitude;
		this.longitude = longitude;
		this.status = status;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProdInfo [area=" + area + ", latitude=" + latitude + ", longitude=" + longitude + ", status=" + status
				+ "]";
	}

}
