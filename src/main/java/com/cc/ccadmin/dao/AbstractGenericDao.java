package com.cc.ccadmin.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cc.ccadmin.exception.DaoException;
import com.cc.ccadmin.model.IBaseModel;

public abstract class AbstractGenericDao<T extends IBaseModel, ID extends Serializable> implements
		IGenericDao<T, ID> {

	private SessionFactory sessionFactory;
	private HibernateTemplate hibernateTemplate;
//	public RemoteDao remoteDao;
	private Class<T> persistentClass;
	
//	public RemoteDao getRemoteDao() {
//		return remoteDao;
//	}
//
//	@Autowired
//	public void setRemoteDao(RemoteDao remoteDao) {
//		this.remoteDao = remoteDao;
//	}

	

	@Autowired
	public final void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		hibernateTemplate = new HibernateTemplate(this.sessionFactory);
	}

	@SuppressWarnings("unchecked")
	public AbstractGenericDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected final HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Override
	public T findById(ID id) throws DaoException {
		try{
			return getHibernateTemplate().get(getPersistentClass(), id);
		}catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() throws DaoException {
		try{
			return getHibernateTemplate().find(
					"from " + getPersistentClass().getName());
		}catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		}
		
		
	}

	@Override
	public void save(T t) throws DaoException {
		try{
			getHibernateTemplate().save(t);
		}catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		}
		
	}

	@Override
	public void update(T t) throws DaoException {
		try{
			getHibernateTemplate().update(t);
		}catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		}
		
	}

	@Override
	public void delete(T t) throws DaoException {
		try{
			getHibernateTemplate().delete(t);
		}catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		}
		
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	@Override
	public void deleteAll() throws DaoException {
		try {
			getHibernateTemplate().deleteAll(
					getHibernateTemplate().findByExample(
							getPersistentClass().getName()));
		} catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		}
	}

	@Override
	public Integer count() throws DaoException {
		try {
			return getHibernateTemplate().findByExample(
					getPersistentClass().getName()).size();
		} catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		}
	}

}
