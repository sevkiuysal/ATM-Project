package com.koylumuhendis.atmproject.exception;

import org.springframework.http.HttpStatus;


public class GenericException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private final HttpStatus httpStatus;
	private final String errorMessage;
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	public static class builder{
		private HttpStatus httpStatus;
		private String errorMessage;
		
		public builder httpStatus(HttpStatus httpStatus) {
			this.httpStatus=httpStatus;
			return this;
		}
		public builder errorMessage(String errorMessage) {
			this.errorMessage=errorMessage;
			return this;
		}
		public GenericException build() {
			return new GenericException(this);
		}
	}
	public GenericException(builder builder) {
		this.httpStatus=builder.httpStatus;
		this.errorMessage=builder.errorMessage;
	}


}
