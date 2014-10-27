package com.cc.ccadmin.dao.admin;

import java.io.Serializable;

import com.cc.ccadmin.dao.IGenericDao;
import com.cc.ccadmin.exception.DaoException;
import com.cc.ccadmin.model.IBaseModel;

public interface ILookupDao <T extends IBaseModel, ID extends Serializable> extends IGenericDao<T , ID>{

	public void delete_by_name(String lookup_name)throws DaoException;
	public void bulk_insert_lookup()throws DaoException;
	public void bulk_insert_lookup_details()throws DaoException;
}
