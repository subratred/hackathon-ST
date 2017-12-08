package com.hackathon.ShipmentTracker.model;
import java.util.List;

public class ServiceResponse {

	private String message;
	private String status;
	private List<?> data;
	private String userMessage;
	public ServiceResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ServiceResponse(String message, String status, List<?> data, String userMessage) {
		super();
		this.message = message;
		this.status = status;
		this.data = data;
		this.userMessage = userMessage;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	public String getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	@Override
	public String toString() {
		return "ServiceResponse [message=" + message + ", status=" + status + ", data=" + data + ", userMessage="
				+ userMessage + "]";
	}
}
