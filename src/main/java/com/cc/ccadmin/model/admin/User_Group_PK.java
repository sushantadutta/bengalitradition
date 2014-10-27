package com.cc.ccadmin.model.admin;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.cc.ccadmin.model.IBaseModel;

@SuppressWarnings("serial")
@Embeddable
public class User_Group_PK implements IBaseModel {

	private ADM_USER user;
	private ADM_GROUP group;

	@ManyToOne
	public ADM_USER getUser() {
		return user;
	}

	@ManyToOne
	public ADM_GROUP getGroup() {
		return group;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		User_Group_PK that = (User_Group_PK) o;

		if (user != null ? !user.equals(that.user) : that.user != null)
			return false;
		if (group != null ? !group.equals(that.group) : that.group != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = (user != null ? user.hashCode() : 0);
		result = 31 * result + (group != null ? group.hashCode() : 0);
		return result;
	}

	/*
	 * setters
	 */
	public void setUser(ADM_USER user) {
		this.user = user;
	}

	public void setGroup(ADM_GROUP group) {
		this.group = group;
	}
}
