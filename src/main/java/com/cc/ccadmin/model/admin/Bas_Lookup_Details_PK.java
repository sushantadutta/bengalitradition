package com.cc.ccadmin.model.admin;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class Bas_Lookup_Details_PK implements Serializable {

	private String dld_dlk_lookup_name;
	private String dld_lookup_code;

	
	@Column(name = "DLD_DLK_LOOKUP_NAME", length = 30, nullable = false)
	public String getDld_dlk_lookup_name() {
		return dld_dlk_lookup_name;
	}

	@Column(name = "DLD_LOOKUP_CODE", length = 100, nullable = false)
	public String getDld_lookup_code() {
		return dld_lookup_code;
	}

	public void setDld_lookup_code(String dld_lookup_code) {
		this.dld_lookup_code = dld_lookup_code;
	}

	public void setDld_dlk_lookup_name(String dld_dlk_lookup_name) {
		this.dld_dlk_lookup_name = dld_dlk_lookup_name;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Bas_Lookup_Details_PK that = (Bas_Lookup_Details_PK) o;

		if (dld_dlk_lookup_name != null ? !dld_dlk_lookup_name
				.equals(that.dld_dlk_lookup_name)
				: that.dld_dlk_lookup_name != null)
			return false;
		if (dld_lookup_code != null ? !dld_lookup_code
				.equals(that.dld_lookup_code) : that.dld_lookup_code != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = (dld_dlk_lookup_name != null ? dld_dlk_lookup_name.hashCode()
				: 0);
		result = 31 * result
				+ (dld_lookup_code != null ? dld_lookup_code.hashCode() : 0);
		return result;
	}

}
