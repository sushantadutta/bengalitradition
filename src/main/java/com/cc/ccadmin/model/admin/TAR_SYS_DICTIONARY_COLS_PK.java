package com.cc.ccadmin.model.admin;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.cc.ccadmin.model.IBaseModel;

@SuppressWarnings("serial")
@Embeddable
public class TAR_SYS_DICTIONARY_COLS_PK implements IBaseModel {

	private String tdc_tsd_table_name;
	private String tdc_column_name;

	/*
	 * getters
	 */
	@Column(name = "TDC_TSD_TABLE_NAME")
	public String getTdc_tsd_table_name() {
		return tdc_tsd_table_name;
	}

	@Column(name = "TDC_COLUMN_NAME")
	public String getTdc_column_name() {
		return tdc_column_name;
	}

	/*
	 * setters
	 */

	public void setTdc_column_name(String tdc_column_name) {
		this.tdc_column_name = tdc_column_name;
	}

	public void setTdc_tsd_table_name(String tdc_tsd_table_name) {
		this.tdc_tsd_table_name = tdc_tsd_table_name;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		TAR_SYS_DICTIONARY_COLS_PK that = (TAR_SYS_DICTIONARY_COLS_PK) o;

		if (tdc_tsd_table_name != null ? !tdc_tsd_table_name
				.equals(that.tdc_tsd_table_name)
				: that.tdc_tsd_table_name != null)
			return false;
		if (tdc_column_name != null ? !tdc_column_name
				.equals(that.tdc_column_name) : that.tdc_column_name != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = (tdc_tsd_table_name != null ? tdc_tsd_table_name.hashCode()
				: 0);
		result = 31 * result
				+ (tdc_column_name != null ? tdc_column_name.hashCode() : 0);
		return result;
	}

}
