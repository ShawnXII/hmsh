package com.hmsh.admin.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.controller.BaseController;
import com.hmsh.admin.vo.system.Resource;
import com.hmsh.core.base.service.BaseFacadeService;

@Controller
@RequestMapping("/resource")
public class ResourceController extends BaseController<Resource,Long> {
	
	
	@Override
	public BaseFacadeService<Resource, Long> getService() {		
		return null;
	}

	@Override
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("system/resource/index");
		return mv;
	}
	
	
}
