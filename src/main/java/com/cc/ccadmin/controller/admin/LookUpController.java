package com.cc.ccadmin.controller.admin;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cc.ccadmin.dao.admin.ILookupDao;
import com.cc.ccadmin.dao.admin.ILookupDetailsDao;
import com.cc.ccadmin.exception.DaoException;
import com.cc.ccadmin.model.admin.BAS_LOOKUPS;
import com.cc.ccadmin.model.admin.BAS_LOOKUP_DETAILS;
import com.cc.ccadmin.util.IGenericLookUp;

@Controller
@RequestMapping(value = "/admin/lookup")
@SessionAttributes(value = "lookup_name")
public class LookUpController {

	@Autowired
	private ILookupDao<BAS_LOOKUPS, String> lookupDao;
	@Autowired
	private ILookupDetailsDao<BAS_LOOKUP_DETAILS, String> lookupDetailsDao;
	@Autowired
	private IGenericLookUp<BAS_LOOKUPS, String> genericLookUp;

	@RequestMapping(value = "/lookup_list", method = RequestMethod.GET)
	public String find_lookup_list(Model model) {
		try {
			model.addAttribute("lookup_list", lookupDao.findAll());
			model.addAttribute("lookup_types",genericLookUp.getLookups("LOOKUP_TYPE", "L", null, null));
			return "lookup-home";
		} catch (DaoException e) {
			String text =  e.getCause().toString();
			text=text.replace("\n", "");
			System.out.println("*********************"+text);
			model.addAttribute("error", text);
			return "lookup-home";
		}

	}

	@RequestMapping(value = "/add_lookup", method = RequestMethod.GET)
	public String add_lookup_new_form(Model model) {

		BAS_LOOKUPS bas_LOOKUPS = new BAS_LOOKUPS();
		model.addAttribute("lookup_bean", bas_LOOKUPS);
		model.addAttribute("lookup_types",genericLookUp.getLookups("LOOKUP_TYPE", "L", null, null));
		model.addAttribute("lookup_table",genericLookUp.getLookups("LOOKUP_LOOKUP_TAB", "L", null, null));

		return "add_lookup_form";
	}

	@RequestMapping(value = "/add_lookup", method = RequestMethod.POST)
	public String add_lookup_new_form_submit(Model model,
			@ModelAttribute("lookup_bean") BAS_LOOKUPS bas_LOOKUPS) {

		bas_LOOKUPS.setDlk_create_date(new Date());
		bas_LOOKUPS.setDlk_create_user("Sushanta");
		bas_LOOKUPS.setDlk_system_flag("Y");
		bas_LOOKUPS.setDlk_last_modified(new Timestamp(new Date().getTime()));
		try {
			lookupDao.save(bas_LOOKUPS);
			return "redirect:/admin/lookup/view_lookup_by_name.htm?look_up_name="+bas_LOOKUPS.getDlk_lookup_name();
		} catch (DaoException e) {
			String text =  e.getCause().toString();
			text=text.replace("\n", "");
			System.out.println("*********************"+text);
			model.addAttribute("error", text);
			return "add_lookup_form";
		}

	}

	@RequestMapping(value = "/view_lookup_by_name", method = RequestMethod.GET)
	public String view_lookup(
			@RequestParam("look_up_name") String look_up_name, Model model) {
		BAS_LOOKUPS bas_LOOKUPS;
		try {
			bas_LOOKUPS = lookupDao.findById(look_up_name);
			model.addAttribute("lookup", bas_LOOKUPS);
			return "lookup_with_lookup_details";
		} catch (DaoException e) {
			String text =  e.getCause().toString();
			text=text.replace("\n", "");
			System.out.println("*********************"+text);
			model.addAttribute("error", text);
			return "lookup_with_lookup_details";
		}

	}

	@RequestMapping(value="/edit_look_up",method=RequestMethod.GET)
	public String edit_look_up(@RequestParam("lookup_name") String lookup_name, Model model){
		try {
			model.addAttribute("lookup_bean", lookupDao.findById(lookup_name));
			model.addAttribute("lookup_types",genericLookUp.getLookups("LOOKUP_TYPE", "L", null, null));
			model.addAttribute("lookup_table",genericLookUp.getLookups("LOOKUP_LOOKUP_TAB", "L", null, null));
			return "edit_lookup";
		} catch (DaoException e) {
			String text =  e.getCause().toString();
			text=text.replace("\n", "");
			System.out.println("*********************"+text);
			model.addAttribute("error", text);
			return "edit_lookup";
		}

	}
	@RequestMapping(value="/edit_look_up",method=RequestMethod.POST)
	public String edit_look_up(@ModelAttribute("lookup_bean") BAS_LOOKUPS lookup,Model model){
		try {
			lookupDao.update(lookup);
			return "redirect:/admin/lookup/view_lookup_by_name.htm?look_up_name="+lookup.getDlk_lookup_name();
		} catch (DaoException e) {
			String text =  e.getCause().toString();
			text=text.replace("\n", "");
			System.out.println("*********************"+text);
			model.addAttribute("error", text);
			return "edit_lookup";
		}

	}

