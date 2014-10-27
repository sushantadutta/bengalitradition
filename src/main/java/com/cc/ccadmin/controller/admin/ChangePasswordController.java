package com.cc.ccadmin.controller.admin;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cc.ccadmin.dao.admin.IUserDao;
import com.cc.ccadmin.exception.DaoException;
import com.cc.ccadmin.model.admin.ADM_USER;
import com.cc.ccadmin.util.PasswordBeanHolder;

/**
 * @see Change Password Controller
 * @author sushanta
 *
 */
@Controller
public class ChangePasswordController {

	@Autowired
	private IUserDao<ADM_USER, String> iUserDao;

	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public String changePassword(
			Model model,
			@ModelAttribute("passwordBeanHolder") PasswordBeanHolder passwordBeanHolder) {
		model.addAttribute("passwordBeanHolder", new PasswordBeanHolder());
		return "showChangePasswordForm";
	}

	/**
	 * @author sushanta
	 * @param passwordBeanHolder
	 * @return
	 */
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String persistChangedPassword(
			@ModelAttribute("passwordBeanHolder") PasswordBeanHolder passwordBeanHolder) {
		ADM_USER adm_USER = null;
		String password = null;
		/**
		 * getting username from context
		 */
		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		try {
			/**
			 * getting user from DB
			 */
			adm_USER = iUserDao.findById(userName);
			try {
				password = /*PasswordService.decrypt(adm_USER.getPassword());*/adm_USER.getAus_password();
				if (passwordBeanHolder.getExistingPasswd().equals(password)) {
					/*adm_USER.setPassword(PasswordService
							.encrypt(passwordBeanHolder.getNewPassword()));*/
					adm_USER.setAus_password(password);
					iUserDao.update(adm_USER);
				}else{
					return "redirect:/changePassword.htm";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "redirect:/j_spring_security_logout";
	}

	/**
	 * @author sushanta
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listOfPassword", method = RequestMethod.GET)
	public String userAndPasswordView(Model model) {

		List<ADM_USER> adm_USERs = null;
		Map<String, String> user_password = new LinkedHashMap<String, String>();
		try {
			adm_USERs = iUserDao.findAll();
			for (ADM_USER adm_USER : adm_USERs) {
				try {
					user_password.put(adm_USER.getAus_user_name(),adm_USER.getAus_password()
							/*PasswordService.decrypt(adm_USER.getPassword())*/);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			model.addAttribute("userAndPassword", user_password);
		} catch (DaoException e) {
			e.printStackTrace();
		}

		return "userAndPasswordView";
	}

}
