package com.cc.ccadmin.model.admin;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.cc.ccadmin.model.IBaseModel;

@SuppressWarnings("serial")
@Entity
@Table(name = "ADM_MODULES")
public class ADM_MODULES implements IBaseModel {

	private String amd_code;
	private String amd_short_name;
	private String amd_long_name;
	private String amd_url;
	private String amd_description;
	private String amd_javascript;
	private String amd_icon_file;
	private Integer amd_short_order;
	private Set<ADM_PERMISSIONS> adm_PERMISSIONSs = new HashSet<ADM_PERMISSIONS>(0);

	@Id
	@Column(name = "AMD_CODE", length = 15, nullable = false)
	public String getAmd_code() {
		return amd_code;
	}

	@Column(name = "AMD_SHORT_NAME", length = 60, nullable = false)
	public String getAmd_short_name() {
		return amd_short_name;
	}

	@Column(name = "AMD_LONG_NAME", length = 120)
	public String getAmd_long_name() {
		return amd_long_name;
	}

	@Column(name = "AMD_URL", length = 2000)
	public String getAmd_url() {
		return amd_url;
	}

	@Column(name = "AMD_DESCRIPTION", length = 2000)
	public String getAmd_description() {
		return amd_description;
	}

	@Column(name = "AMD_JAVASCRIPT", length = 2000)
	public String getAmd_javascript() {
		return amd_javascript;
	}

	@Column(name = "AMD_ICON_FILE", length = 30)
	public String getAmd_icon_file() {
		return amd_icon_file;
	}

	@Column(name = "AMD_SORT_ORDER")
	public Integer getAmd_short_order() {
		return amd_short_order;
	}
	@BatchSize(size=20)
	@Fetch(FetchMode.JOIN)
	@OneToMany(orphanRemoval = true, targetEntity = com.cc.ccadmin.model.admin.ADM_PERMISSIONS.class, mappedBy = "adm_MODULES"/*, cascade = CascadeType.ALL, fetch = FetchType.EAGER*/)
	public Set<ADM_PERMISSIONS> getAdm_PERMISSIONSs() {
		return adm_PERMISSIONSs;
	}

	/*
	 * setters
	 */

	public void setAmd_code(String amd_code) {
		this.amd_code = amd_code;
	}

	public void setAmd_short_name(String amd_short_name) {
		this.amd_short_name = amd_short_name;
	}

	public void setAmd_long_name(String amd_long_name) {
		this.amd_long_name = amd_long_name;
	}

	public void setAmd_url(String amd_url) {
		this.amd_url = amd_url;
	}

	public void setAmd_description(String amd_description) {
		this.amd_description = amd_description;
	}

	public void setAmd_javascript(String amd_javascript) {
		this.amd_javascript = amd_javascript;
	}

	public void setAmd_icon_file(String amd_icon_file) {
		this.amd_icon_file = amd_icon_file;
	}

	public void setAmd_short_order(Integer amd_short_order) {
		this.amd_short_order = amd_short_order;
	}

	public void setAdm_PERMISSIONSs(Set<ADM_PERMISSIONS> adm_PERMISSIONSs) {
		this.adm_PERMISSIONSs = adm_PERMISSIONSs;
	}
}
