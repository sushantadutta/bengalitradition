package com.cc.ccadmin.util;

import java.io.Serializable;

public class PasswordBeanHolder implements Serializable {

	/**
	 * @see Holding data for changePassword form
	 * @author sushanta
	 */
	private static final long serialVersionUID = 1L;
	private String existingPasswd;
	private String newPassword;

	public String getExistingPasswd() {
		return existingPasswd;
	}

	public void setExistingPasswd(String existingPasswd) {
		this.existingPasswd = existingPasswd;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
