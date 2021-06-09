package com.slokam.healthcare.exception;

public class UserHealthCareException extends Exception{
	private Integer errorCode;
	public UserHealthCareException() {
		
	}
	public UserHealthCareException(String massage,Integer errorCode) {
		super(massage);
		this.errorCode=errorCode;
	}
	public UserHealthCareException(String massage,Integer errorCode,Throwable exception) {
		super(massage,exception);
		this.errorCode=errorCode;
	}
}
