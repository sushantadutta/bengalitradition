package com.cc.ccadmin.model.admin;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cc.ccadmin.model.IBaseModel;

@SuppressWarnings("serial")
@Entity
@Table(name="TAR_TARGET_LEVELS")
public class TAR_TARGET_LEVELS implements IBaseModel{

	private Integer ttl_id;
	private String ttl_name;
	private String ttl_data_type; // length 1
	private String ttl_create_user;
	private Date ttl_create_date;
	private String ttl_update_user;
	private Date ttl_update_date;
	private Timestamp ttl_last_modified;

	/*
	 * getters
	 */
	@Id
	@Column(name = "TTL_ID")
	public Integer getTtl_id() {
		return ttl_id;
	}

	@Column(name = "TTL_NAME")
	public String getTtl_name() {
		return ttl_name;
	}

	@Column(name = "TTL_DATA_TYPE")
	public String getTtl_data_type() {
		return ttl_data_type;
	}

	@Column(name = "TTL_CREATE_USER")
	public String getTtl_create_user() {
		return ttl_create_user;
	}

	@Column(name = "TTL_CREATE_DATE")
	public Date getTtl_create_date() {
		return ttl_create_date;
	}

	@Column(name = "TTL_UPDATE_USER")
	public String getTtl_update_user() {
		return ttl_update_user;
	}

	@Column(name = "TTL_UPDATE_DATE")
	public Date getTtl_update_date() {
		return ttl_update_date;
	}

	@Column(name = "TTL_LAST_MODIFIED")
	public Timestamp getTtl_last_modified() {
		return ttl_last_modified;
	}

	/*
	 * settrs
	 */
	public void setTtl_id(Integer ttl_id) {
		this.ttl_id = ttl_id;
	}

	public void setTtl_name(String ttl_name) {
		this.ttl_name = ttl_name;
	}

	public void setTtl_data_type(String ttl_data_type) {
		this.ttl_data_type = ttl_data_type;
	}

	public void setTtl_create_user(String ttl_create_user) {
		this.ttl_create_user = ttl_create_user;
	}

	public void setTtl_create_date(Date ttl_create_date) {
		this.ttl_create_date = ttl_create_date;
	}

	public void setTtl_update_user(String ttl_update_user) {
		this.ttl_update_user = ttl_update_user;
	}

	public void setTtl_update_date(Date ttl_update_date) {
		this.ttl_update_date = ttl_update_date;
	}

	public void setTtl_last_modified(Timestamp ttl_last_modified) {
		this.ttl_last_modified = ttl_last_modified;
	}
}
