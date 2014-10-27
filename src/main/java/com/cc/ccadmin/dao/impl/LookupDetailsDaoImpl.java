package com.cc.ccadmin.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cc.ccadmin.dao.AbstractGenericDao;
import com.cc.ccadmin.dao.admin.ILookupDetailsDao;
import com.cc.ccadmin.exception.DaoException;
import com.cc.ccadmin.model.admin.BAS_LOOKUP_DETAILS;

@Repository
public class LookupDetailsDaoImpl extends
		AbstractGenericDao<BAS_LOOKUP_DETAILS, String> implements
		ILookupDetailsDao<BAS_LOOKUP_DETAILS, String> {

	public LookupDetailsDaoImpl() {

	}

	@SuppressWarnings("unchecked")
	public BAS_LOOKUP_DETAILS findByCode(String lookupcode, String lookupname)
			throws DaoException {
		try {
			List<BAS_LOOKUP_DETAILS> lookupdet = getHibernateTemplate()
					.find("from BAS_LOOKUP_DETAILS e where e.bas_Lookup_Details_PK.dld_lookup_code=? and e.bas_Lookup_Details_PK.dld_dlk_lookup_name=?",
							lookupcode, lookupname);
			if (lookupdet.isEmpty()) {
				return null;
			} else {
				return lookupdet.get(0);
			}
		} catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		}

	}

	@Override
	public void editLookupDetails(BAS_LOOKUP_DETAILS lookupDetails,
			String lookupcode, String lookupname) throws DaoException {

		lookupDetails.setDld_last_modified(new Timestamp(new Date().getTime()));
		lookupDetails.setDld_system_flag("N");
		lookupDetails.getBas_Lookup_Details_PK().setDld_dlk_lookup_name(
				lookupname);
		try {
			getHibernateTemplate().update(lookupDetails);
		} catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		}

	}

	@Override
	public void deleteLookupDetail(String lookupcode, String lookupname)
			throws DaoException {
		try {
			getHibernateTemplate()
					.bulkUpdate(
							"delete from BAS_LOOKUP_DETAILS e where e.bas_Lookup_Details_PK.dld_lookup_code=? and e.bas_Lookup_Details_PK.dld_dlk_lookup_name=?",
							lookupcode, lookupname);
		} catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		}
	}

}
