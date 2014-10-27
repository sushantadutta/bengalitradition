package com.cc.ccadmin.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cc.ccadmin.dao.AbstractGenericDao;
import com.cc.ccadmin.dao.admin.ILookupDao;
import com.cc.ccadmin.exception.DaoException;
import com.cc.ccadmin.model.admin.BAS_LOOKUPS;

@Repository
public class LookUpDaoImpl extends AbstractGenericDao<BAS_LOOKUPS, String>
		implements ILookupDao<BAS_LOOKUPS, String> {

	public LookUpDaoImpl() {
		super();
	}

	@Override
	public void delete_by_name(String lookup_name) throws DaoException {
		try {
			getHibernateTemplate()
					.bulkUpdate(
							"delete from BAS_LOOKUPS bas_l where bas_l.dlk_lookup_name=?",
							lookup_name);
		} catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		}

	}

//	public void bulk_insert_lookup() throws DaoException {
//		String sql = "select * from ADM_PERMISSIONS";
//		try {
//			JdbcTemplate jdbcTemplate = getRemoteDao()
//					.getdataSourceSpecificJdbcTemplate("CC_SINGLE_VIEW_DS");
//			List<ADM_PERMISSIONS> bas_LOOKUPSs = jdbcTemplate.query(sql,
//					new BeanPropertyRowMapper(ADM_PERMISSIONS.class));
//			getHibernateTemplate().saveOrUpdateAll(bas_LOOKUPSs);
//		} catch (DataAccessException ex) {
//			throw new DaoException(ex.getRootCause());
//		}
//
//	}

//	public void bulk_insert_lookup_details() throws DaoException {
//		String sql = "select * from BAS_LOOKUP_DETAILS";
//
//		try {
//			JdbcTemplate jdbcTemplate = getRemoteDao()
//					.getdataSourceSpecificJdbcTemplate("CC_SINGLE_VIEW_DS");
//
//			List<BAS_LOOKUP_DETAILS> bas_LOOKUP_DETAILSs = new ArrayList<BAS_LOOKUP_DETAILS>();
//			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
//			for (Map row : rows) {
//				BAS_LOOKUP_DETAILS bas_LOOKUP_DETAILS = new BAS_LOOKUP_DETAILS();
//				bas_LOOKUP_DETAILS.setDld_lookup_meaning((String) row
//						.get("DLD_LOOKUP_MEANING"));
//				bas_LOOKUP_DETAILS.setDld_sort_order((BigDecimal) row
//						.get("DLD_SORT_ORDER"));
//				bas_LOOKUP_DETAILS.setDld_system_flag((String) row
//						.get("DLD_SYSTEM_FLAG"));
//				bas_LOOKUP_DETAILS.setDld_last_modified((Timestamp) row
//						.get("DLD_LAST_MODIFIED"));
//				String lookup_name = (String) row.get("DLD_DLK_LOOKUP_NAME");
//				String lookup_code = (String) row.get("DLD_LOOKUP_CODE");
//				bas_LOOKUP_DETAILS.getBas_Lookup_Details_PK()
//						.setDld_dlk_lookup_name(lookup_name);
//				bas_LOOKUP_DETAILS.getBas_Lookup_Details_PK()
//						.setDld_lookup_code(lookup_code);
//				bas_LOOKUP_DETAILSs.add(bas_LOOKUP_DETAILS);
//			}
//			getHibernateTemplate().saveOrUpdateAll(bas_LOOKUP_DETAILSs);
//		} catch (DataAccessException ex) {
//			throw new DaoException(ex.getRootCause());
//		}
//
//	}

	@Override
	public List<BAS_LOOKUPS> findAll() throws DaoException {
		/*
		 * return getHibernateTemplate().find(
		 * "from BAS_LOOKUPS order by dlk_order_by asc");
		 */
		try {
			String queryString = "from BAS_LOOKUPS where dlk_system_flag="
					+ "\'" + "N" + "\'";
			return getHibernateTemplate().find(queryString);
		} catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		}

	}

	@Override
	public void update(BAS_LOOKUPS t) throws DaoException {
		String updateStr = "update BAS_LOOKUPS e set e.dlk_description ="
				+ "\'" + t.getDlk_description() + "\'" + ",e.dlk_lookup_type="
				+ "\'" + t.getDlk_lookup_type() + "\'" + ",e.dlk_lookup_table="
				+ "\'" + t.getDlk_lookup_table() + "\'"
				+ "where e.dlk_where_clause=" + "\'" + t.getDlk_lookup_name()
				+ "\'";
		try {
			getHibernateTemplate().bulkUpdate(updateStr);
		} catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		}

	}

	@Override
	public void bulk_insert_lookup() throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bulk_insert_lookup_details() throws DaoException {
		// TODO Auto-generated method stub
		
	}
}
