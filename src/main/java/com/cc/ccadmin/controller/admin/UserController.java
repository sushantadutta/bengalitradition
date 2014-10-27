package com.cc.ccadmin.controller.admin;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cc.ccadmin.dao.admin.IApplicationParamDao;
import com.cc.ccadmin.dao.admin.IUserDao;
import com.cc.ccadmin.exception.DaoException;
import com.cc.ccadmin.model.admin.ADM_USER;
import com.cc.ccadmin.model.admin.BAS_APPLICATION_PARAMETERS;
import com.cc.ccadmin.model.admin.BAS_LOOKUPS;
import com.cc.ccadmin.util.IGenericLookUp;

@Controller
@RequestMapping("/admin/user")
public class UserController {

	@Autowired
	private IUserDao<ADM_USER, String> adminDao;
	@Autowired
	private IGenericLookUp<BAS_LOOKUPS, String> genericLookUp;
	@Autowired
	private IApplicationParamDao<BAS_APPLICATION_PARAMETERS, String> appParamDao;

	@RequestMapping(value = "/user_list", method = RequestMethod.GET)
	public String find_user_list(Model model) {
		model.addAttribute("status",
				genericLookUp.getLookups("AUS_STATUS", "L", null, null));
		try {
			model.addAttribute("user_list", adminDao.findAll());
			return "admin-home";
		} catch (DaoException e) {
			String text = e.getCause().toString();
			text = text.replace("\n", "");
			System.out.println("*********************" + text);
			model.addAttribute("error", text);
			return "admin-home";
		}
	}

	@RequestMapping(value = "/add_user", method = RequestMethod.GET)
	public String add_user_new_form(Model model/*,
			@RequestParam("first") Integer first*/) {
		try {
			ADM_USER adm_USER = new ADM_USER();
			model.addAttribute("user_bean", adm_USER);
			model.addAttribute("appParamList", appParamDao.findAll());
			model.addAttribute("notification_flag",
					genericLookUp.getLookups("AUS_NOTIFY", "L", null, null));
			model.addAttribute("admin_flag",
					genericLookUp.getLookups("YES_NO", "L", null, null));
			model.addAttribute("status",
					genericLookUp.getLookups("AUS_STATUS", "L", null, null));

//			if (first.equals(1)) {
//				return "add_user";
//			} else {
//				return "redirect:/login/login.jsp?login_error=1";
//			}
		} catch (DaoException e) {
			String text = e.getCause().toString();
			text = text.replace("\n", "");
			model.addAttribute("error", text);
		}

		return "add_user_new_form";
	}

	@RequestMapping(value = "/add_user", method = RequestMethod.POST)
	public String add_user_submit_form(Model model, HttpServletRequest request,
			@ModelAttribute("user_bean") ADM_USER adm_USER) {
		try {

			if (request.getParameter("adminFlag") == null) {
				adm_USER.setAus_admin_flag("N");
			} else {
				adm_USER.setAus_admin_flag("Y");
			}
			adm_USER.setAus_create_date(new Date());
			adm_USER.setAus_create_user("Sushanta");
			adm_USER.setAus_end_date(new Date());
			adm_USER.setAus_last_modified(new Timestamp(new Date().getTime()));
			adm_USER.setAus_start_date(new Date());
			adm_USER.setAus_work_area("Bangalore");

			adminDao.save(adm_USER);

			model.addAttribute("success", "User Added successfully");
			model.addAttribute("requestedUrl", "user_list.htm");
//			if (request.getParameter("first").equals("1")) {
//				return "redirect:/login/login.jsp?useradded=1";
//			} else {
				return "admin-home";
//			}

		} catch (DaoException e) {
			String text = e.getCause().toString();
			text = text.replace("\n", "");
			model.addAttribute("error", text);
			return "admin-home";
		}

		// return "redirect:/admin/user/user_list.htm";
	}

	@RequestMapping(value = "/edit_user", method = RequestMethod.GET)
	public String edit_user_form(Model model,
			@RequestParam("user_code") String user_code) {
		ADM_USER adm_USER = null;

		try {
			adm_USER = adminDao.findById(user_code);
			model.addAttribute("user_bean", adm_USER);
			model.addAttribute("notification_flag",
					genericLookUp.getLookups("AUS_NOTIFY", "L", null, null));
			model.addAttribute("admin_flag",
					genericLookUp.getLookups("YES_NO", "L", null, null));
			model.addAttribute("status",
					genericLookUp.getLookups("AUS_STATUS", "L", null, null));
			return "edit_user_form";
		} catch (DaoException e) {
			String text = e.getCause().toString();
			text = text.replace("\n", "");
			System.out.println("*********************" + text);
			model.addAttribute("error", text);
			return "edit_user_form";
		}

	}

	@RequestMapping(value = "/edit_user", method = RequestMethod.POST)
	public String edit_user_submit_form(Model model,
			HttpServletRequest request,
			@ModelAttribute("user_bean") ADM_USER adm_USER) {

		try {

			adm_USER.setAus_create_date(new Date());
			adm_USER.setAus_create_user("Sushanta");
			adm_USER.setAus_end_date(new Date());
			adm_USER.setAus_last_modified(new Timestamp(new Date().getTime()));
			adm_USER.setAus_start_date(new Date());
			adm_USER.setAus_work_area("Bangalore");

			if (request.getParameter("adminFlag") == null) {
				adm_USER.setAus_admin_flag("N");
			} else {
				adm_USER.setAus_admin_flag("Y");
			}

			adminDao.update(adm_USER);
			model.addAttribute("success", "User Updated successfully");
			model.addAttribute("requestedUrl", "user_list.htm");
			return "admin-home";
		} catch (DaoException e) {
			String text = e.getCause().toString();
			text = text.replace("\n", "");
			model.addAttribute("error", text);
			return "admin-home";
		}

		// return "redirect:/admin/user/user_list.htm";
	}

	@RequestMapping(value = "/delete_user", method = RequestMethod.GET)
	public String delete_user(@RequestParam("user_code") String user_code,
			Model model) {
		try {
			adminDao.delete_user_by_code(user_code);
			return "redirect:/admin/user/user_list.htm";
		} catch (DaoException e) {
			String text = e.getCause().toString();
			text = text.replace("\n", "");
			System.out.println("*********************" + text);
			model.addAttribute("error", text);
			return "redirect:/admin/user/user_list.htm";
		}

	}
}
