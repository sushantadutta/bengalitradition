package com.cc.ccadmin.dao.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cc.ccadmin.dao.AbstractGenericDao;
import com.cc.ccadmin.dao.admin.ITableCatalogDao;
import com.cc.ccadmin.exception.DaoException;
import com.cc.ccadmin.model.admin.TAR_SYSTEM_DICTIONARY;
import com.cc.ccadmin.model.admin.TAR_SYS_DICTIONARY_COLS;

@Repository
public class TableCatalogDaoImpl extends
		AbstractGenericDao<TAR_SYSTEM_DICTIONARY, String> implements
		ITableCatalogDao<TAR_SYSTEM_DICTIONARY, String> {

	@Override
	public List<TAR_SYSTEM_DICTIONARY> findAll() throws DaoException {
		try {
			return super.findAll();
		} catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		}

	}

//	public void save_table_from_remote_ds(TAR_SYSTEM_DICTIONARY t)
//			throws DaoException {
//		String sql = "SELECT COLUMN_NAME, DATA_TYPE, DATA_LENGTH FROM USER_TAB_COLUMNS WHERE TABLE_NAME="
//				+ "'" + t.getTsd_table_name() + "'";
//
//		try {
//			JdbcTemplate jdbcTemplate = getRemoteDao()
//					.getdataSourceSpecificJdbcTemplate(
//							t.getTsd_data_source_name());
//
//			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
//			List<TAR_SYS_DICTIONARY_COLS> list = new ArrayList<TAR_SYS_DICTIONARY_COLS>();
//			int ctr = 1;
//			for (Map row : rows) {
//				TAR_SYS_DICTIONARY_COLS column_REFS = new TAR_SYS_DICTIONARY_COLS();
//				column_REFS.getCols_PK().setTdc_column_name(
//						(String) row.get("COLUMN_NAME"));
//				column_REFS.getCols_PK().setTdc_tsd_table_name(
//						t.getTsd_table_name());
//
//				column_REFS
//						.setTdc_column_title((String) row.get("COLUMN_NAME"));
//				column_REFS.setTdc_data_length((BigDecimal) row
//						.get("DATA_LENGTH"));
//
//				if (row.get("DATA_TYPE").equals("VARCHAR2")) {
//					column_REFS.setTdc_data_type("S");
//				} else if (row.get("DATA_TYPE").equals("NUMBER")) {
//					column_REFS.setTdc_data_type("N");
//				} else if (row.get("DATA_TYPE").equals("DATE")) {
//					column_REFS.setTdc_data_type("D");
//				} else if (row.get("DATA_TYPE").equals("TIMESTAMP(6)")) {
//					column_REFS.setTdc_data_type("T");
//				}
//
//				column_REFS.setTdc_create_date(new Date());
//				column_REFS.setTdc_create_user("admin");
//				column_REFS.setTdc_last_modified(new Timestamp(new Date()
//						.getTime()));
//				column_REFS.setTdc_mandatory("N");
//				column_REFS.setTdc_ttl_id(null);
//				column_REFS.setTdc_sort_order(ctr++);
//
//				list.add(column_REFS);
//			}
//			t.getSys_DICTIONARY_COLSs().addAll(list);
//			getHibernateTemplate().save(t);
//		} catch (DataAccessException ex) {
//			throw new DaoException(ex.getRootCause());
//		}
//
//	}

//	@Override
//	public void save_specific(TAR_SYSTEM_DICTIONARY t) throws DaoException {
//		try {
//			save_table_from_remote_ds(t);
//		} catch (DataAccessException ex) {
//			throw new DaoException(ex.getRootCause());
//		}
//	}

	@Override
	public void delete_by_id(String table_name) throws DaoException {
		try {
			getHibernateTemplate().bulkUpdate(
					"delete from TAR_SYSTEM_DICTIONARY where tsd_table_name="
							+ "\'" + table_name + "\'");
		} catch (DataAccessException ex) {
			//System.out.println("****************"+ex.getRootCause());
			throw new DaoException(ex.getRootCause());
		}
	}

