package com.cc.ccadmin.dao.admin;

import java.io.Serializable;

import com.cc.ccadmin.dao.IGenericDao;
import com.cc.ccadmin.exception.DaoException;
import com.cc.ccadmin.model.IBaseModel;
import com.cc.ccadmin.model.admin.BAS_APPLICATION_PARAMETERS;

public interface IApplicationParamDao <T extends IBaseModel, ID extends Serializable> extends IGenericDao<T , ID>{
	
	public void bulk_insert_applications() throws DaoException;
	public void bulk_insert_app_parameters() throws DaoException;
	public String updateAppParamVal(String json) throws DaoException;
	public void editAppParameterVal(BAS_APPLICATION_PARAMETERS appParamName,String appCode,String paramName) throws DaoException;
	

}
