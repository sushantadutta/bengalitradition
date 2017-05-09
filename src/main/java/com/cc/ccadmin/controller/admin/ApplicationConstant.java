package com.cc.ccadmin.controller.admin;

import java.util.HashMap;
import java.util.Map;

import com.cc.ccadmin.dao.impl.RemoteDao;
//Application Constants
public class ApplicationConstant {

	public static final Map<String, String> map_dataSources = new HashMap<String, String>();

	static {
		map_dataSources.put(RemoteDao.loyaltyDS, "CC_LOYAL_DS");
		map_dataSources.put(RemoteDao.singleViewDs, "CC_SINGLE_VIEW_DS");
		// map_dataSources.put("", "");
	}

	public static Map<String, String> getDataSources() {
		return map_dataSources;
	}
}