	@RequestMapping(value = "/add_lookup_details", method = RequestMethod.GET)
	public String add_lookup_details_new_form(
			@RequestParam("lookup_name") String lookup_name, Model model) {

		BAS_LOOKUP_DETAILS bas_LOOKUP_DETAILS = new BAS_LOOKUP_DETAILS();
		model.addAttribute("lookup_name", lookup_name);
		try {
			model.addAttribute("lookup", lookupDao.findById(lookup_name));
			model.addAttribute("lookup_detail_bean", bas_LOOKUP_DETAILS);
			return "add_lookup_details_new_form";
		} catch (DaoException e) {
			String text =  e.getCause().toString();
			text=text.replace("\n", "");
			System.out.println("*********************"+text);
			model.addAttribute("error", text);
			return "add_lookup_details_new_form";
		}

	}

	@RequestMapping(value = "/add_lookup_details", method = RequestMethod.POST)
	public String add_lookup_details_new_form_submit(
			@ModelAttribute("lookup_name") String lookup_name,
			@ModelAttribute("lookup_detail_bean") BAS_LOOKUP_DETAILS bas_LOOKUP_DETAILS,Model model) {


		bas_LOOKUP_DETAILS.setDld_last_modified(new Timestamp(new Date().getTime()));
		bas_LOOKUP_DETAILS.setDld_system_flag("Y");
		bas_LOOKUP_DETAILS.getBas_Lookup_Details_PK().setDld_dlk_lookup_name(lookup_name);
		try {
			lookupDetailsDao.save(bas_LOOKUP_DETAILS);
			return "redirect:/admin/lookup/view_lookup_by_name.htm?look_up_name="+lookup_name;
		} catch (DaoException e) {
			String text =  e.getCause().toString();
			text=text.replace("\n", "");
			System.out.println("*********************"+text);
			model.addAttribute("error", text);
			return "add_lookup_details_new_form";
		}

	}

	@RequestMapping(value="/delete_lookup",method=RequestMethod.GET)
	public String delete_lookup(@RequestParam("lookup_name")String lookup_name, Model model){
		try {
			lookupDao.bulk_insert_lookup();
			return "redirect:/admin/lookup/lookup_list.htm";
		} catch (DaoException e) {
			String text =  e.getCause().toString();
			text=text.replace("\n", "");
			System.out.println("*********************"+text);
			model.addAttribute("error", text);
			return "redirect:/admin/lookup/lookup_list.htm";
		}

	}

	@RequestMapping(value = "/get_edit_lookup_details", method = RequestMethod.GET)
	public String get_edit_lookup_details(
			@RequestParam("lookup_code") String lookup_code,@RequestParam("lookupname") String lookupname,
			Model model) {

		try {
			model.addAttribute("lookup_bean", lookupDao.findById(lookupname));
			model.addAttribute("lookup_detail_bean", lookupDetailsDao.findByCode(lookup_code,lookupname));
			return "edit_lookup_details";
		} catch (DaoException e) {
			String text =  e.getCause().toString();
			text=text.replace("\n", "");
			System.out.println("*********************"+text);
			model.addAttribute("error", text);
			return "edit_lookup_details";
		}


	}
	@RequestMapping(value = "/edit_lookup_details", method = RequestMethod.POST)
	public String edit_lookup_details(@RequestParam("lookup_name") String lookup_name,
			@ModelAttribute("lookup_detail_bean") BAS_LOOKUP_DETAILS lookupDetails, Model model) {

		try {
			lookupDetailsDao.editLookupDetails(lookupDetails, null, lookup_name);
			return "redirect:/admin/lookup/view_lookup_by_name.htm?look_up_name="+lookup_name;
		} catch (DaoException e) {
			String text =  e.getCause().toString();
			text=text.replace("\n", "");
			System.out.println("*********************"+text);
			model.addAttribute("error", text);
			return "redirect:/admin/lookup/view_lookup_by_name.htm?look_up_name="+lookup_name;
		}


	}

	@RequestMapping(value="/delete_lookupdetail",method=RequestMethod.GET)
	public String delete_lookupdetail(@RequestParam("lookup_code") String lookup_code,
			                          @RequestParam("lookupname")String lookup_name,Model model){

		try {
			lookupDetailsDao.deleteLookupDetail(lookup_code, lookup_name);
			return "redirect:/admin/lookup/view_lookup_by_name.htm?look_up_name="+lookup_name;
		} catch (DaoException e) {
			String text =  e.getCause().toString();
			text=text.replace("\n", "");
			System.out.println("*********************"+text);
			model.addAttribute("error", text);
			return "redirect:/admin/lookup/view_lookup_by_name.htm?look_up_name="+lookup_name;
		}

	}

	@RequestMapping(value="/bulk_insert",method=RequestMethod.GET)
	public String bulk_insert(Model model){

		try {
			lookupDao.bulk_insert_lookup();
			lookupDao.bulk_insert_lookup_details();
			return "redirect:/admin/lookup/lookup_list.htm";
		} catch (DaoException e) {
			String text =  e.getCause().toString();
			text=text.replace("\n", "");
			System.out.println("*********************"+text);
			model.addAttribute("error", text);
			return "redirect:/admin/lookup/lookup_list.htm";
		}


	}

}
