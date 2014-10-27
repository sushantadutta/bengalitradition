package com.cc.ccadmin.exception;

@SuppressWarnings("serial")
public class ControllerException extends ApplicationException {

	public ControllerException(Throwable th) {
		super(th);
	}

	public ControllerException(String msg) {
		super(msg);
	}
}
