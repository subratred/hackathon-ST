package com.hackathon.ShipmentTracker.model;

import java.math.BigDecimal;

public class OrderStats {

	private String userId;
	private Long orderNumber;
	private String source;
	private String destination;
	private BigDecimal mobileNo;
	private String remarks;
	
	public OrderStats() {

	}

	public OrderStats(String userId, Long orderNumber, String source, String destination, BigDecimal mobileNo,
			String remarks) {
		super();
		this.userId = userId;
		this.orderNumber = orderNumber;
		this.source = source;
		this.destination = destination;
		this.mobileNo = mobileNo;
		this.remarks = remarks;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
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

	@Override
	public String toString() {
		return "OrderStats [userId=" + userId + ", orderNumber=" + orderNumber + ", source=" + source + ", destination="
				+ destination + ", mobileNo=" + mobileNo + ", remarks=" + remarks + "]";
	}

	
}
