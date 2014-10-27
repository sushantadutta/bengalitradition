package com.cc.ccadmin.util;

import java.io.Serializable;
import java.util.Map;

import com.cc.ccadmin.dao.IGenericDao;
import com.cc.ccadmin.model.IBaseModel;

public interface IGenericLookUp<T extends IBaseModel, ID extends Serializable> extends IGenericDao<T , ID>{

	public Map<String, String> getLookups(String lookupname, String frequency,
			String tablename, String columnname);
}
