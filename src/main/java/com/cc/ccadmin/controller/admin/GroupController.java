package com.cc.ccadmin.controller.admin;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.ccadmin.dao.admin.IGroupDao;
import com.cc.ccadmin.exception.DaoException;
import com.cc.ccadmin.model.admin.ADM_GROUP;
import com.cc.ccadmin.model.admin.BAS_LOOKUPS;
import com.cc.ccadmin.util.IGenericLookUp;

@Controller
@RequestMapping("/admin/group")
public class GroupController {

	@Autowired
	private IGroupDao<ADM_GROUP, String> adminDao;
	@Autowired
	private IGenericLookUp<BAS_LOOKUPS, String> genericLookUp;

	@RequestMapping(value = "/group_list", method = RequestMethod.GET)
	public String find_group_list(Model model) {
		try {
			model.addAttribute("group_list", adminDao.findAll());
		} catch (DaoException e) {
			String text = e.getCause().toString();
			text = text.replace("\n", "");
			System.out.println("*********************" + text);
			model.addAttribute("error", text);
		}
		return "group_list";
	}

	@RequestMapping(value = "/add_group", method = RequestMethod.GET)
	public String add_group_new_form(Model model) {

		ADM_GROUP adm_GROUP = new ADM_GROUP();
		model.addAttribute("group_bean", adm_GROUP);
		return "add_group_new_form";
	}

	@RequestMapping(value = "/add_group", method = RequestMethod.POST)
	public String add_group_submit_form(Model model,
			@ModelAttribute("group_bean") ADM_GROUP adm_GROUP) {

		/*
		 * setters required
		 */
		adm_GROUP.setAgr_last_modified(new Timestamp(new Date().getTime()));
		try {
			adminDao.save(adm_GROUP);
			model.addAttribute("success", "Group Added successfully");
			model.addAttribute("requestedUrl", "group_list.htm");
			return "group_list";
		} catch (DaoException e) {
			String text = e.getCause().toString();
			text = text.replace("\n", "");
			System.out.println("*********************" + text);
			model.addAttribute("error", text);
			return "group_list";
		}

		// return "redirect:/admin/group/group_list.htm";
	}

	@RequestMapping(value = "/edit_group", method = RequestMethod.GET)
	public String edit_group_form(Model model,
			@RequestParam("group_code") String group_code) {
		ADM_GROUP adm_GROUP;
		try {
			adm_GROUP = adminDao.findById(group_code);
			model.addAttribute("group_bean", adm_GROUP);
			return "edit_group_form";
		} catch (DaoException e) {
			String text = e.getCause().toString();
			text = text.replace("\n", "");
			System.out.println("*********************" + text);
			model.addAttribute("error", text);
			return "edit_group_form";
		}

	}

	@RequestMapping(value = "/edit_group", method = RequestMethod.POST)
	public String edit_group_submit_form(
			@ModelAttribute("group_bean") ADM_GROUP adm_GROUP, Model model) {
		/*
		 * setters required
		 */
		adm_GROUP.setAgr_last_modified(new Timestamp(new Date().getTime()));
		try {
			adminDao.update(adm_GROUP);
			model.addAttribute("success", "Group Edited successfully");
			model.addAttribute("requestedUrl", "group_list.htm");
			return "group_list";
		} catch (DaoException e) {
			String text = e.getCause().toString();
			text = text.replace("\n", "");
			System.out.println("*********************" + text);
			model.addAttribute("error", text);
			return "group_list";
		}
		/* return "redirect:/admin/group/group_list.htm"; */

	}

	@RequestMapping(value = "/delete_group", method = RequestMethod.GET)
	public String delete_user(@RequestParam("group_code") String group_code,
			Model model) {
		try {
			adminDao.delete_group_by_code(group_code);
			model.addAttribute("success", "Group Edited successfully");
			model.addAttribute("requestedUrl", "group_list.htm");
			return "group_list";
		} catch (DaoException e) {
			String text = e.getCause().toString();
			text = text.replace("\n", "");
			System.out.println("*********************" + text);
			model.addAttribute("error", text);
			return "group_list";

		}
		/* return "redirect:/admin/group/group_list.htm"; */

	}

	@RequestMapping(value = "/group_permission", method = RequestMethod.GET)
	public String view_group_permission_by_grp_code(Model model,
			@RequestParam("group_code") String group_code) {

		// System.out.println("***************"+adminDao.findById(group_code).getAdm_GROUP_PERMISSIONSs().size());

		try {
			Map<String, String> group_permission = genericLookUp.getLookups(
					"GROUP_PERMISSIONS", "L", group_code, null);
			model.addAttribute("group_permission", group_permission);
			model.addAttribute("group", adminDao.findById(group_code));
			return "group_permission";
		} catch (DaoException e) {
			String text = e.getCause().toString();
			text = text.replace("\n", "");
			System.out.println("*********************" + text);
			model.addAttribute("error", text);
			return "group_permission";
		}

	}

	@RequestMapping(value = "/postGrpPermissionJson", method = RequestMethod.POST)
	@ResponseBody
	public String group_permission_json_submit(@RequestBody String json,
			@RequestParam("groupCode") String group_code) {

		try {
			return adminDao.save_group_permission_json(group_code, json);
		} catch (DaoException e) {
			return e.getCause().toString();

		}

	}

	@RequestMapping(value = "/delete_group_permission", method = RequestMethod.GET)
	public String delete_group_permission(Model model,
			@RequestParam("group_code") String group_code,
			@RequestParam("permission_code") String permission_code) {
		try {
			adminDao.delete_group_permission(group_code, permission_code);
		} catch (DaoException e) {
			String text = e.getCause().toString();
			text = text.replace("\n", "");
			System.out.println("*********************" + text);
			model.addAttribute("error", text);
			return "group_permission";
		}
		return "redirect:/admin/group/group_permission.htm?group_code="
				+ group_code;
	}
}
