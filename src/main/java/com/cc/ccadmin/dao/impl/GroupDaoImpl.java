package com.cc.ccadmin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cc.ccadmin.dao.AbstractGenericDao;
import com.cc.ccadmin.dao.admin.IGroupDao;
import com.cc.ccadmin.exception.DaoException;
import com.cc.ccadmin.model.admin.ADM_GROUP;
import com.cc.ccadmin.model.admin.ADM_GROUP_PERMISSIONS;
import com.cc.ccadmin.model.admin.ADM_PERMISSIONS;

@Repository
public class GroupDaoImpl extends AbstractGenericDao<ADM_GROUP, String>
		implements IGroupDao<ADM_GROUP, String> {

	public GroupDaoImpl() {

	}

	@Override
	public void delete_group_by_code(String user_code) throws DaoException {
		try {
			ADM_GROUP adm_GROUP = findById(user_code);
			delete(adm_GROUP);
		} catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		}
	}

	@Override
	public String save_group_permission_json(String group_code, String json)
			throws DaoException {

		List<ADM_GROUP_PERMISSIONS> adm_GROUP_PERMISSIONSs = new ArrayList<ADM_GROUP_PERMISSIONS>();

		try {
			JSONObject jsonObject = new JSONObject(json);
			JSONArray jsonArray = jsonObject.getJSONArray("grpData");

			ADM_GROUP adm_GROUP = new ADM_GROUP();
			adm_GROUP.setAgr_code(group_code);

			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject1 = jsonArray.getJSONObject(i);

				ADM_GROUP_PERMISSIONS adm_GROUP_PERMISSIONS = new ADM_GROUP_PERMISSIONS();
				adm_GROUP_PERMISSIONS.setAgp_delete_flag("Y");

				ADM_PERMISSIONS adm_PERMISSIONS = new ADM_PERMISSIONS();
				if (jsonObject1.get("groupPermission") != null) {
					adm_PERMISSIONS.setApn_code((String) jsonObject1
							.get("groupPermission"));
				}

				adm_GROUP_PERMISSIONS.getPk().setGroup(adm_GROUP);
				adm_GROUP_PERMISSIONS.getPk().setPermissions(adm_PERMISSIONS);
				adm_GROUP_PERMISSIONSs.add(adm_GROUP_PERMISSIONS);

			}
			getHibernateTemplate().saveOrUpdateAll(adm_GROUP_PERMISSIONSs);
			return "0";
		} catch (JSONException ex) {
			throw new DaoException(ex.getMessage());
		} catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		}

	}

	@Override
	public void delete_group_permission(String group_code,
			String permission_code) throws DaoException {
		try{
			getHibernateTemplate().bulkUpdate("delete from ADM_GROUP_PERMISSIONS e where e.pk.group.agr_code=? and e.pk.permissions.apn_code=?",group_code,permission_code);
		}catch (DataAccessException ex) {
			throw new DaoException(ex.getRootCause());
		}
		

	}

}
