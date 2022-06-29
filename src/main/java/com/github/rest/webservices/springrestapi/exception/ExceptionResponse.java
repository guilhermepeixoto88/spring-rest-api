package com.github.rest.webservices.springrestapi.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExceptionResponse {
	
	private Date timestamp;
	private List<String> errorMessageList;
	private String details;
	
	public ExceptionResponse() {
		super();
	}

	public ExceptionResponse(Date timestamp, List<String> errorMessageList, String details) {
		super();
		this.timestamp = timestamp;
		this.errorMessageList = errorMessageList;
		this.details = details;
	}
	
	public ExceptionResponse(Date timestamp, String errorMessage, String details) {
		super();
		
		List<String> errorMessageList = new ArrayList<>();
		errorMessageList.add(errorMessage);
		
		this.timestamp = timestamp;
		this.errorMessageList = errorMessageList;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public List<String> getErrorMessageList() {
		return errorMessageList;
	}

	public void setErrorMessageList(List<String> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
}
