package com.karyawan.karyawanjpacrud.model.response;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class GlobalReturn {
	
	private String httpCode;
	private String status;
	private String message;
	private Object data;
	
	public String getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(String httpCode) {
		this.httpCode = httpCode;
	}

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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public GlobalReturn(HttpStatus httpCode, String status, String message) {
		this.httpCode = Integer.toString(httpCode.value());
		this.status = status;
		this.message = message;
	}
	
	public GlobalReturn(HttpStatus httpCode, String status, Object data) {
		this.httpCode = Integer.toString(httpCode.value());
		this.status = status;
		this.data = data;
	}
	
	public GlobalReturn(HttpStatus httpCode, String status, GlobalMessageAndDataDTO data) {
		this.httpCode = Integer.toString(httpCode.value());
		this.status = status;
		this.message = data.getMessage();
		this.data = data.getData();
	}

}
