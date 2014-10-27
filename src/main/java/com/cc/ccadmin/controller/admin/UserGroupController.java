package com.cc.ccadmin.controller.admin;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cc.ccadmin.dao.admin.IGroupDao;
import com.cc.ccadmin.dao.admin.IUserDao;
import com.cc.ccadmin.dao.admin.IUserGroupDao;
import com.cc.ccadmin.exception.DaoException;
import com.cc.ccadmin.model.admin.ADM_GROUP;
import com.cc.ccadmin.model.admin.ADM_USER;
import com.cc.ccadmin.model.admin.ADM_USER_GROUP;

@Controller
@RequestMapping(value = "/admin/user-group")
public class UserGroupController {

	@Autowired
	private IUserGroupDao<ADM_USER_GROUP, String> userGroupDao;
	@Autowired
	private IUserDao<ADM_USER, String> userDao;
	@Autowired
	private IGroupDao<ADM_GROUP, String> groupDao;

	@RequestMapping(value = "/user_group_list", method = RequestMethod.GET)
	public String find_group_list(Model model) {
		try {
			model.addAttribute("user_group_list", userGroupDao.findAll());
			return "user_group_list";
		} catch (DaoException e) {
			model.addAttribute("error", e.getCause());
			return "user_group_list";
		}

	}

	@RequestMapping(value = "/add_user_group", method = RequestMethod.GET)
	public String add_user_group_new_form(Model model) {

		List<ADM_USER> adm_USERs;
		try {
			adm_USERs = userDao.findAll();
			List<ADM_GROUP> adm_GROUPs = groupDao.findAll();
			ADM_USER_GROUP adm_USER_GROUP = new ADM_USER_GROUP();
			model.addAttribute("user_group_bean", adm_USER_GROUP);
			model.addAttribute("user_list", adm_USERs);
			model.addAttribute("group_list", adm_GROUPs);
			return "add_user_group_new_form";
		} catch (DaoException e) {
			String text =  e.getCause().toString();
			text=text.replace("\n", "");
			System.out.println("*********************"+text);
			model.addAttribute("error", text);
			return "add_user_group_new_form";
		}

	}

	@RequestMapping(value = "/add_user_group", method = RequestMethod.POST)
	public String add_user_group_new_form_submit(
			@ModelAttribute("user_group_bean") ADM_USER_GROUP adm_USER_GROUP,
			HttpServletRequest request, Model model) {

		String user_name = request.getParameter("user_name");
		String group_name = request.getParameter("group_name");
		System.out.println("sdsdfsdjkfsdf   " + user_name + group_name);
		if (user_name != null && group_name != null) {
			ADM_USER adm_USER;
			try {
				adm_USER = userDao.findById(user_name);
				ADM_GROUP adm_GROUP = groupDao.findById(group_name);
				adm_USER_GROUP.setUser(adm_USER);
				adm_USER_GROUP.setGroup(adm_GROUP);
				adm_USER_GROUP.setAug_create_date(new Date());
				adm_USER_GROUP.setAug_create_user("Sushanta");
				adm_USER_GROUP.setAug_last_modified(new Timestamp(new Date()
						.getTime()));
				userGroupDao.save(adm_USER_GROUP);
				
			} catch (DaoException e) {
				String text =  e.getCause().toString();
				text=text.replace("\n", "");
				System.out.println("*********************"+text);
				model.addAttribute("error", text);
				return "redirect:/admin/user-group/user_group_list.htm";
			}
		}return "redirect:/admin/user-group/user_group_list.htm";
	}

	@RequestMapping(value = "/delete_user_group", method = RequestMethod.GET)
	public String delete_user_group(
			@RequestParam("group_code") String group_code,
			@RequestParam("user_code") String user_code,Model model) {

		try {
			userGroupDao.delete_user_group(user_code, group_code);return "redirect:/admin/user-group/user_group_list.htm";
		} catch (DaoException e) {
			String text =  e.getCause().toString();
			text=text.replace("\n", "");
			System.out.println("*********************"+text);
			model.addAttribute("error", text);
			return "redirect:/admin/user-group/user_group_list.htm";
		}
		
	}
}