//	@Override
//	public List<Object> getTableNamesSpecificToDataSource(String dataSourceName)
//			throws DaoException {
//		try {
//			JdbcTemplate jdbcTemplate = getRemoteDao()
//					.getdataSourceSpecificJdbcTemplate(dataSourceName);
//			if (jdbcTemplate == null) {
//				return null;
//			}
//			List<Object> list1 = new ArrayList<Object>();
//			List<Map<String, Object>> list = jdbcTemplate
//					.queryForList("SELECT TNAME FROM TAB ORDER BY TNAME");
//			for (Map<String, Object> map : list) {
//				list1.addAll(map.values());
//			}
//			return list1;
//		} catch (DataAccessException ex) {
//			throw new DaoException(ex.getRootCause());
//		}
//
//	}

	@Override
	public void deleteSysDictionaryCol(String tableName, String columnName)
			throws DaoException {
		try {
			getHibernateTemplate()
					.bulkUpdate(
							"delete from TAR_SYS_DICTIONARY_COLS where cols_PK.tdc_tsd_table_name=? and cols_PK.tdc_column_name=?",
							tableName, columnName);
		} catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		}

	}

	public void editSysDictionaryCols(
			TAR_SYS_DICTIONARY_COLS sysDictionaryCols, String tableName,
			String columnName) throws DaoException {
		Transaction tx = null;
		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("update TAR_SYS_DICTIONARY_COLS set tdc_column_title =:tdc_column_title,tdc_sort_order =:tdc_sort_order where cols_PK.tdc_tsd_table_name=:tdc_tsd_table_name and cols_PK.tdc_column_name =:tdc_column_name");
			query.setParameter("tdc_column_title",
					sysDictionaryCols.getTdc_column_title());
			query.setParameter("tdc_sort_order",
					sysDictionaryCols.getTdc_sort_order());
			query.setParameter("tdc_tsd_table_name", tableName);
			query.setParameter("tdc_column_name", columnName);
			query.executeUpdate();
			session.flush();
			tx.commit();

		} catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		} finally {
			session.close();
		}
	}

	@Override
	public void update_column_details(String json_data, String table_name)
			throws DaoException {

		String table_name1 = null;
		//List<TAR_SYS_DICTIONARY_COLS> dictionary_COLSs = new ArrayList<TAR_SYS_DICTIONARY_COLS>();
		TAR_SYS_DICTIONARY_COLS column_REFS = null;
		try {
			JSONObject jsonObject = new JSONObject(json_data);
			JSONArray jsonArray = jsonObject.getJSONArray("updateColVal");

			for (int i = 0; i < jsonArray.length(); i++) {
				column_REFS = new TAR_SYS_DICTIONARY_COLS();
				JSONObject jsonObject1 = jsonArray.getJSONObject(i);
				String columnName = jsonObject1.getString("columnName");
				String columnTitle = jsonObject1.getString("columnTitle");
				String colmnDataType = jsonObject1.getString("colmnDataType");
				String colmnDataLength = jsonObject1
						.getString("colmnDataLength");
				String colmnOrder = jsonObject1.getString("colmnOrder");
				String tablename = jsonObject1.getString("tablename");
				table_name1 = tablename;

				column_REFS.setTdc_column_title(columnTitle);
				column_REFS.setTdc_data_length(new BigDecimal(Integer
						.parseInt(colmnDataLength)));
				column_REFS.setTdc_data_type(colmnDataType);
				column_REFS.setTdc_sort_order(Integer.parseInt(colmnOrder));

				column_REFS.setTdc_create_date(new Date());
				column_REFS.setTdc_create_user("admin");
				column_REFS.setTdc_last_modified(new Timestamp(new Date()
						.getTime()));
				column_REFS.setTdc_mandatory("N");
				column_REFS.setTdc_ttl_id(null);

				editSysDictionaryCols(column_REFS, tablename, columnName);
			}

		} catch (JSONException e) {
			throw new DaoException(e.getCause());
		} catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		}

	}

