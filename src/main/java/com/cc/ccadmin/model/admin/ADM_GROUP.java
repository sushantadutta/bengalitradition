package com.cc.ccadmin.model.admin;

import java.sql.Timestamp;
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
@Table(name = "ADM_GROUPS")
public class ADM_GROUP implements IBaseModel {

	private String agr_code;
	private String agr_short_name;
	private String agr_long_name;
	private String agr_system_flag;
	private String agr_delete_flag;
	private Timestamp agr_last_modified;

	private Set<ADM_USER_GROUP> adm_USER_GROUPs = new HashSet<ADM_USER_GROUP>(0);
	private Set<ADM_GROUP_PERMISSIONS> adm_GROUP_PERMISSIONSs = new HashSet<ADM_GROUP_PERMISSIONS>(0);

	@Id
	@Column(name = "AGR_CODE", length = 20, nullable = false)
	public String getAgr_code() {
		return agr_code;
	}

	@Column(name = "AGR_SHORT_NAME", length = 60, nullable = false)
	public String getAgr_short_name() {
		return agr_short_name;
	}

	@Column(name = "AGR_LONG_NAME", length = 120, nullable = false)
	public String getAgr_long_name() {
		return agr_long_name;
	}

	@Column(name = "AGR_SYSTEM_FLAG", length = 1)
	public String getAgr_system_flag() {
		return agr_system_flag;
	}

	@Column(name = "AGR_DELETE_FLAG", length = 1)
	public String getAgr_delete_flag() {
		return agr_delete_flag;
	}

	@Column(name = "AGR_LAST_MODIFIED", length = 6, nullable = false)
	public Timestamp getAgr_last_modified() {
		return agr_last_modified;
	}
	@BatchSize(size=20)
	@Fetch(FetchMode.JOIN)
	@OneToMany(/*fetch = FetchType.EAGER,*/ mappedBy = "pk.group")
	public Set<ADM_USER_GROUP> getAdm_USER_GROUPs() {
		return adm_USER_GROUPs;
	}
	@BatchSize(size=20)
	@Fetch(FetchMode.JOIN)
	@OneToMany(orphanRemoval=true,/*fetch = FetchType.EAGER,*/ mappedBy = "pk.group"/*,cascade = {CascadeType.ALL}*/)
	//@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	public Set<ADM_GROUP_PERMISSIONS> getAdm_GROUP_PERMISSIONSs() {
		return adm_GROUP_PERMISSIONSs;
	}

	/* setters */
	public void setAgr_code(String agr_code) {
		this.agr_code = agr_code;
	}

	public void setAgr_short_name(String agr_short_name) {
		this.agr_short_name = agr_short_name;
	}

	public void setAgr_long_name(String agr_long_name) {
		this.agr_long_name = agr_long_name;
	}

	public void setAgr_system_flag(String agr_system_flag) {
		this.agr_system_flag = agr_system_flag;
	}

	public void setAgr_delete_flag(String agr_delete_flag) {
		this.agr_delete_flag = agr_delete_flag;
	}

	public void setAgr_last_modified(Timestamp agr_last_modified) {
		this.agr_last_modified = agr_last_modified;
	}

	public void setAdm_USER_GROUPs(Set<ADM_USER_GROUP> adm_USER_GROUPs) {
		this.adm_USER_GROUPs = adm_USER_GROUPs;
	}

	public void setAdm_GROUP_PERMISSIONSs(
			Set<ADM_GROUP_PERMISSIONS> adm_GROUP_PERMISSIONSs) {
		this.adm_GROUP_PERMISSIONSs = adm_GROUP_PERMISSIONSs;
	}
}
