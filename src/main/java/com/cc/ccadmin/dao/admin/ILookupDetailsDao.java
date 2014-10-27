package com.cc.ccadmin.dao.admin;

import java.io.Serializable;

import com.cc.ccadmin.dao.IGenericDao;
import com.cc.ccadmin.exception.DaoException;
import com.cc.ccadmin.model.IBaseModel;
import com.cc.ccadmin.model.admin.BAS_LOOKUP_DETAILS;

public interface ILookupDetailsDao <T extends IBaseModel, ID extends Serializable> extends IGenericDao<T , ID>{
	
	public BAS_LOOKUP_DETAILS findByCode(String lookupcode, String lookupname)throws DaoException;
	public void editLookupDetails(BAS_LOOKUP_DETAILS lookupDetails,String lookupcode,String lookupname)throws DaoException;
	public void deleteLookupDetail(String lookupcode,String lookupname)throws DaoException;

}
