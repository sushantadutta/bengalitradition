package com.cc.ccadmin.dao.admin;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.cc.ccadmin.dao.IGenericDao;
import com.cc.ccadmin.exception.DaoException;
import com.cc.ccadmin.model.IBaseModel;
import com.cc.ccadmin.model.admin.TAR_SYS_DICTIONARY_COLS;

public interface ITableCatalogDao <T extends IBaseModel, ID extends Serializable> extends IGenericDao<T , ID>{
		
	public void save_specific(T t)throws DaoException;
	public void delete_by_id(String table_name)throws DaoException;
	public List<Object> getTableNamesSpecificToDataSource(String dataSourceName)throws DaoException;
	public void editSysDictionaryCols(TAR_SYS_DICTIONARY_COLS sysDictionaryCols,String tableName,String columnName)throws DaoException;
	public void update_column_details(String json_data, String table_name)throws DaoException;
	public Map<String, String> add_column_details_to_catalog(String table_name)throws DaoException;
	public void deleteSysDictionaryCol(String tableName,String columnName)throws DaoException;
}
