package com.cc.ccadmin.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.cc.ccadmin.dao.AbstractGenericDao;
import com.cc.ccadmin.model.admin.BAS_LOOKUPS;
import com.cc.ccadmin.model.admin.BAS_LOOKUP_DETAILS;

@Component
public class GenericLookUpImpl extends AbstractGenericDao<BAS_LOOKUPS, String>
		implements IGenericLookUp<BAS_LOOKUPS, String> {

	@SuppressWarnings("unchecked")
	private Map<String, String> getStaticDropDownList(BAS_LOOKUPS lookup,
			Session session) {

		Map<String, String> map = new LinkedHashMap<String, String>();
		try {

			//String lookupname = "";
			Query query = session
					.createQuery("from BAS_LOOKUP_DETAILS where bas_Lookup_Details_PK.dld_dlk_lookup_name= :lookupname");
			query.setParameter("lookupname", lookup.getDlk_lookup_name());
			List<BAS_LOOKUP_DETAILS> list = query.list();
			Iterator<BAS_LOOKUP_DETAILS> iterator = list.iterator();
			while (iterator.hasNext()) {
				BAS_LOOKUP_DETAILS lookupDetail = iterator.next();
				map.put(lookupDetail.dld_lookup_code(),
						lookupDetail.getDld_lookup_meaning());
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private BAS_LOOKUPS lookupByName(String lookupname, Session session) {
		List<BAS_LOOKUPS> lookups = new LinkedList<BAS_LOOKUPS>();
		Transaction transaction = null;
		BAS_LOOKUPS lookup = null;
		try {

			transaction = session.getTransaction();
			transaction.begin();
			Criteria criteria = session.createCriteria(BAS_LOOKUPS.class);
			Criterion crit = Restrictions.eq("dlk_lookup_name", lookupname);
			criteria.add(crit);
			lookups = criteria.list();
			session.flush();
			transaction.commit();
			if (!lookups.isEmpty()) {
				lookup = (BAS_LOOKUPS) lookups.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			
		}
		return lookup;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Map<String, String> getLookups(String lookupname, String frequency,
			String tablename, String columnname) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();
		try {
			if (session != null) {
				if (lookupname != null) {
					BAS_LOOKUPS lookupList = lookupByName(lookupname, session);

					if (frequency.equals("L")
							&& lookupList.getDlk_lookup_type().equals("S")) {
						map = getStaticDropDownList(lookupList, session);

					} else if (frequency.equals("L")
							&& lookupList.getDlk_lookup_type().equals("D")) {

						String whereClauseResult = "";

						if (lookupList.getDlk_where_clause() != null) {
							whereClauseResult = " where ";
							String whereClause = lookupList
									.getDlk_where_clause();
							if (tablename == null || tablename.equals("")
									|| tablename == "") {
								whereClauseResult += whereClause;
							} else {
								String[] lkupParameter = tablename.split(",");

								String p1 = "", p2 = "", p3 = "";
								if (lkupParameter.length == 1) {
									p1 = lkupParameter[0];
								} else if (lkupParameter.length == 2) {
									p1 = lkupParameter[0];
									p2 = lkupParameter[1];
								}

								whereClauseResult += whereClause.replaceAll(
										"<p1>", p1);
								whereClauseResult = whereClauseResult
										.replaceAll("<p2>", p2);
							}
						}

						Map<String, String> dynamicLkup = getStaticDropDownList(
								lookupList, session);
						Iterator mapItr = dynamicLkup.entrySet().iterator();
						while (mapItr.hasNext()) {

							Map.Entry pairs = (Map.Entry) mapItr.next();
							String sqlQuery = "select " + pairs.getKey()
									+ " lookupCode," + pairs.getValue()
									+ " lookupMeaning from "
									+ lookupList.getDlk_lookup_table()
									+ whereClauseResult;
							map = getDynamicLookups(sqlQuery, session);
						}
					} else {
						map = null;
					}
				}

				else if (frequency.equals("F")) {

					String sqlQuery = "select idv_distinct_value LOOKUPCODE,idv_count LOOKUPMEANING from imp_distinct_values where idv_table_name='"
							+ tablename
							+ "' and idv_column_name='"
							+ columnname + "'";
					map = getDynamicLookups(sqlQuery, session);
				}

			} else {
				return null;
			}
		} catch (Exception e) {

		} finally {
			session.close();
		}
		return map;
	}

	@SuppressWarnings("rawtypes")
	private Map<String, String> getDynamicLookups(String sqlQuery,
			Session session) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		SQLQuery query = null;

		query = session.createSQLQuery(sqlQuery);

		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List returnList = query.list();
		for (Object object : returnList) {
			Map row = (Map) object;

			String key = row.get("LOOKUPCODE").toString();
			String value = row.get("LOOKUPMEANING").toString();
			map.put(key, value);
		}

		return map;
	}

}
