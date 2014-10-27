package com.cc.ccadmin.model.admin;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cc.ccadmin.model.IBaseModel;

@SuppressWarnings("serial")
@Entity
@Table(name = "BAS_LOOKUP_DETAILS")
public class BAS_LOOKUP_DETAILS implements IBaseModel {

	private String dld_lookup_meaning;
	private BigDecimal dld_sort_order;
	private Timestamp dld_last_modified;
	private String dld_system_flag;
	private Bas_Lookup_Details_PK bas_Lookup_Details_PK = new Bas_Lookup_Details_PK();
	
	@EmbeddedId
	public Bas_Lookup_Details_PK getBas_Lookup_Details_PK() {
		return bas_Lookup_Details_PK;
	}
	
	@Transient
	public String dld_lookup_code() {
		return getBas_Lookup_Details_PK().getDld_lookup_code();
	}
	
	@Transient
	public String dld_dlk_lookup_name() {
		return getBas_Lookup_Details_PK().getDld_dlk_lookup_name();
	}
	
	@Column(name = "DLD_LOOKUP_MEANING", length = 200, nullable = false)
	public String getDld_lookup_meaning() {
		return dld_lookup_meaning;
	}

	@Column(name = "DLD_SORT_ORDER", nullable = false)
	public BigDecimal getDld_sort_order() {
		return dld_sort_order;
	}

	@Column(name = "DLD_LAST_MODIFIED")
	public Timestamp getDld_last_modified() {
		return dld_last_modified;
	}

	@Column(name = "DLD_SYSTEM_FLAG", length = 1, nullable = false)
	public String getDld_system_flag() {
		return dld_system_flag;
	}

	public void setDld_lookup_meaning(String dld_lookup_meaning) {
		this.dld_lookup_meaning = dld_lookup_meaning;
	}

	public void setDld_sort_order(BigDecimal dld_sort_order) {
		this.dld_sort_order = dld_sort_order;
	}

	public void setDld_last_modified(Timestamp dld_last_modified) {
		this.dld_last_modified = dld_last_modified;
	}

	public void setDld_system_flag(String dld_system_flag) {
		this.dld_system_flag = dld_system_flag;
	}

	public void setBas_Lookup_Details_PK(Bas_Lookup_Details_PK bas_Lookup_Details_PK) {
		this.bas_Lookup_Details_PK = bas_Lookup_Details_PK;
	}

}
