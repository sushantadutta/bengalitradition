package com.cc.ccadmin.model.admin;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cc.ccadmin.model.IBaseModel;

@SuppressWarnings("serial")
@Entity
@Table(name = "TAR_SYS_DICTIONARY_COLS")
public class TAR_SYS_DICTIONARY_COLS implements IBaseModel {

	private String tdc_key_column_flag; // null length 1
	private String tdc_mandatory; // length 1
	private String tdc_column_title;
	private String tdc_data_type; // length 1
	private BigDecimal tdc_data_length; // null
	private Integer tdc_sort_order;
	private String tdc_frequency_flag; // null length 1
	private Integer tdc_ttl_id; // null
	private String tdc_create_user;
	private Date tdc_create_date;
	private String tdc_update_user; // null
	private Date tdc_update_date; // null
	private Timestamp tdc_last_modified;
	private TAR_SYS_DICTIONARY_COLS_PK cols_PK = new TAR_SYS_DICTIONARY_COLS_PK();


	@EmbeddedId
	public TAR_SYS_DICTIONARY_COLS_PK getCols_PK() {
		return cols_PK;
	}

	@Transient
	public String tdc_tsd_table_name() {
		return getCols_PK().getTdc_tsd_table_name();
	}

	@Transient
	public String tdc_column_name() {
		return getCols_PK().getTdc_column_name();
	}

	/*
	 * getters
	 */
	@Column(name = "TDC_KEY_COLUMN_FLAG")
	public String getTdc_key_column_flag() {
		return tdc_key_column_flag;
	}

	@Column(name = "TDC_MANDATORY")
	public String getTdc_mandatory() {
		return tdc_mandatory;
	}

	@Column(name = "TDC_COLUMN_TITLE")
	public String getTdc_column_title() {
		return tdc_column_title;
	}

	@Column(name = "TDC_DATA_TYPE")
	public String getTdc_data_type() {
		return tdc_data_type;
	}

	@Column(name = "TDC_DATA_LENGTH")
	public BigDecimal getTdc_data_length() {
		return tdc_data_length;
	}

	@Column(name = "TDC_SORT_ORDER")
	public Integer getTdc_sort_order() {
		return tdc_sort_order;
	}

	@Column(name = "TDC_FREQUENCY_FLAG")
	public String getTdc_frequency_flag() {
		return tdc_frequency_flag;
	}

	@Column(name = "TDC_TTL_ID")
	public Integer getTdc_ttl_id() {
		return tdc_ttl_id;
	}

	@Column(name = "TDC_CREATE_USER")
	public String getTdc_create_user() {
		return tdc_create_user;
	}

	@Column(name = "TDC_CREATE_DATE")
	public Date getTdc_create_date() {
		return tdc_create_date;
	}

	@Column(name = "TDC_UPDATE_USER")
	public String getTdc_update_user() {
		return tdc_update_user;
	}

	@Column(name = "TDC_UPDATE_DATE")
	public Date getTdc_update_date() {
		return tdc_update_date;
	}

	@Column(name = "TDC_LAST_MODIFIED")
	public Timestamp getTdc_last_modified() {
		return tdc_last_modified;
	}

	/*
	 * setters
	 */
	public void setTdc_key_column_flag(String tdc_key_column_flag) {
		this.tdc_key_column_flag = tdc_key_column_flag;
	}

	public void setTdc_mandatory(String tdc_mandatory) {
		this.tdc_mandatory = tdc_mandatory;
	}

	public void setTdc_column_title(String tdc_column_title) {
		this.tdc_column_title = tdc_column_title;
	}

	public void setTdc_data_type(String tdc_data_type) {
		this.tdc_data_type = tdc_data_type;
	}

	public void setTdc_data_length(BigDecimal tdc_data_length) {
		this.tdc_data_length = tdc_data_length;
	}

	public void setTdc_sort_order(Integer tdc_sort_order) {
		this.tdc_sort_order = tdc_sort_order;
	}

	public void setTdc_frequency_flag(String tdc_frequency_flag) {
		this.tdc_frequency_flag = tdc_frequency_flag;
	}

	public void setTdc_ttl_id(Integer tdc_ttl_id) {
		this.tdc_ttl_id = tdc_ttl_id;
	}

	public void setTdc_create_user(String tdc_create_user) {
		this.tdc_create_user = tdc_create_user;
	}

	public void setTdc_create_date(Date tdc_create_date) {
		this.tdc_create_date = tdc_create_date;
	}

	public void setTdc_update_user(String tdc_update_user) {
		this.tdc_update_user = tdc_update_user;
	}

	public void setTdc_update_date(Date tdc_update_date) {
		this.tdc_update_date = tdc_update_date;
	}

	public void setTdc_last_modified(Timestamp tdc_last_modified) {
		this.tdc_last_modified = tdc_last_modified;
	}

	public void setCols_PK(TAR_SYS_DICTIONARY_COLS_PK cols_PK) {
		this.cols_PK = cols_PK;
	}

}
