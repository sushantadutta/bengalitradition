package com.cc.ccadmin.model.admin;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class Bas_Application_Parameter_PK implements Serializable{

	private String carp_param_name;
	private String carp_app_code;
	
	
	@Column(name = "CAPR_PARAM_NAME", length = 50,nullable=false)
	public String getCarp_param_name() {
		return carp_param_name;
	}
	@Column(name = "CAPR_APP_CODE", length = 20,nullable=false)
	public String getCarp_app_code() {
		return carp_app_code;
	}
	
	
	public void setCarp_param_name(String carp_param_name) {
		this.carp_param_name = carp_param_name;
	}
	public void setCarp_app_code(String carp_app_code) {
		this.carp_app_code = carp_app_code;
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Bas_Application_Parameter_PK that = (Bas_Application_Parameter_PK) o;

		if (carp_param_name != null ? !carp_param_name
				.equals(that.carp_param_name)
				: that.carp_param_name != null)
			return false;
		if (carp_app_code != null ? !carp_app_code
				.equals(that.carp_app_code) : that.carp_app_code != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = (carp_param_name != null ? carp_param_name.hashCode()
				: 0);
		result = 31 * result
				+ (carp_app_code != null ? carp_app_code.hashCode() : 0);
		return result;
	}

	
	
}