//	@Override
//	public Map<String, String> add_column_details_to_catalog(String table_name)
//			throws DaoException {
//
//		try {
//			TAR_SYSTEM_DICTIONARY dictionary = super.findById(table_name);
//			String data_source = dictionary.getTsd_data_source_name();
//			JdbcTemplate jdbcTemplate = getRemoteDao()
//					.getdataSourceSpecificJdbcTemplate(data_source);
//			if (jdbcTemplate == null) {
//				return null;
//			}
//			List<Object> list1 = new ArrayList<Object>();
//			String queryStr = "SELECT COLUMN_NAME, DATA_TYPE, DATA_LENGTH FROM USER_TAB_COLUMNS WHERE TABLE_NAME="
//					+ "\'" + dictionary.getTsd_table_name() + "\'";
//			List<Map<String, Object>> list = jdbcTemplate
//					.queryForList(queryStr);
//			List<temp> list2 = new ArrayList<TableCatalogDaoImpl.temp>();
//			for (Map<String, Object> map : list) {
//				list1.addAll(map.values());
//				temp temp1 = new temp();
//				for (int i = 0; i < list1.size(); i++) {
//					if (i == 0) {
//						temp1.setColumn_name((String) list1.get(i));
//						continue;
//					}
//					if (i == 1) {
//						temp1.setData_type((String) list1.get(i));
//						continue;
//					}
//					if (i == 2) {
//						BigDecimal str = (BigDecimal) list1.get(i);
//						temp1.setData_length(str);
//						continue;
//					}
//				}
//				list1.clear();
//				list2.add(temp1);
//			}
//			List<TAR_SYS_DICTIONARY_COLS> sys_DICTIONARY_COLSs = getHibernateTemplate()
//					.find("from TAR_SYS_DICTIONARY_COLS e where e.cols_PK.tdc_tsd_table_name="
//							+ "\'" + table_name + "\'");
//			List<temp> temp_array = new ArrayList<TableCatalogDaoImpl.temp>();
//			for (TAR_SYS_DICTIONARY_COLS cols : sys_DICTIONARY_COLSs) {
//				temp tempobj = new temp();
//				tempobj.setColumn_name(cols.getCols_PK().getTdc_column_name());
//				tempobj.setData_length(cols.getTdc_data_length());
//				tempobj.setData_type(cols.getTdc_data_type());
//				temp_array.add(tempobj);
//			}
//			List<temp> final_array = new ArrayList<TableCatalogDaoImpl.temp>();
//			for (temp obj : list2) {
//				if (temp_array.contains(obj)) {
//					continue;
//				} else {
//					final_array.add(obj);
//
//				}
//			}
//			int counter = sys_DICTIONARY_COLSs.size();
//			sys_DICTIONARY_COLSs.clear();
//			for (temp tamp1 : final_array) {
//				TAR_SYS_DICTIONARY_COLS cols = new TAR_SYS_DICTIONARY_COLS();
//				cols.setTdc_column_title(tamp1.getColumn_name());
//
//				if (tamp1.getData_type().equals("VARCHAR2")) {
//					cols.setTdc_data_type("S");
//				} else if (tamp1.getData_type().equals("NUMBER")) {
//					cols.setTdc_data_type("N");
//				} else if (tamp1.getData_type().equals("DATE")) {
//					cols.setTdc_data_type("D");
//				} else if (tamp1.getData_type().equals("TIMESTAMP(6)")) {
//					cols.setTdc_data_type("T");
//				}
//
//				// cols.setTdc_data_type(tamp1.getData_type());
//				cols.setTdc_data_length(tamp1.getData_length());
//				cols.getCols_PK().setTdc_column_name(tamp1.getColumn_name());
//				cols.getCols_PK().setTdc_tsd_table_name(table_name);
//				cols.setTdc_create_user("admin");
//				cols.setTdc_create_date(new Date());
//				cols.setTdc_mandatory("N");
//				cols.setTdc_ttl_id(null);
//				cols.setTdc_last_modified(new Timestamp(new Date().getTime()));
//				cols.setTdc_sort_order(++counter);
//				sys_DICTIONARY_COLSs.add(cols);
//			}
//			if (sys_DICTIONARY_COLSs.size() > 0) {
//				getHibernateTemplate().saveOrUpdateAll(sys_DICTIONARY_COLSs);
//			}
//
//			return null;
//		} catch (DataAccessException ex) {
//			throw new DaoException(ex.getRootCause());
//		}
//
//	}

	public class temp {

		private String column_name;
		private String data_type;
		private BigDecimal data_length;

		public String getColumn_name() {
			return column_name;
		}

		public String getData_type() {
			return data_type;
		}

		public BigDecimal getData_length() {
			return data_length;
		}

		public void setColumn_name(String column_name) {
			this.column_name = column_name;
		}

		public void setData_type(String data_type) {
			this.data_type = data_type;
		}

		public void setData_length(BigDecimal data_length) {
			this.data_length = data_length;
		}

		@Override
		public String toString() {
			return column_name;
		}

		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;

			temp that = (temp) o;

			if (column_name != null ? !column_name.equals(that.column_name)
					: that.column_name != null)
				return false;
			return true;
		}

		public int hashCode() {
			int result;
			result = (column_name != null ? column_name.hashCode() : 0);
			return result;
		}
	}

	@Override
	public void save_specific(TAR_SYSTEM_DICTIONARY t) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Object> getTableNamesSpecificToDataSource(String dataSourceName)
			throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> add_column_details_to_catalog(String table_name)
			throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
