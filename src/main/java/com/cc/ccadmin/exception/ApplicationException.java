package com.cc.ccadmin.exception;

@SuppressWarnings("serial")
public class ApplicationException extends Exception {

	private String message;

	public String getMessage() {
		return message;
	}

	public ApplicationException(String msg) {
		
		super(msg);
	}
	public ApplicationException(Throwable th) {
		super(th);
	}
}
