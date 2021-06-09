package com.slokam.healthcare.pojo;

public class ExceptionPojo {
	private Integer errorId;
	private String massage;
	private Throwable t;
	
	public Integer getErrorId() {
		return errorId;
	}
	public void setErrorId(Integer errorId) {
		this.errorId = errorId;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	public Throwable getT() {
		return t;
	}
	public void setT(Throwable t) {
		this.t = t;
	}
	
	
}
