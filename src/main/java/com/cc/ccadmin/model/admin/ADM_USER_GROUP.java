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
@Table(name = "ADM_USER_GROUPS")
@AssociationOverrides({
		@AssociationOverride(name = "pk.user", joinColumns = @JoinColumn(name = "AUG_AUS_USERNAME")),
		@AssociationOverride(name = "pk.group", joinColumns = @JoinColumn(name = "AUG_AGR_CODE")) })
public class ADM_USER_GROUP implements IBaseModel {

	private String aug_delete_flag;
	private String aug_create_user;
	private Date aug_create_date;
	private String aug_update_user;
	private Date aug_update_date;
	private Timestamp aug_last_modified;
	private User_Group_PK pk = new User_Group_PK();

	@EmbeddedId
	public User_Group_PK getPk() {
		return pk;
	}

	@Transient
	public ADM_USER getUser() {
		return getPk().getUser();
	}

	public void setUser(ADM_USER adm_USER) {
		getPk().setUser(adm_USER);
	}

	@Transient
	public ADM_GROUP getGroup() {
		return getPk().getGroup();
	}

	public void setGroup(ADM_GROUP adm_GROUP) {
		getPk().setGroup(adm_GROUP);
	}

	@Column(name = "AUG_DELETE_FLAG", length = 1)
	public String getAug_delete_flag() {
		return aug_delete_flag;
	}

	@Column(name = "AUG_CREATE_USER", length = 30, nullable = false)
	public String getAug_create_user() {
		return aug_create_user;
	}

	@Column(name = "AUG_CREATE_DATE", nullable = false)
	public Date getAug_create_date() {
		return aug_create_date;
	}

	@Column(name = "AUG_UPDATE_USER", length = 30)
	public String getAug_update_user() {
		return aug_update_user;
	}

	@Column(name = "AUG_UPDATE_DATE")
	public Date getAug_update_date() {
		return aug_update_date;
	}

	@Column(name = "AUG_LAST_MODIFIED", nullable = false)
	public Timestamp getAug_last_modified() {
		return aug_last_modified;
	}

	/*
	 * setters
	 */

	public void setAug_delete_flag(String aug_delete_flag) {
		this.aug_delete_flag = aug_delete_flag;
	}

	public void setAug_create_user(String aug_create_user) {
		this.aug_create_user = aug_create_user;
	}

	public void setAug_create_date(Date aug_create_date) {
		this.aug_create_date = aug_create_date;
	}

	public void setAug_update_user(String aug_update_user) {
		this.aug_update_user = aug_update_user;
	}

	public void setAug_update_date(Date aug_update_date) {
		this.aug_update_date = aug_update_date;
	}

	public void setAug_last_modified(Timestamp aug_last_modified) {
		this.aug_last_modified = aug_last_modified;
	}

	public void setPk(User_Group_PK pk) {
		this.pk = pk;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ADM_USER_GROUP that = (ADM_USER_GROUP) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
}
