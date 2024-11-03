package com.lemon.pojo;

public class Result {
	/**
	 * 状态标志位（1：代表接口正常处理 0：代表处理异常）
	 */
	private String status;
	/**
	 * 用户提示
	 */
	private String message;
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Result(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public Result() {
		super();
	}

	
	

}
