package com.cc.ccadmin.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cc.ccadmin.dao.AbstractGenericDao;
import com.cc.ccadmin.dao.admin.IUserDao;
import com.cc.ccadmin.exception.DaoException;
import com.cc.ccadmin.model.admin.ADM_USER;

@Repository
public class UserDaoImpl extends AbstractGenericDao<ADM_USER, String> implements
		IUserDao<ADM_USER, String> {

	public UserDaoImpl() {
		super();
	}

	@Override
	public void delete_user_by_code(String user_code) throws DaoException {
		try {
			ADM_USER adm_USER = findById(user_code);
			try {
				//System.out.println("password"+PasswordService.decrypt(adm_USER.getPassword()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			delete(adm_USER);
		} catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		}

	}

	@Override
	public void save(ADM_USER t) throws DaoException {
		try {
//			t.setPassword(PasswordService.encrypt(t.getAus_password()));
			super.save(t);
		} catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		} catch (Exception e) {
			throw new DaoException(e.getCause());
		}
	}

	@Override
	public ADM_USER findById(String id) throws DaoException {

		try {
			ADM_USER adm_USER = super.findById(id);

//			adm_USER.setAus_password(PasswordService.decrypt(adm_USER.getPassword()));
			return adm_USER;
		} catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		} catch (Exception e) {
			throw new DaoException(e.getCause());
		}

	}

}
