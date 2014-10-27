package com.cc.ccadmin.model.admin;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cc.ccadmin.model.IBaseModel;

@SuppressWarnings("serial")
@Entity
@Table(name = "IMP_LOAD_COLUMN_REFS")
public class IMP_LOAD_COLUMN_REFS implements IBaseModel{
	
	private String ilc_mandatory;
	private String ilc_column_title;
	private String ilc_data_type;
	private BigDecimal ilc_data_length;
	private Integer ilc_data_precision;
	private Integer ilc_data_scale;
	private String ilc_data_format;
	private String ilc_load_flag;
	private String ilc_lookup_name;
	private String ilc_display_in_report;
	private String ilc_report_display_grp;
	private String ilc_display_maybe;
	private Integer ilc_sort_order;
	private String ilc_create_user;
	private Date ilc_create_date;
	private String ilc_update_user;
	private Date ilc_update_date;
	private Timestamp ilc_last_modified;
	private String ilc_profile_flag;
	private BigDecimal ilc_spv_id;
	private String ilc_frequency_flag;		
	private Imp_Load_Col_Ref_PK imp_Load_Col_Ref_PK = new Imp_Load_Col_Ref_PK();
	
	@EmbeddedId
	public Imp_Load_Col_Ref_PK getImp_Load_Col_Ref_PK() {
		return imp_Load_Col_Ref_PK;
	}
	@Transient
	public String getIlcColumnName(){
		return getImp_Load_Col_Ref_PK().getIlc_column_name();
		
	}
	@Transient
	public String getIlcIltTableName(){
		return getImp_Load_Col_Ref_PK().getIlc_ilt_table_name();
		
	}
	
	
	@Column(name="ILC_MANDATORY",length=1,nullable=false)
	public String getIlc_mandatory() {
		return ilc_mandatory;
	}
	@Column(name="ILC_COLUMN_TITLE",length=30,nullable=false)
	public String getIlc_column_title() {
		return ilc_column_title;
	}
	@Column(name="ILC_DATA_TYPE",length=1,nullable=false)
	public String getIlc_data_type() {
		return ilc_data_type;
	}
	@Column(name="ILC_DATA_LENGTH")
	public BigDecimal getIlc_data_length() {
		return ilc_data_length;
	}
	@Column(name="ILC_DATA_PRECISION")
	public Integer getIlc_data_precision() {
		return ilc_data_precision;
	}
	@Column(name="ILC_DATA_SCALE")
	public Integer getIlc_data_scale() {
		return ilc_data_scale;
	}
	@Column(name="ILC_DATA_FORMAT",length=60)
	public String getIlc_data_format() {
		return ilc_data_format;
	}
	@Column(name="ILC_LOAD_FLAG",length=1)
	public String getIlc_load_flag() {
		return ilc_load_flag;
	}
	@Column(name="ILC_LOOKUP_NAME",length=30)
	public String getIlc_lookup_name() {
		return ilc_lookup_name;
	}
	@Column(name="ILC_DISPLAY_IN_REPORT",length=1,nullable=false)
	public String getIlc_display_in_report() {
		return ilc_display_in_report;
	}
	@Column(name="ILC_REPORT_DISPLAY_GRP",length=10)
	public String getIlc_report_display_grp() {
		return ilc_report_display_grp;
	}
	@Column(name="ILC_DISPLAY_IN_MAYBE",length=1,nullable=false)
	public String getIlc_display_maybe() {
		return ilc_display_maybe;
	}
	@Column(name="ILC_SORT_ORDER",length=3)
	public Integer getIlc_sort_order() {
		return ilc_sort_order;
	}
	@Column(name="ILC_CREATE_USER",length=30,nullable=false)
	public String getIlc_create_user() {
		return ilc_create_user;
	}
	@Column(name="ILC_CREATE_DATE",nullable=false)
	public Date getIlc_create_date() {
		return ilc_create_date;
	}
	@Column(name="ILC_UPDATE_USER",length=30)
	public String getIlc_update_user() {
		return ilc_update_user;
	}
	@Column(name="ILC_UPDATE_DATE")
	public Date getIlc_update_date() {
		return ilc_update_date;
	}
	@Column(name="ILC_LAST_MODIFIED",length=6)
	public Timestamp getIlc_last_modified() {
		return ilc_last_modified;
	}
	@Column(name="ILC_PROFILE_FLAG",length=1)
	public String getIlc_profile_flag() {
		return ilc_profile_flag;
	}
	@Column(name="ILC_SPV_ID",length=10)
	public BigDecimal getIlc_spv_id() {
		return ilc_spv_id;
	}
	@Column(name="ILC_FREQUENCY_FLAG",length=1)
	public String getIlc_frequency_flag() {
		return ilc_frequency_flag;
	}
	
	
	
	
	public void setIlc_mandatory(String ilc_mandatory) {
		this.ilc_mandatory = ilc_mandatory;
	}
	public void setIlc_column_title(String ilc_column_title) {
		this.ilc_column_title = ilc_column_title;
	}
	public void setIlc_data_type(String ilc_data_type) {
		this.ilc_data_type = ilc_data_type;
	}
	public void setIlc_data_length(BigDecimal ilc_data_length) {
		this.ilc_data_length = ilc_data_length;
	}
	public void setIlc_data_precision(Integer ilc_data_precision) {
		this.ilc_data_precision = ilc_data_precision;
	}
	public void setIlc_data_scale(Integer ilc_data_scale) {
		this.ilc_data_scale = ilc_data_scale;
	}
	public void setIlc_data_format(String ilc_data_format) {
		this.ilc_data_format = ilc_data_format;
	}
	public void setIlc_load_flag(String ilc_load_flag) {
		this.ilc_load_flag = ilc_load_flag;
	}
	public void setIlc_lookup_name(String ilc_lookup_name) {
		this.ilc_lookup_name = ilc_lookup_name;
	}
	public void setIlc_display_in_report(String ilc_display_in_report) {
		this.ilc_display_in_report = ilc_display_in_report;
	}
	public void setIlc_report_display_grp(String ilc_report_display_grp) {
		this.ilc_report_display_grp = ilc_report_display_grp;
	}
	public void setIlc_display_maybe(String ilc_display_maybe) {
		this.ilc_display_maybe = ilc_display_maybe;
	}
	public void setIlc_sort_order(Integer ilc_sort_order) {
		this.ilc_sort_order = ilc_sort_order;
	}
	public void setIlc_create_user(String ilc_create_user) {
		this.ilc_create_user = ilc_create_user;
	}
	public void setIlc_create_date(Date ilc_create_date) {
		this.ilc_create_date = ilc_create_date;
	}
	public void setIlc_update_user(String ilc_update_user) {
		this.ilc_update_user = ilc_update_user;
	}
	public void setIlc_update_date(Date ilc_update_date) {
		this.ilc_update_date = ilc_update_date;
	}
	public void setIlc_last_modified(Timestamp ilc_last_modified) {
		this.ilc_last_modified = ilc_last_modified;
	}
	public void setIlc_profile_flag(String ilc_profile_flag) {
		this.ilc_profile_flag = ilc_profile_flag;
	}
	public void setIlc_spv_id(BigDecimal ilc_spv_id) {
		this.ilc_spv_id = ilc_spv_id;
	}
	public void setIlc_frequency_flag(String ilc_frequency_flag) {
		this.ilc_frequency_flag = ilc_frequency_flag;
	}
	public void setImp_Load_Col_Ref_PK(Imp_Load_Col_Ref_PK imp_Load_Col_Ref_PK) {
		this.imp_Load_Col_Ref_PK = imp_Load_Col_Ref_PK;
	}
	
	
	
	
	
	
	

}




