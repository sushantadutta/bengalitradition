package com.cc.ccadmin.model.admin;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

import com.cc.ccadmin.model.IBaseModel;

@SuppressWarnings("serial")
@Entity
@Table(name = "ADM_USERS")
public class ADM_USER implements IBaseModel {

	private String aus_user_name;
	private String aus_first_name;
	private String aus_last_name;
	private String aus_family_name;
	private String aus_password;
	private String aus_notify_option;
	private Long aus_mobile_number;
	private String aus_email;
	private String aus_work_area;
	private String aus_notes;
	private Date aus_last_login_date;
	private String aus_admin_flag;
	private String aus_create_user;
	private Date aus_create_date;
	private String aus_update_user;
	private Date aus_update_date;
	private String aus_status;
	private Integer aus_retry_attempt;
	private Date aus_password_change_date;
	private Date aus_start_date;
	private Date aus_end_date;
	private Timestamp aus_last_modified;
	private Set<ADM_USER_GROUP> adm_USER_GROUPs = new HashSet<ADM_USER_GROUP>(0);
	//private byte[] password;

//	@Transient
//	// @Column(name = "AUS_PASSWORD")
//	public byte[] getPassword() {
//		return password;
//	}
//
//	public void setPassword(byte[] password) {
//		this.password = password;
//	}



	@Id
	// @NotNull
	@Column(name = "AUS_USERNAME", length = 30, nullable = false)
	public String getAus_user_name() {
		return aus_user_name;
	}

	// @NotNull
	@Column(name = "AUS_FIRST_NAME", length = 30, nullable = false)
	public String getAus_first_name() {
		return aus_first_name;
	}

	@Column(name = "AUS_LAST_NAME", length = 30)
	public String getAus_last_name() {
		return aus_last_name;
	}

	// @NotNull
	@Column(name = "AUS_FAMILY_NAME", length = 30, nullable = false)
	public String getAus_family_name() {
		return aus_family_name;
	}

	// @NotNull

	@Column(name = "AUS_PASSWORD")
	public String getAus_password() {
		return aus_password;
	}

	// @NotNull
	@Column(name = "AUS_NOTIFY_OPTION", length = 1, nullable = false)
	public String getAus_notify_option() {
		return aus_notify_option;
	}

	// @NotNull
	@Column(name = "AUS_MOBILE_NUMBER", length = 15)
	public Long getAus_mobile_number() {
		return aus_mobile_number;
	}

	@Column(name = "AUS_EMAIL", length = 100)
	public String getAus_email() {
		return aus_email;
	}

	// @NotNull
	@Column(name = "AUS_WORK_AREA", length = 30, nullable = false)
	public String getAus_work_area() {
		return aus_work_area;
	}

	@Column(name = "AUS_NOTES", length = 200)
	public String getAus_notes() {
		return aus_notes;
	}

	@Column(name = "AUS_LAST_LOGIN_DATE")
	public Date getAus_last_login_date() {
		return aus_last_login_date;
	}

	@Column(name = "AUS_ADMIN_FLAG", length = 1)
	public String getAus_admin_flag() {
		return aus_admin_flag;
	}

	@Column(name = "AUS_CREATE_USER", length = 30, nullable = false)
	public String getAus_create_user() {
		return aus_create_user;
	}

	@Column(name = "AUS_CREATE_DATE", nullable = false)
	public Date getAus_create_date() {
		return aus_create_date;
	}

	@Column(name = "AUS_UPDATE_USER", length = 30)
	public String getAus_update_user() {
		return aus_update_user;
	}

	@Column(name = "AUS_UPDATE_DATE")
	public Date getAus_update_date() {
		return aus_update_date;
	}

	@Column(name = "AUS_STATUS", length = 1)
	public String getAus_status() {
		return aus_status;
	}

	@Column(name = "AUS_RETRY_ATTEMPT")
	public Integer getAus_retry_attempt() {
		return aus_retry_attempt;
	}

	@Column(name = "AUS_PASSWORD_CHANGE_DATE")
	public Date getAus_password_change_date() {
		return aus_password_change_date;
	}

	@Column(name = "AUS_START_DATE", nullable = false)
	public Date getAus_start_date() {
		return aus_start_date;
	}

	@Column(name = "AUS_END_DATE", nullable = false)
	public Date getAus_end_date() {
		return aus_end_date;
	}

	@Column(name = "AUS_LAST_MODIFIED", nullable = false)
	public Timestamp getAus_last_modified() {
		return aus_last_modified;
	}

	@BatchSize(size = 20)
	@OneToMany(orphanRemoval = true, /*fetch = FetchType.EAGER,*/ mappedBy = "pk.user"/*, cascade = { CascadeType.ALL }*/)
	// @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	public Set<ADM_USER_GROUP> getAdm_USER_GROUPs() {
		return adm_USER_GROUPs;
	}

	/* Setters */
	public void setAus_user_name(String aus_user_name) {
		this.aus_user_name = aus_user_name;
	}

	public void setAus_first_name(String aus_first_name) {
		this.aus_first_name = aus_first_name;
	}

	public void setAus_last_name(String aus_last_name) {
		this.aus_last_name = aus_last_name;
	}

	public void setAus_family_name(String aus_family_name) {
		this.aus_family_name = aus_family_name;
	}

	public void setAus_password(String aus_password) {
		this.aus_password = aus_password;
	}

	public void setAus_notify_option(String aus_notify_option) {
		this.aus_notify_option = aus_notify_option;
	}

	public void setAus_mobile_number(Long aus_mobile_number) {
		this.aus_mobile_number = aus_mobile_number;
	}

	public void setAus_email(String aus_email) {
		this.aus_email = aus_email;
	}

	public void setAus_work_area(String aus_work_area) {
		this.aus_work_area = aus_work_area;
	}

	public void setAus_notes(String aus_notes) {
		this.aus_notes = aus_notes;
	}

	public void setAus_last_login_date(Date aus_last_login_date) {
		this.aus_last_login_date = aus_last_login_date;
	}

	public void setAus_admin_flag(String aus_admin_flag) {
		this.aus_admin_flag = aus_admin_flag;
	}

	public void setAus_create_user(String aus_create_user) {
		this.aus_create_user = aus_create_user;
	}

	public void setAus_create_date(Date aus_create_date) {
		this.aus_create_date = aus_create_date;
	}

	public void setAus_update_user(String aus_update_user) {
		this.aus_update_user = aus_update_user;
	}

	public void setAus_update_date(Date aus_update_date) {
		this.aus_update_date = aus_update_date;
	}

	public void setAus_status(String aus_status) {
		this.aus_status = aus_status;
	}

	public void setAus_retry_attempt(Integer aus_retry_attempt) {
		this.aus_retry_attempt = aus_retry_attempt;
	}

	public void setAus_password_change_date(Date aus_password_change_date) {
		this.aus_password_change_date = aus_password_change_date;
	}

	public void setAus_start_date(Date aus_start_date) {
		this.aus_start_date = aus_start_date;
	}

	public void setAus_end_date(Date aus_end_date) {
		this.aus_end_date = aus_end_date;
	}

	public void setAus_last_modified(Timestamp aus_last_modified) {
		this.aus_last_modified = aus_last_modified;
	}

	public void setAdm_USER_GROUPs(Set<ADM_USER_GROUP> adm_USER_GROUPs) {
		this.adm_USER_GROUPs = adm_USER_GROUPs;
	}

}
