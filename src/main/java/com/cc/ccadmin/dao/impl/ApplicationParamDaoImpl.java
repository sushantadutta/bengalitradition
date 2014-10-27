package com.cc.ccadmin.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cc.ccadmin.dao.AbstractGenericDao;
import com.cc.ccadmin.dao.admin.IApplicationParamDao;
import com.cc.ccadmin.exception.DaoException;
import com.cc.ccadmin.model.admin.BAS_APPLICATION_PARAMETERS;

@Repository
public class ApplicationParamDaoImpl extends
		AbstractGenericDao<BAS_APPLICATION_PARAMETERS, String> implements
		IApplicationParamDao<BAS_APPLICATION_PARAMETERS, String> {

//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	public void bulk_insert_applications() throws DaoException {
//		String sql = "select * from BAS_APPLICATIONS";
//		try {
//			JdbcTemplate jdbcTemplate = getRemoteDao()
//					.getdataSourceSpecificJdbcTemplate("CC_SINGLE_VIEW_DS");
//			List<BAS_APPLICATIONS> bas_application = jdbcTemplate.query(sql,
//					new BeanPropertyRowMapper(BAS_APPLICATIONS.class));
//			getHibernateTemplate().saveOrUpdateAll(bas_application);
//		} catch (DataAccessException ex) {
//			throw new DaoException(ex.getRootCause());
//		}
//
//	}

//	@SuppressWarnings("rawtypes")
//	public void bulk_insert_app_parameters() throws DaoException {
//		String sql = "select * from BAS_APPLICATION_PARAMETERS";
//		try {
//			JdbcTemplate jdbcTemplate = getRemoteDao()
//					.getdataSourceSpecificJdbcTemplate("CC_SINGLE_VIEW_DS");
//
//			List<BAS_APPLICATION_PARAMETERS> bas_APPLICATION_PARAMETERSs = new ArrayList<BAS_APPLICATION_PARAMETERS>();
//			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
//			for (Map row : rows) {
//				BAS_APPLICATION_PARAMETERS bas_app_param = new BAS_APPLICATION_PARAMETERS();
//
//				bas_app_param.setCarp_desc((String) row.get("CAPR_DESC"));
//				bas_app_param.setCarp_last_modified((Timestamp) row
//						.get("CAPR_LAST_MODIFIED"));
//				bas_app_param.setCarp_module_code((String) row
//						.get("CAPR_MODULE_CODE"));
//				bas_app_param.setCarp_param_type((String) row
//						.get("CAPR_PRAM_TYPE"));
//				bas_app_param.setCarp_param_values((String) row
//						.get("CAPR_PARAM_VALUE"));
//				bas_app_param.setCarp_short_desc((String) row
//						.get("CAPR_SHORT_DESC"));
//				bas_app_param.setCarp_possible_values((String) row
//						.get("CAPR_POSSIBLE_VALUES"));
//				bas_app_param.setCarp_sys_param_flag((String) row
//						.get("CAPR_SYS_PARAM_FLG"));
//				bas_app_param.setCarp_update_date((Date) row
//						.get("CAPR_UPDATE_DATE"));
//				bas_app_param.setCarp_update_user((String) row
//						.get("CAPR_UPDATE_USER"));
//				bas_app_param.getApplication_Parameter_PK().setCarp_app_code(
//						(String) row.get("CAPR_APP_CODE"));
//				bas_app_param.getApplication_Parameter_PK().setCarp_param_name(
//						(String) row.get("CAPR_PARAM_NAME"));
//
//				bas_APPLICATION_PARAMETERSs.add(bas_app_param);
//			}
//			getHibernateTemplate().saveOrUpdateAll(bas_APPLICATION_PARAMETERSs);
//		} catch (DataAccessException ex) {
//			throw new DaoException(ex.getRootCause());
//		}
//
//	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BAS_APPLICATION_PARAMETERS> findAll() throws DaoException {
		try {
			return getHibernateTemplate().find(
					"from BAS_APPLICATION_PARAMETERS");
		} catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		}

	}

	public void editAppParameterVal(BAS_APPLICATION_PARAMETERS appParamName,
			String appCode, String paramName) throws DaoException {

		Transaction tx = null;
		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("update BAS_APPLICATION_PARAMETERS set carp_param_values =:carp_param_values,carp_last_modified =:carp_last_modified where application_Parameter_PK.carp_app_code=:carp_app_code and application_Parameter_PK.carp_param_name =:carp_param_name");
			query.setParameter("carp_param_values",
					appParamName.getCarp_param_values());
			query.setParameter("carp_last_modified",
					appParamName.getCarp_last_modified());
			query.setParameter("carp_app_code", appCode);
			query.setParameter("carp_param_name", paramName);
			int result = query.executeUpdate();
			session.flush();
			tx.commit();

		} catch (DataAccessException he) {
			tx.rollback();
			throw new DaoException(he.getRootCause());
		} finally {
			session.close();
		}

	}

	@Override
	public String updateAppParamVal(String json) throws DaoException {
		BAS_APPLICATION_PARAMETERS appParamName = null;
		try {
			JSONObject jsonObject = new JSONObject(json);
			JSONArray jsonArray = jsonObject.getJSONArray("updateAppParamVal");
			int length = jsonArray.length();
			for (int i = 0; i < length; i++) {
				JSONObject jsonObject1 = jsonArray.getJSONObject(i);
				appParamName = new BAS_APPLICATION_PARAMETERS();
				String caprAppCode = jsonObject1.getString("param_code");
				String caprParamName = jsonObject1.getString("paramName");
				appParamName.setCarp_last_modified(new Timestamp(new Date()
						.getTime()));
				appParamName.setCarp_param_values(jsonObject1
						.getString("param_value"));
				editAppParameterVal(appParamName, caprAppCode, caprParamName);

			}
			return "{success:true}";
		} catch (JSONException e) {
			return "{success:false}";
		} catch (DataAccessException he) {
			throw new DaoException(he.getRootCause());
		}
	}

	@Override
	public void bulk_insert_applications() throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bulk_insert_app_parameters() throws DaoException {
		// TODO Auto-generated method stub
		
	}
}
