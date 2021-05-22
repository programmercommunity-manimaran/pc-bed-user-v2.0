package com.programmercommunity.hicks.user.model;

public class Response {

	private int status;
	private String message;

	public Response() {
		super();
	}

	public Response(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
