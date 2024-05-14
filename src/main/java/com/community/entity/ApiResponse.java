package com.community.entity;

public class ApiResponse {
	
	private String Success;
	private boolean message;
	public String getSuccess() {
		return Success;
	}
	public void setSuccess(String success) {
		Success = success;
	}
	public boolean isMessage() {
		return message;
	}
	public void setMessage(boolean message) {
		this.message = message;
	}
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApiResponse(String success, boolean message) {
		super();
		Success = success;
		this.message = message;
	}

	
}
