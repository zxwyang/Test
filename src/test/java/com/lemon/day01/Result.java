package com.lemon.day01;

public class Result {
	
	private String status;
	private String message;
	
	public Result() {
		
	}
	
	public Result(String status,String message) {
		this.status=status;
		this.message=message;
	}
	
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String sratus) {
		this.status=sratus;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message=message;
	}

	
}
