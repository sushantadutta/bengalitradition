package com.cc.ccadmin.model.admin;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class Imp_Load_Col_Ref_PK implements Serializable {

	private String ilc_ilt_table_name;
	private String ilc_column_name;

	@Column(name = "ILC_ILT_TABLE_NAME", length = 30, nullable = false)
	public String getIlc_ilt_table_name() {
		return ilc_ilt_table_name;
	}

	@Column(name = "ILC_COLUMN_NAME", length = 30, nullable = false)
	public String getIlc_column_name() {
		return ilc_column_name;
	}

	public void setIlc_ilt_table_name(String ilc_ilt_table_name) {
		this.ilc_ilt_table_name = ilc_ilt_table_name;
	}

	public void setIlc_column_name(String ilc_column_name) {
		this.ilc_column_name = ilc_column_name;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Imp_Load_Col_Ref_PK that = (Imp_Load_Col_Ref_PK) o;

		if (ilc_column_name != null ? !ilc_column_name
				.equals(that.ilc_column_name) : that.ilc_column_name != null)
			return false;
		if (ilc_ilt_table_name != null ? !ilc_ilt_table_name.equals(that.ilc_ilt_table_name)
				: that.ilc_ilt_table_name != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = (ilc_column_name != null ? ilc_column_name.hashCode() : 0);
		result = 31 * result
				+ (ilc_ilt_table_name != null ? ilc_ilt_table_name.hashCode() : 0);
		return result;
	}

}
