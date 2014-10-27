package com.cc.ccadmin.model.admin;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cc.ccadmin.model.IBaseModel;

@SuppressWarnings("serial")
@Entity
@Table(name = "ADM_GROUP_PERMISSIONS")
@AssociationOverrides({
		@AssociationOverride(name = "pk.group", joinColumns = @JoinColumn(name = "AGP_AGR_CODE")),
		@AssociationOverride(name = "pk.permissions", joinColumns = @JoinColumn(name = "AGP_APN_CODE")) })
public class ADM_GROUP_PERMISSIONS implements IBaseModel {

	private String agp_delete_flag;
	private String agp_create_user;
	private Date agp_create_date;
	private String agp_update_user;
	private Date agp_update_date;
	private Timestamp agp_last_modified;
	private Group_Permission_PK pk = new Group_Permission_PK();

	@EmbeddedId
	public Group_Permission_PK getPk() {
		return pk;
	}

	@Transient
	public ADM_GROUP getGroup() {
		return getPk().getGroup();
	}

	public void setItem(ADM_GROUP adm_GROUP) {
		getPk().setGroup(adm_GROUP);
	}

	@Transient
	public ADM_PERMISSIONS getPermissions() {
		return getPk().getPermissions();
	}

	public void setPermissions(ADM_PERMISSIONS adm_PERMISSIONS) {
		getPk().setPermissions(adm_PERMISSIONS);
	}

	@Column(name = "AGP_DELETE_FLAG", length = 1, nullable = false)
	public String getAgp_delete_flag() {
		return agp_delete_flag;
	}

	@Column(name = "AGP_CREATE_USER", length = 30)
	public String getAgp_create_user() {
		return agp_create_user;
	}

	@Column(name = "AGP_CREATE_DATE")
	public Date getAgp_create_date() {
		return agp_create_date;
	}

	@Column(name = "AGP_UPDATE_USER", length = 30)
	public String getAgp_update_user() {
		return agp_update_user;
	}

	@Column(name = "AGP_UPDATE_DATE")
	public Date getAgp_update_date() {
		return agp_update_date;
	}

	@Column(name = "AGP_LAST_MODIFIED")
	public Timestamp getAgp_last_modified() {
		return agp_last_modified;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ADM_GROUP_PERMISSIONS that = (ADM_GROUP_PERMISSIONS) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}

	public void setAgp_delete_flag(String agp_delete_flag) {
		this.agp_delete_flag = agp_delete_flag;
	}

	public void setAgp_create_user(String agp_create_user) {
		this.agp_create_user = agp_create_user;
	}

	public void setAgp_create_date(Date agp_create_date) {
		this.agp_create_date = agp_create_date;
	}

	public void setAgp_update_user(String agp_update_user) {
		this.agp_update_user = agp_update_user;
	}

	public void setAgp_update_date(Date agp_update_date) {
		this.agp_update_date = agp_update_date;
	}

	public void setAgp_last_modified(Timestamp agp_last_modified) {
		this.agp_last_modified = agp_last_modified;
	}

	public void setPk(Group_Permission_PK pk) {
		this.pk = pk;
	}

}
