package com.companyname.web.model.platform;

public class JsonMessage {

	private String code;

	private String message;

	public JsonMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "JsonMessage [code=" + code + ", message=" + message + "]";
	}

}
