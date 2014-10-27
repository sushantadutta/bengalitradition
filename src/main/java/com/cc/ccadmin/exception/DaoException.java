package com.cc.ccadmin.exception;

@SuppressWarnings("serial")
public class DaoException extends ApplicationException {

	public DaoException(String msg) {
		super(msg);
	}

	public String convertDaoException(String msg) {

		return null;
	}
	
	public DaoException(Throwable th) {
		super(th);
	}
}
