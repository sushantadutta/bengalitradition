package com.cc.ccadmin.dao;

import java.io.Serializable;
import java.util.List;

import com.cc.ccadmin.exception.DaoException;
import com.cc.ccadmin.model.IBaseModel;

public interface IGenericDao<T extends IBaseModel, ID extends Serializable> {

	public T findById(ID id) throws DaoException;

	public List<T> findAll()throws DaoException;

	public void save(T t)throws DaoException;

	public void update(T t)throws DaoException;

	public void delete(T t)throws DaoException;

	public void deleteAll()throws DaoException;

	public Integer count()throws DaoException;
}
