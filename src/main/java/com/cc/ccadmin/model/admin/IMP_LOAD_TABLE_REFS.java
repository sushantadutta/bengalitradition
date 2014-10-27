package com.cc.ccadmin.model.admin;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.cc.ccadmin.model.IBaseModel;

@SuppressWarnings("serial")
@Entity
@Table(name = "IMP_LOAD_TABLE_REFS")
public class IMP_LOAD_TABLE_REFS implements IBaseModel {

	private String ilt_table_name;
	private String ilt_table_desc;
	private Integer ilt_sort_order;
	private String ilt_load_flag;
	private String ilt_auto_gen_key;
	private String ilt_key_column;
	private String ilt_batch_id_column;
	private String ilt_profile_flag;
	private Timestamp ilt_last_modified;
	private Integer ilt_primary_spy_id;
	private String ilt_repeatable_in_svc;
	private String ilt_loy_tranction_flag;
	private String ilt_data_source;

	private Set<IMP_LOAD_COLUMN_REFS> imp_LOAD_COLUMN_REFSs = new HashSet<IMP_LOAD_COLUMN_REFS>(
			0);

	@BatchSize(size = 20)
	@OrderBy("ilc_sort_order")
	@Fetch(FetchMode.JOIN)
	@OneToMany(/*fetch = FetchType.EAGER,*/ targetEntity = com.cc.ccadmin.model.admin.IMP_LOAD_COLUMN_REFS.class, orphanRemoval = true/*, cascade = CascadeType.ALL*/)
	@JoinColumn(name = "ILC_ILT_TABLE_NAME", referencedColumnName = "ILT_TABLE_NAME")
	public Set<IMP_LOAD_COLUMN_REFS> getImp_LOAD_COLUMN_REFSs() {
		return imp_LOAD_COLUMN_REFSs;
	}

	@Id
	@Column(name = "ILT_TABLE_NAME", length = 30, nullable = false)
	public String getIlt_table_name() {
		return ilt_table_name;
	}

	@Column(name = "ILT_TABLE_DESCRIPTION", length = 60, nullable = false)
	public String getIlt_table_desc() {
		return ilt_table_desc;
	}

	@Column(name = "ILT_SORT_ORDER", length = 3)
	public Integer getIlt_sort_order() {
		return ilt_sort_order;
	}

	@Column(name = "ILT_LOAD_FLAG", length = 1, nullable = false)
	public String getIlt_load_flag() {
		return ilt_load_flag;
	}

	@Column(name = "ILT_AUTO_GEN_KEY", length = 1)
	public String getIlt_auto_gen_key() {
		return ilt_auto_gen_key;
	}

	@Column(name = "ILT_KEY_COLUMN", length = 30)
	public String getIlt_key_column() {
		return ilt_key_column;
	}

	@Column(name = "ILT_BATCH_ID_COLUMN", length = 30)
	public String getIlt_batch_id_column() {
		return ilt_batch_id_column;
	}

	@Column(name = "ILT_PROFILE_FLAG", length = 1)
	public String getIlt_profile_flag() {
		return ilt_profile_flag;
	}

	@Column(name = "ILT_LAST_MODIFIED", length = 6)
	public Timestamp getIlt_last_modified() {
		return ilt_last_modified;
	}

	@Column(name = "ILT_PRIMARY_SPV_ID", length = 10)
	public Integer getIlt_primary_spy_id() {
		return ilt_primary_spy_id;
	}

	@Column(name = "ILT_REPEATABLE_IN_SVC", length = 1)
	public String getIlt_repeatable_in_svc() {
		return ilt_repeatable_in_svc;
	}

	@Column(name = "ILT_LOY_TRANSACTION_FLAG", length = 1)
	public String getIlt_loy_tranction_flag() {
		return ilt_loy_tranction_flag;
	}

	@Column(name = "ILT_DATA_SOURCE", length = 30)
	public String getIlt_data_source() {
		return ilt_data_source;
	}

	public void setIlt_table_name(String ilt_table_name) {
		this.ilt_table_name = ilt_table_name;
	}

	public void setIlt_table_desc(String ilt_table_desc) {
		this.ilt_table_desc = ilt_table_desc;
	}

	public void setIlt_sort_order(Integer ilt_sort_order) {
		this.ilt_sort_order = ilt_sort_order;
	}

	public void setIlt_load_flag(String ilt_load_flag) {
		this.ilt_load_flag = ilt_load_flag;
	}

	public void setIlt_auto_gen_key(String ilt_auto_gen_key) {
		this.ilt_auto_gen_key = ilt_auto_gen_key;
	}

	public void setIlt_key_column(String ilt_key_column) {
		this.ilt_key_column = ilt_key_column;
	}

	public void setIlt_batch_id_column(String ilt_batch_id_column) {
		this.ilt_batch_id_column = ilt_batch_id_column;
	}

	public void setIlt_profile_flag(String ilt_profile_flag) {
		this.ilt_profile_flag = ilt_profile_flag;
	}

	public void setIlt_last_modified(Timestamp ilt_last_modified) {
		this.ilt_last_modified = ilt_last_modified;
	}

	public void setIlt_primary_spy_id(Integer ilt_primary_spy_id) {
		this.ilt_primary_spy_id = ilt_primary_spy_id;
	}

	public void setIlt_repeatable_in_svc(String ilt_repeatable_in_svc) {
		this.ilt_repeatable_in_svc = ilt_repeatable_in_svc;
	}

	public void setIlt_loy_tranction_flag(String ilt_loy_tranction_flag) {
		this.ilt_loy_tranction_flag = ilt_loy_tranction_flag;
	}

	public void setIlt_data_source(String ilt_data_source) {
		this.ilt_data_source = ilt_data_source;
	}

	public void setImp_LOAD_COLUMN_REFSs(
			Set<IMP_LOAD_COLUMN_REFS> imp_LOAD_COLUMN_REFSs) {
		this.imp_LOAD_COLUMN_REFSs = imp_LOAD_COLUMN_REFSs;
	}

}
