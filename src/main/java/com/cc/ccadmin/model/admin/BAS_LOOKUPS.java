package com.cc.ccadmin.model.admin;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
@Table(name = "BAS_LOOKUPS")
public class BAS_LOOKUPS implements IBaseModel {

	private String dlk_lookup_name;
	private String dlk_lookup_type;
	private String dlk_lookup_table;
	private String dlk_where_clause;
	private String dlk_order_by;
	private String dlk_create_user;
	private Date dlk_create_date;
	private String dlk_update_user;
	private Date dlk_update_date;
	private String dlk_module_code;
	private String dlk_system_flag;
	private Timestamp dlk_last_modified;
	private String dlk_description;
	private Set<BAS_LOOKUP_DETAILS> bas_LOOKUP_DETAILSs = new HashSet<BAS_LOOKUP_DETAILS>();

	@Column(name="DLK_DESCRIPTION",length=60,nullable=false)
	public String getDlk_description() {
		return dlk_description;
	}

	public void setDlk_description(String dlk_description) {
		this.dlk_description = dlk_description;
	}




	@Column(name="DLK_LAST_MODIFIED",nullable=true)
	public Timestamp getDlk_last_modified() {
		return dlk_last_modified;
	}

	public void setDlk_last_modified(Timestamp dlk_last_modified) {
		this.dlk_last_modified = dlk_last_modified;
	}
	@Id
	@Column(name = "DLK_LOOKUP_NAME", length = 30, nullable = false)
	public String getDlk_lookup_name() {
		return dlk_lookup_name;
	}

	@Column(name = "DLK_LOOKUP_TYPE", length = 1, nullable = false)
	public String getDlk_lookup_type() {
		return dlk_lookup_type;
	}

	@Column(name = "DLK_LOOKUP_TABLE", length = 30)
	public String getDlk_lookup_table() {
		return dlk_lookup_table;
	}

	@Column(name = "DLK_WHERE_CLAUSE", length = 2000)
	public String getDlk_where_clause() {
		return dlk_where_clause;
	}

	@Column(name = "DLK_ORDER_BY", length = 200)
	public String getDlk_order_by() {
		return dlk_order_by;
	}

	@Column(name = "DLK_CREATE_USER", length = 30, nullable = false)
	public String getDlk_create_user() {
		return dlk_create_user;
	}

	@Column(name = "DLK_CREATE_DATE", nullable = false)
	public Date getDlk_create_date() {
		return dlk_create_date;
	}

	@Column(name = "DLK_UPDATE_USER", length = 30)
	public String getDlk_update_user() {
		return dlk_update_user;
	}

	@Column(name = "DLK_UPDATE_DATE")
	public Date getDlk_update_date() {
		return dlk_update_date;
	}

	@Column(name = "DLK_MODULE_CODE", length = 10)
	public String getDlk_module_code() {
		return dlk_module_code;
	}

	@Column(name = "DLK_SYSTEM_FLAG", length = 1, nullable = false)
	public String getDlk_system_flag() {
		return dlk_system_flag;
	}
	@OrderBy(value="dld_sort_order")
	@BatchSize(size=50)
	@Fetch(FetchMode.JOIN)
	@OneToMany(orphanRemoval = true, targetEntity = com.cc.ccadmin.model.admin.BAS_LOOKUP_DETAILS.class/*, cascade = CascadeType.ALL, fetch = FetchType.EAGER*/)
	@JoinColumn(name="DLD_DLK_LOOKUP_NAME", referencedColumnName="DLK_LOOKUP_NAME")
	public Set<BAS_LOOKUP_DETAILS> getBas_LOOKUP_DETAILSs() {
		return bas_LOOKUP_DETAILSs;
	}
	/*
	 * setters
	 */
	public void setDlk_lookup_name(String dlk_lookup_name) {
		this.dlk_lookup_name = dlk_lookup_name;
	}

	public void setDlk_lookup_type(String dlk_lookup_type) {
		this.dlk_lookup_type = dlk_lookup_type;
	}

	public void setDlk_lookup_table(String dlk_lookup_table) {
		this.dlk_lookup_table = dlk_lookup_table;
	}

	public void setDlk_where_clause(String dlk_where_clause) {
		this.dlk_where_clause = dlk_where_clause;
	}

	public void setDlk_order_by(String dlk_order_by) {
		this.dlk_order_by = dlk_order_by;
	}

	public void setDlk_create_user(String dlk_create_user) {
		this.dlk_create_user = dlk_create_user;
	}

	public void setDlk_create_date(Date dlk_create_date) {
		this.dlk_create_date = dlk_create_date;
	}

	public void setDlk_update_user(String dlk_update_user) {
		this.dlk_update_user = dlk_update_user;
	}

	public void setDlk_update_date(Date dlk_update_date) {
		this.dlk_update_date = dlk_update_date;
	}

	public void setDlk_module_code(String dlk_module_code) {
		this.dlk_module_code = dlk_module_code;
	}

	public void setDlk_system_flag(String dlk_system_flag) {
		this.dlk_system_flag = dlk_system_flag;
	}

	public void setBas_LOOKUP_DETAILSs(
			Set<BAS_LOOKUP_DETAILS> bas_LOOKUP_DETAILSs) {
		this.bas_LOOKUP_DETAILSs = bas_LOOKUP_DETAILSs;
	}

}
