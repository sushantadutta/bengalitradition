package com.cc.ccadmin.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cc.ccadmin.dao.AbstractGenericDao;
import com.cc.ccadmin.dao.admin.IUserGroupDao;
import com.cc.ccadmin.exception.DaoException;
import com.cc.ccadmin.model.admin.ADM_USER_GROUP;

@Repository
public class UserGroupDaoImpl extends
		AbstractGenericDao<ADM_USER_GROUP, String> implements
		IUserGroupDao<ADM_USER_GROUP, String> {

	public UserGroupDaoImpl() {

	}

	@Override
	public void delete_user_group(String user_code, String group_code)
			throws DaoException {

		try {
			getHibernateTemplate()
					.bulkUpdate(
							"delete from ADM_USER_GROUP aug where aug.pk.user.aus_user_name=? and aug.pk.group.agr_code=?",
							user_code, group_code);
		} catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		}

	}

}
