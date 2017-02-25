package com.maanas.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageResponse {
	public static final String SUCCESS = "SUCCESS";
	public static final String FAILURE = "FAILURE";
	
	public static ResponseEntity<MessageResponse> successOk(String message) {
		return new ResponseEntity<MessageResponse>(new MessageResponse(SUCCESS, message), HttpStatus.OK);
	}
	
	public static ResponseEntity<MessageResponse> failureOk(String message) {
		return new ResponseEntity<MessageResponse>(new MessageResponse(FAILURE, message), HttpStatus.OK);
	}
	
	public static ResponseEntity<MessageResponse> failureNotFound(String message) {
		return new ResponseEntity<MessageResponse>(new MessageResponse(FAILURE, message), HttpStatus.NOT_FOUND);
	}
	
	public static ResponseEntity<MessageResponse> failureBadRequest(String message) {
		return new ResponseEntity<MessageResponse>(new MessageResponse(FAILURE, message), HttpStatus.BAD_REQUEST);
	}
	
	public static ResponseEntity<MessageResponse> failureNotAcceptable(String message) {
		return new ResponseEntity<MessageResponse>(new MessageResponse(FAILURE, message), HttpStatus.NOT_ACCEPTABLE);
	}
	
	public String status=SUCCESS;
	public String message;
	
	public MessageResponse(String status, String message) {
		super();
		this.status = status;
		this.message = message;
		if ( this.message == null ) this.message = "";
	}
	
	
}
