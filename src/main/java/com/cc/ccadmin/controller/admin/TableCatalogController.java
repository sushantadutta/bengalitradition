package com.cc.ccadmin.controller.admin;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.ccadmin.dao.admin.ITableCatalogDao;
import com.cc.ccadmin.exception.DaoException;
import com.cc.ccadmin.model.admin.TAR_SYSTEM_DICTIONARY;

@Controller
@RequestMapping("/admin/table_catalog")
public class TableCatalogController {

	@Autowired
	private ITableCatalogDao<TAR_SYSTEM_DICTIONARY, String> tableCatalogDao;
	/*@Autowired
	private IGenericLookUp<BAS_LOOKUPS, String> genericLookUp;*/

	@RequestMapping(value = "/table_catalog_list", method = RequestMethod.GET)
	public String tableCatalogList(Model model) {
		try {
			model.addAttribute("tableCatalogList", tableCatalogDao.findAll());
			return "tableCatalogList";
		} catch (DaoException e) {
			String text =  e.getCause().toString();
			text=text.replace("\n", "");
			System.out.println("*********************"+text);
			model.addAttribute("error", text);
			return "tableCatalogList";
		}

	}

	@RequestMapping(value = "/get_tables_based_on_datasource", method = RequestMethod.GET)
	public @ResponseBody
	List<Object> get_tables_based_on_datasource(
			@RequestParam("datasource") String datasource, Model model) {
		try {
			return tableCatalogDao
					.getTableNamesSpecificToDataSource(datasource);
		} catch (DaoException e) {
			return null;
		}
	}

	@RequestMapping(value = "/add_table_catalog", method = RequestMethod.GET)
	public String add_table_catalog(Model model) {

		TAR_SYSTEM_DICTIONARY system_DICTIONARY = new TAR_SYSTEM_DICTIONARY();
		model.addAttribute("datasource_list",
				ApplicationConstant.getDataSources());
		model.addAttribute("table_bean", system_DICTIONARY);
		return "addTableCatalog";
	}

	@RequestMapping(value = "/add_table_catalog", method = RequestMethod.POST)
	public String add_table_catalog(
			@ModelAttribute("table_bean") TAR_SYSTEM_DICTIONARY dictionary,
			Model model) {

		dictionary.setTsd_table_type("U");
		dictionary.setTsd_key_unique(null);
		dictionary.setTsd_last_modified(new Timestamp(new Date().getTime()));
		dictionary.setTsd_create_user("admin");
		dictionary.setTsd_create_date(new Date());
		dictionary.setTsd_ttl_id(null);
		dictionary.setTsd_key_column(null);
		try {
			tableCatalogDao.save_specific(dictionary);
			return "redirect:/admin/table_catalog/table_catalog_list.htm";
		} catch (DaoException e) {
			String text =  e.getCause().toString();
			text=text.replace("\n", "");
			System.out.println("*********************"+text);
			model.addAttribute("error", text);
			//return "redirect:/admin/table_catalog/table_catalog_list.htm";
			return "addTableCatalog";
		}

	}

	@RequestMapping(value = "/delete_table_catalog_by_name", method = RequestMethod.GET)
	public String delete_table_catalog_by_name(
			@RequestParam("table_name") String table_name, Model model) {

		try {
			tableCatalogDao.delete_by_id(table_name);
			return "redirect:/admin/table_catalog/table_catalog_list.htm";
		} catch (DaoException e) {
			
			String text =  e.getCause().toString();
			text=text.replace("\n", "");
			System.out.println("*********************"+text);
			model.addAttribute("error", text);
			model.addAttribute("requestedUrl", "table_catalog_list.htm");
			return "tableCatalogList";
		}

	}

	@RequestMapping(value = "/view_table_catalog_by_table_name", method = RequestMethod.GET)
	public String view_table_catalog_by_table_name(Model model,
			@RequestParam("table_name") String table_name) {

		try {
			model.addAttribute("table_catalog_bean",
					tableCatalogDao.findById(table_name));
			return "viewTableCatalogDetails";
		} catch (DaoException e) {
			String text =  e.getCause().toString();
			text=text.replace("\n", "");
			System.out.println("*********************"+text);
			model.addAttribute("error", text);
			return "viewTableCatalogDetails";
		}

	}

	@RequestMapping(value = "/edit_column_details", method = RequestMethod.GET)
	public String edit_column_details(
			@RequestParam("table_name") String table_name, Model model) {
		try {
			model.addAttribute("table_catalog_bean",
					tableCatalogDao.findById(table_name));
			return "edit_column_details";
		} catch (DaoException e) {
			String text =  e.getCause().toString();
			text=text.replace("\n", "");
			System.out.println("*********************"+text);
			model.addAttribute("error", text);
			return "edit_column_details";
		}

	}

	@RequestMapping(value = "/edit_column_details", method = RequestMethod.POST)
	@ResponseBody
	public String edit_column_details(@RequestBody String column_details) {

		try {
			tableCatalogDao.update_column_details(column_details, null);
			return "true";
		} catch (DaoException e) {
			return "false";
		}

	}

	@RequestMapping(value = "/add_column_details", method = RequestMethod.GET)
	public String add_column_details(
			@RequestParam("table_name") String table_name, Model model) {

		try {
			tableCatalogDao.add_column_details_to_catalog(table_name);
			return "redirect:/admin/table_catalog/view_table_catalog_by_table_name.htm?table_name="
					+ table_name;
		} catch (DaoException e) {
			String text =  e.getCause().toString();
			text=text.replace("\n", "");
			System.out.println("*********************"+text);
			model.addAttribute("error", text);
			return "redirect:/admin/table_catalog/view_table_catalog_by_table_name.htm?table_name="
					+ table_name;
		}

	}

	@RequestMapping(value = "/deleteSysDictionaryCol", method = RequestMethod.GET)
	public String deleteSysDictionaryCol(
			@RequestParam("table_name") String tableName,
			@RequestParam("column_name") String columnName, Model model) {
		try {
			tableCatalogDao.deleteSysDictionaryCol(tableName, columnName);
			return "redirect:/admin/table_catalog/view_table_catalog_by_table_name.htm?table_name="
					+ tableName;
		} catch (DaoException e) {
			String text =  e.getCause().toString();
			text=text.replace("\n", "");
			System.out.println("*********************"+text);
			model.addAttribute("error", text);
			return "redirect:/admin/table_catalog/view_table_catalog_by_table_name.htm?table_name="
					+ tableName;
		}
	}

}
