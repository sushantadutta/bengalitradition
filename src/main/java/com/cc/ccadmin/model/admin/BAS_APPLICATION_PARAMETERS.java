package com.cc.ccadmin.model.admin;

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
@Table(name = "BAS_APPLICATION_PARAMETERS")
public class BAS_APPLICATION_PARAMETERS implements IBaseModel{	
	
	private String carp_desc;	
	private String carp_short_desc;	
	private String carp_param_values;	
	private String carp_param_type;	
	private String carp_sys_param_flag;	
	private String carp_module_code;	
	private String carp_possible_values;	
	private Timestamp carp_last_modified;	
	private String carp_update_user;	
	private Date carp_update_date;	
	
	private Bas_Application_Parameter_PK application_Parameter_PK = new Bas_Application_Parameter_PK();
	
	@EmbeddedId
	public Bas_Application_Parameter_PK getApplication_Parameter_PK() {
		return application_Parameter_PK;
	}
	
	@Transient
	public String getCarp_param_name(){
		return getApplication_Parameter_PK().getCarp_param_name();
	}
	
	@Transient
	public String getCap_app_code(){
		return getApplication_Parameter_PK().getCarp_app_code();
	}
	
	@Column(name = "CAPR_DESC", length = 200)
	public String getCarp_desc() {
		return carp_desc;
	}	
	@Column(name = "CAPR_PARAM_VALUE", length = 50, nullable = false)
	public String getCarp_param_values() {
		return carp_param_values;
	}	
	@Column(name = "CAPR_PRAM_TYPE", length = 1, nullable = false)
	public String getCarp_param_type() {
		return carp_param_type;
	}	
	@Column(name = "CAPR_SYS_PARAM_FLG", length = 1, nullable = false)
	public String getCarp_sys_param_flag() {
		return carp_sys_param_flag;
	}	
	@Column(name = "CAPR_MODULE_CODE", length = 20)
	public String getCarp_module_code() {
		return carp_module_code;
	}	
	@Column(name = "CAPR_POSSIBLE_VALUES", length = 500)
	public String getCarp_possible_values() {
		return carp_possible_values;
	}	
	@Column(name = "CAPR_LAST_MODIFIED")
	public Timestamp getCarp_last_modified() {
		return carp_last_modified;
	}	
	@Column(name = "CAPR_SHORT_DESC", length = 100)
	public String getCarp_short_desc() {
		return carp_short_desc;
	}	
	@Column(name = "CAPR_UPDATE_USER", length = 30)
	public String getCarp_update_user() {
		return carp_update_user;
	}	
	@Column(name = "CAPR_UPDATE_DATE")
	public Date getCarp_update_date() {
		return carp_update_date;
	}
	public void setCarp_update_date(Date carp_update_date) {
		this.carp_update_date = carp_update_date;
	}
	public void setApplication_Parameter_PK(
			Bas_Application_Parameter_PK application_Parameter_PK) {
		this.application_Parameter_PK = application_Parameter_PK;
	}
	public void setCarp_desc(String carp_desc) {
		this.carp_desc = carp_desc;
	}
	public void setCarp_param_values(String carp_param_values) {
		this.carp_param_values = carp_param_values;
	}
	public void setCarp_param_type(String carp_param_type) {
		this.carp_param_type = carp_param_type;
	}
	public void setCarp_sys_param_flag(String carp_sys_param_flag) {
		this.carp_sys_param_flag = carp_sys_param_flag;
	}
	public void setCarp_module_code(String carp_module_code) {
		this.carp_module_code = carp_module_code;
	}
	public void setCarp_possible_values(String carp_possible_values) {
		this.carp_possible_values = carp_possible_values;
	}
	public void setCarp_short_desc(String carp_short_desc) {
		this.carp_short_desc = carp_short_desc;
	}
	public void setCarp_last_modified(Timestamp carp_last_modified) {
		this.carp_last_modified = carp_last_modified;
	}
	public void setCarp_update_user(String carp_update_user) {
		this.carp_update_user = carp_update_user;
	}
	
}
