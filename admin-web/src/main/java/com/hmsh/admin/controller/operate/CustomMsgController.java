package com.hmsh.admin.controller.operate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.controller.BaseController;
import com.hmsh.app.vo.system.CustomMsg;
import com.hmsh.core.base.service.BaseFacadeService;

@Controller
@RequestMapping("/msg")
public class CustomMsgController extends BaseController<CustomMsg,Long>{

	@Override
	public BaseFacadeService<CustomMsg, Long> getService() {
		
		return null;
	}

	@Override
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("operate/msg");
		return mv;
	}

}
