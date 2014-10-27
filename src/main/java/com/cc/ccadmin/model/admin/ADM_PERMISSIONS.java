package com.cc.ccadmin.model.admin;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.cc.ccadmin.model.IBaseModel;

@SuppressWarnings("serial")
@Entity
@Table(name = "ADM_PERMISSIONS")
public class ADM_PERMISSIONS implements IBaseModel {

	private String apn_code;
	private String apn_description;
	//private String apn_amd_code;
	private String apn_permission;
	private String apn_system_flag;
	private String apn_delete_flag;
	private String apn_create_user;
	private Date apn_create_date;
	private String apn_update_user;
	private Date apn_update_date;
	private ADM_MODULES adm_MODULES;
	private Set<ADM_GROUP_PERMISSIONS> adm_GROUP_PERMISSIONSs = new HashSet<ADM_GROUP_PERMISSIONS>(0);

	@Id
	@Column(name = "APN_CODE", length = 20, nullable = false)
	public String getApn_code() {
		return apn_code;
	}

	@Column(name = "APN_DESCRIPTION", length = 60, nullable = false)
	public String getApn_description() {
		return apn_description;
	}

	/*@Column(name = "APN_AMD_CODE", length = 15, nullable = false)
	public String getApn_amd_code() {
		return apn_amd_code;
	}*/

	@Column(name = "APN_PERMISSION", length = 1, nullable = false)
	public String getApn_permission() {
		return apn_permission;
	}

	@Column(name = "APN_SYSTEM_FLAG", length = 1)
	public String getApn_system_flag() {
		return apn_system_flag;
	}

	@Column(name = "APN_DELETE_FLAG", length = 1)
	public String getApn_delete_flag() {
		return apn_delete_flag;
	}

	@Column(name = "APN_CREATE_USER", length = 30)
	public String getApn_create_user() {
		return apn_create_user;
	}

	@Column(name = "APN_CREATE_DATE")
	public Date getApn_create_date() {
		return apn_create_date;
	}

	@Column(name = "APN_UPDATE_USER")
	public String getApn_update_user() {
		return apn_update_user;
	}

	@Column(name = "APN_UPDATE_DATE")
	public Date getApn_update_date() {
		return apn_update_date;
	}

	@BatchSize(size=20)
	@Fetch(FetchMode.JOIN)
	@OneToMany(orphanRemoval=true,/*fetch = FetchType.EAGER,*/ mappedBy = "pk.permissions"/*,cascade = {CascadeType.ALL}*/)
	//@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	public Set<ADM_GROUP_PERMISSIONS> getAdm_GROUP_PERMISSIONSs() {
		return adm_GROUP_PERMISSIONSs;
	}

	@ManyToOne
	@JoinColumn(name = "APN_AMD_CODE")
	public ADM_MODULES getAdm_MODULES() {
		return adm_MODULES;
	}

	/*
	 * setters
	 */

	public void setApn_code(String apn_code) {
		this.apn_code = apn_code;
	}

	public void setApn_description(String apn_description) {
		this.apn_description = apn_description;
	}

	/*public void setApn_amd_code(String apn_amd_code) {
		this.apn_amd_code = apn_amd_code;
	}*/

	public void setApn_permission(String apn_permission) {
		this.apn_permission = apn_permission;
	}

	public void setApn_system_flag(String apn_system_flag) {
		this.apn_system_flag = apn_system_flag;
	}

	public void setApn_delete_flag(String apn_delete_flag) {
		this.apn_delete_flag = apn_delete_flag;
	}

	public void setApn_create_user(String apn_create_user) {
		this.apn_create_user = apn_create_user;
	}

	public void setApn_create_date(Date apn_create_date) {
		this.apn_create_date = apn_create_date;
	}

	public void setApn_update_user(String apn_update_user) {
		this.apn_update_user = apn_update_user;
	}

	public void setApn_update_date(Date apn_update_date) {
		this.apn_update_date = apn_update_date;
	}

	public void setAdm_GROUP_PERMISSIONSs(
			Set<ADM_GROUP_PERMISSIONS> adm_GROUP_PERMISSIONSs) {
		this.adm_GROUP_PERMISSIONSs = adm_GROUP_PERMISSIONSs;
	}

	public void setAdm_MODULES(ADM_MODULES adm_MODULES) {
		this.adm_MODULES = adm_MODULES;
	}
}
