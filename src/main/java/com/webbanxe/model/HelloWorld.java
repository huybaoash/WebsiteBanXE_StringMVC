package com.webbanxe.model;

import java.util.List;

public class HelloWorld {
	public String message;
	public String dateTime;
	
	public List<Account> dsTaiKhoan;
	
	public List<Account> getdsTaiKhoan() {
		return dsTaiKhoan;
	}
	
	public void setdsTaiKhoan(List<Account>  dsTaiKhoan) {
		this.dsTaiKhoan = dsTaiKhoan;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	
	
}
