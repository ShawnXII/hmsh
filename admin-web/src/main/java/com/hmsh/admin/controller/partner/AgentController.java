package com.hmsh.admin.controller.partner;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.controller.BaseController;
import com.hmsh.app.vo.user.Agent;
import com.hmsh.core.base.service.BaseFacadeService;

@Controller
@RequestMapping("/agent")
public class AgentController extends BaseController<Agent, Long>{

	@Override
	public BaseFacadeService<Agent, Long> getService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("partner/agent");
		return mv;
	}
}
