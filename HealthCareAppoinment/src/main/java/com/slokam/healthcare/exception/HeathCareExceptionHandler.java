package com.slokam.healthcare.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.slokam.healthcare.pojo.ExceptionPojo;

@RestControllerAdvice
public class HeathCareExceptionHandler {
	    @ExceptionHandler(Exception.class)
		public ResponseEntity<ExceptionPojo> handlingException(Exception e){
		ExceptionPojo ep=new ExceptionPojo();
		ep.setErrorId(150);
		ep.setMassage("aplication went to wrong some how.");
		ep.setT(e);
		return new ResponseEntity<ExceptionPojo>(ep,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(UserHealthCareException.class)
	public ResponseEntity<UserHealthCareException> userHandlingException(UserHealthCareException userException){
		return new ResponseEntity<UserHealthCareException>(userException,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
