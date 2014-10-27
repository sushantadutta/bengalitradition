package com.cc.ccadmin.dao.admin;

import java.io.Serializable;

import com.cc.ccadmin.dao.IGenericDao;
import com.cc.ccadmin.exception.DaoException;
import com.cc.ccadmin.model.IBaseModel;

public interface IUserGroupDao <T extends IBaseModel, ID extends Serializable> extends IGenericDao<T , ID>{

	public void delete_user_group(String user_code, String group_code)throws DaoException;
}
