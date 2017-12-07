package com.hackathon.ShipmentTracker.model;

public class ProdInfo {

	private Integer key;
	private String area;
	private int latitude;
	private int longitude;
	private String status;
	
	public ProdInfo() {
		super();
	}

	public ProdInfo(Integer key, String area, int latitude, int longitude, String status) {
		super();
		this.key = key;
		this.area = area;
		this.latitude = latitude;
		this.longitude = longitude;
		this.status = status;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
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
		return "ProdInfo [key=" + key + ", area=" + area + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", status=" + status + "]";
	}

}
