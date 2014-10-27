package com.cc.ccadmin.model.admin;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.cc.ccadmin.model.IBaseModel;

@SuppressWarnings("serial")
@Embeddable
public class Group_Permission_PK implements IBaseModel {

	private ADM_GROUP group;
	private ADM_PERMISSIONS permissions;

	@ManyToOne
	public ADM_GROUP getGroup() {
		return group;
	}

	@ManyToOne
	public ADM_PERMISSIONS getPermissions() {
		return permissions;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Group_Permission_PK that = (Group_Permission_PK) o;

		if (group != null ? !group.equals(that.group) : that.group != null)
			return false;
		if (permissions != null ? !permissions.equals(that.permissions)
				: that.permissions != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = (group != null ? group.hashCode() : 0);
		result = 31 * result
				+ (permissions != null ? permissions.hashCode() : 0);
		return result;
	}

	
	 
	public void setGroup(ADM_GROUP group) {
		this.group = group;
	}

	public void setPermissions(ADM_PERMISSIONS permissions) {
		this.permissions = permissions;
	}

}
