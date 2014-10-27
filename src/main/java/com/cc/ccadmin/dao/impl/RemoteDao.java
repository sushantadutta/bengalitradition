package com.cc.ccadmin.dao.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class RemoteDao {

	public static final String loyaltyDS = "CC_LOYAL_DS";
	public static final String singleViewDs = "CC_SINGLE_VIEW_DS";
	public static final String appDs = "APP_DS";
		
	private Map<String, JdbcTemplate> remoteDataSources;

	
	@Autowired
	public void setRemoteDataSources(Map<String, JdbcTemplate> remoteDataSources) {
		this.remoteDataSources = remoteDataSources;
	}
	
	public final JdbcTemplate getdataSourceSpecificJdbcTemplate(String dataSourceName){
		return (remoteDataSources.containsKey(dataSourceName))? remoteDataSources.get(dataSourceName):null;
	}
}
