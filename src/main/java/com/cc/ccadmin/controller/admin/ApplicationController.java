package com.cc.ccadmin.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.ccadmin.dao.admin.IApplicationParamDao;
import com.cc.ccadmin.exception.DaoException;
import com.cc.ccadmin.model.admin.BAS_APPLICATION_PARAMETERS;

@Controller
@RequestMapping("/admin/application")
public class ApplicationController {

	@Autowired
	private IApplicationParamDao<BAS_APPLICATION_PARAMETERS, String> appParamDao;

	@RequestMapping(value = "/app_param_list", method = RequestMethod.GET)
	public String appParamList(Model model) {
		try {
			//appParamDao.bulk_insert_applications();
			//appParamDao.bulk_insert_app_parameters();
			model.addAttribute("appParamList", appParamDao.findAll());
		} catch (DaoException e) {
			String text =  e.getCause().toString();
			text=text.replace("\n", "");			
			model.addAttribute("error", text);
		}
		return "app_param_list";
	}

	@RequestMapping(value = "/updateAppParamValues", method = RequestMethod.POST)
	public @ResponseBody
	String saveMapMsgFields(Model model, @RequestBody String string) {
		try {			
			appParamDao.updateAppParamVal(string);
			return "true";

		} catch (DaoException e) {
			return e.getCause().toString();
		}

	}

}
