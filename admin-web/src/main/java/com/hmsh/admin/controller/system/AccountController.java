package com.hmsh.admin.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.controller.BaseController;
import com.hmsh.admin.service.facade.user.AccountFacadeService;
import com.hmsh.admin.vo.user.Account;

public class AccountController extends BaseController<Account, Long>{
	
	@Autowired
	private AccountFacadeService accountService;
	
	@Override
	public AccountFacadeService getService() {
		return accountService;
	}

	@Override
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("system/account");
		return mv;
	}

}
