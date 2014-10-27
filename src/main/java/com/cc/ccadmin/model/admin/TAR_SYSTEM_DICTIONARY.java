package com.cc.ccadmin.model.admin;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.cc.ccadmin.model.IBaseModel;

@SuppressWarnings("serial")
@Entity
@Table(name = "TAR_SYSTEM_DICTIONARY")
public class TAR_SYSTEM_DICTIONARY implements IBaseModel {

	private String tsd_table_name;// not null
	private String tsd_table_decription; // not null
	private Integer tsd_sort_order;
	private String tsd_data_source_name; // not null
	private Integer tsd_ttl_id;
	private String tsd_table_type;
	private String tsd_key_column;
	private String tsd_key_unique; // length 1
	private Timestamp tsd_last_modified;
	private String tsd_create_user; // not null
	private Date tsd_create_date; // not null
	private String tsd_update_user;
	private java.sql.Date tsd_update_date;
	private java.util.Set<TAR_SYS_DICTIONARY_COLS> sys_DICTIONARY_COLSs = new HashSet<TAR_SYS_DICTIONARY_COLS>();

	/* getters */

	@Id
	@Column(name = "TSD_TABLE_NAME")
	public String getTsd_table_name() {
		return tsd_table_name;
	}

	@Column(name = "TSD_TABLE_DESCRIPTION")
	public String getTsd_table_decription() {
		return tsd_table_decription;
	}

	@Column(name = "TSD_SORT_ORDER")
	public Integer getTsd_sort_order() {
		return tsd_sort_order;
	}

	@Column(name = "TSD_DATA_SOURCE_NAME")
	public String getTsd_data_source_name() {
		return tsd_data_source_name;
	}

	@Column(name = "TSD_TTL_ID")
	public Integer getTsd_ttl_id() {
		return tsd_ttl_id;
	}

	@Column(name = "TSD_KEY_COLUMN")
	public String getTsd_key_column() {
		return tsd_key_column;
	}

	@Column(name = "TSD_KEY_UNIQUE")
	public String getTsd_key_unique() {
		return tsd_key_unique;
	}

	@Column(name = "TSD_LAST_MODIFIED")
	public Timestamp getTsd_last_modified() {
		return tsd_last_modified;
	}

	@Column(name = "TSD_CREATE_USER")
	public String getTsd_create_user() {
		return tsd_create_user;
	}

	@Column(name = "TSD_CREATE_DATE")
	public Date getTsd_create_date() {
		return tsd_create_date;
	}

	@Column(name = "TSD_UPDATE_USER")
	public String getTsd_update_user() {
		return tsd_update_user;
	}

	@Column(name = "TSD_UPADTE_DATE")
	public java.sql.Date getTsd_update_date() {
		return tsd_update_date;
	}

	@Column(name = "TSD_TABLE_TYPE")
	public String getTsd_table_type() {
		return tsd_table_type;
	}

	@BatchSize(size = 20)
	@Fetch(FetchMode.JOIN)
	@OneToMany(orphanRemoval = true, /*fetch = FetchType.EAGER, cascade = CascadeType.ALL,*/ targetEntity = com.cc.ccadmin.model.admin.TAR_SYS_DICTIONARY_COLS.class)
	@JoinColumn(name = "TDC_TSD_TABLE_NAME", referencedColumnName = "TSD_TABLE_NAME")
	@OrderBy("tdc_sort_order")
	public java.util.Set<TAR_SYS_DICTIONARY_COLS> getSys_DICTIONARY_COLSs() {
		return sys_DICTIONARY_COLSs;
	}

	/* setters */
	public void setTsd_table_name(String tsd_table_name) {
		this.tsd_table_name = tsd_table_name;
	}

	public void setTsd_table_decription(String tsd_table_decription) {
		this.tsd_table_decription = tsd_table_decription;
	}

	public void setTsd_sort_order(Integer tsd_sort_order) {
		this.tsd_sort_order = tsd_sort_order;
	}

	public void setTsd_data_source_name(String tsd_data_source_name) {
		this.tsd_data_source_name = tsd_data_source_name;
	}

	public void setTsd_ttl_id(Integer tsd_ttl_id) {
		this.tsd_ttl_id = tsd_ttl_id;
	}

	public void setTsd_key_column(String tsd_key_column) {
		this.tsd_key_column = tsd_key_column;
	}

	public void setTsd_key_unique(String tsd_key_unique) {
		this.tsd_key_unique = tsd_key_unique;
	}

	public void setTsd_last_modified(Timestamp tsd_last_modified) {
		this.tsd_last_modified = tsd_last_modified;
	}

	public void setTsd_create_user(String tsd_create_user) {
		this.tsd_create_user = tsd_create_user;
	}

	public void setTsd_create_date(Date tsd_create_date) {
		this.tsd_create_date = tsd_create_date;
	}

	public void setTsd_update_user(String tsd_update_user) {
		this.tsd_update_user = tsd_update_user;
	}

	public void setTsd_update_date(java.sql.Date tsd_update_date) {
		this.tsd_update_date = tsd_update_date;
	}

	public void setSys_DICTIONARY_COLSs(
			java.util.Set<TAR_SYS_DICTIONARY_COLS> sys_DICTIONARY_COLSs) {
		this.sys_DICTIONARY_COLSs = sys_DICTIONARY_COLSs;
	}

	public void setTsd_table_type(String tsd_table_type) {
		this.tsd_table_type = tsd_table_type;
	}
}
