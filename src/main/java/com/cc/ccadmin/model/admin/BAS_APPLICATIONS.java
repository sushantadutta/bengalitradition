package com.cc.ccadmin.model.admin;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

import com.cc.ccadmin.model.IBaseModel;

@SuppressWarnings("serial")
@Entity
@Table(name = "BAS_APPLICATIONS")
public class BAS_APPLICATIONS implements IBaseModel {

	private String cap_app_code;
	private String cap_app_name;
	private String cap_app_owner;
	private String cap_passwd;
	private String cap_app_display_name;
	private Date cap_app_create_date;
	private String cap_create_user;
	private Date cap_modify_date;
	private String cap_modify_user;
	private Set<BAS_APPLICATION_PARAMETERS> bas_APPLICATION_PARAMETERSs = new HashSet<BAS_APPLICATION_PARAMETERS>(
			0);

	@BatchSize(size = 20)
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL, targetEntity = BAS_APPLICATION_PARAMETERS.class)
	// @ElementCollection(targetClass=com.cc.ccadmin.model.admin.BAS_APPLICATION_PARAMETERS.class)
	@JoinColumn(name = "CAPR_APP_CODE", referencedColumnName = "CAP_APP_CODE")
	public Set<BAS_APPLICATION_PARAMETERS> getBas_APPLICATION_PARAMETERSs() {
		return bas_APPLICATION_PARAMETERSs;
	}

	@Id
	@Column(name = "CAP_APP_CODE", length = 20, nullable = false)
	public String getCap_app_code() {
		return cap_app_code;
	}

	@Column(name = "CAP_APP_NAME", length = 60, nullable = false)
	public String getCap_app_name() {
		return cap_app_name;
	}

	@Column(name = "CAP_APP_OWNER", length = 60, nullable = false)
	public String getCap_app_owner() {
		return cap_app_owner;
	}

	@Column(name = "CAP_PASSWD", length = 200, nullable = false)
	public String getCap_passwd() {
		return cap_passwd;
	}

	@Column(name = "CAP_APP_DISPLAY_NAME", length = 200, nullable = false)
	public String getCap_app_display_name() {
		return cap_app_display_name;
	}

	@Column(name = "CAP_APP_CREATE_DATE")
	public Date getCap_app_create_date() {
		return cap_app_create_date;
	}

	@Column(name = "CAP_CREATE_USER", length = 30)
	public String getCap_create_user() {
		return cap_create_user;
	}

	@Column(name = "CAP_MODIFY_DATE")
	public Date getCap_modify_date() {
		return cap_modify_date;
	}

	@Column(name = "CAP_MODIFY_USER", length = 30)
	public String getCap_modify_user() {
		return cap_modify_user;
	}

	public void setBas_APPLICATION_PARAMETERSs(
			Set<BAS_APPLICATION_PARAMETERS> bas_APPLICATION_PARAMETERSs) {
		this.bas_APPLICATION_PARAMETERSs = bas_APPLICATION_PARAMETERSs;
	}

	public void setCap_app_code(String cap_app_code) {
		this.cap_app_code = cap_app_code;
	}

	public void setCap_app_name(String cap_app_name) {
		this.cap_app_name = cap_app_name;
	}

	public void setCap_app_owner(String cap_app_owner) {
		this.cap_app_owner = cap_app_owner;
	}

	public void setCap_passwd(String cap_passwd) {
		this.cap_passwd = cap_passwd;
	}

	public void setCap_app_display_name(String cap_app_display_name) {
		this.cap_app_display_name = cap_app_display_name;
	}

	public void setCap_app_create_date(Date cap_app_create_date) {
		this.cap_app_create_date = cap_app_create_date;
	}

	public void setCap_create_user(String cap_create_user) {
		this.cap_create_user = cap_create_user;
	}

	public void setCap_modify_date(Date cap_modify_date) {
		this.cap_modify_date = cap_modify_date;
	}

	public void setCap_modify_user(String cap_modify_user) {
		this.cap_modify_user = cap_modify_user;
	}
}
