package com.cc.ccadmin.dao.admin;

import java.io.Serializable;

import com.cc.ccadmin.dao.IGenericDao;
import com.cc.ccadmin.exception.DaoException;
import com.cc.ccadmin.model.IBaseModel;

public interface IUserDao<T extends IBaseModel, ID extends Serializable> extends IGenericDao<T , ID>{

		public void delete_user_by_code(String user_code)throws DaoException;
		
}
