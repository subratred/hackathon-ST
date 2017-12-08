package com.hackathon.ShipmentTracker.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class OrderStats {

	private String userId;
	private String orderNumber;
	private String source;
	private String destination;
	private BigDecimal mobileNo;
	private String remarks;
	private int step;
	private String deliveryType;
	private Date lastModifiedDate;
	private java.sql.Timestamp lastModifiedTime; 
	
	
	public OrderStats() {

	}


	public OrderStats(String userId, String orderNumber, String source, String destination, BigDecimal mobileNo,
			String remarks, int step, String deliveryType, Date lastModifiedDate, Timestamp lastModifiedTime) {
		super();
		this.userId = userId;
		this.orderNumber = orderNumber;
		this.source = source;
		this.destination = destination;
		this.mobileNo = mobileNo;
		this.remarks = remarks;
		this.step = step;
		this.deliveryType = deliveryType;
		this.lastModifiedDate = lastModifiedDate;
		this.lastModifiedTime = lastModifiedTime;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getOrderNumber() {
		return orderNumber;
	}


	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
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


	public BigDecimal getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(BigDecimal mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public int getStep() {
		return step;
	}


	public void setStep(int step) {
		this.step = step;
	}


	public String getDeliveryType() {
		return deliveryType;
	}


	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}


	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}


	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}


	public java.sql.Timestamp getLastModifiedTime() {
		return lastModifiedTime;
	}


	public void setLastModifiedTime(java.sql.Timestamp lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}


	@Override
	public String toString() {
		return "OrderStats [userId=" + userId + ", orderNumber=" + orderNumber + ", source=" + source + ", destination="
				+ destination + ", mobileNo=" + mobileNo + ", remarks=" + remarks + ", step=" + step + ", deliveryType="
				+ deliveryType + ", lastModifiedDate=" + lastModifiedDate + ", lastModifiedTime=" + lastModifiedTime
				+ "]";
	}
}
