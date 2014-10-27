package com.cc.ccadmin.dao.admin;

import java.io.Serializable;

import com.cc.ccadmin.dao.IGenericDao;
import com.cc.ccadmin.exception.DaoException;
import com.cc.ccadmin.model.IBaseModel;

public interface IGroupDao <T extends IBaseModel, ID extends Serializable> extends IGenericDao<T , ID>{

	public void delete_group_by_code(String user_code) throws DaoException;
	public String save_group_permission_json(String group_code, String json)throws DaoException;
	public void delete_group_permission(String group_code, String permission_code)throws DaoException;
}
