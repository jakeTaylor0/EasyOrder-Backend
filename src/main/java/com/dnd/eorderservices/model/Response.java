package com.dnd.eorderservices.model;

public class Response {

	private String responseCode;
	
	private String responseMessage;
	
	private Object responseData;

	public Response() {
		super();

	}
	
	public Response(String responseCode, String responseMessage, Object responseData) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
		this.responseData = responseData;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public Object getResponseData() {
		return responseData;
	}

	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}
}
