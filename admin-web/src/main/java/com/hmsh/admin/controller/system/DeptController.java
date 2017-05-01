package com.hmsh.admin.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.controller.BaseController;
import com.hmsh.admin.vo.system.Dept;
import com.hmsh.core.base.service.BaseFacadeService;

@Controller
@RequestMapping("/dept")
public class DeptController extends BaseController<Dept, Long> {

	@Override
	public BaseFacadeService<Dept, Long> getService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("system/dept");
		return mv;
	}

}
