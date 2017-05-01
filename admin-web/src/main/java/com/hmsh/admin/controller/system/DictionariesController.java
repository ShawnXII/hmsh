package com.hmsh.admin.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.controller.BaseController;
import com.hmsh.admin.vo.system.Dictionaries;
import com.hmsh.core.base.service.BaseFacadeService;

@Controller
@RequestMapping("/dictionaries")
public class DictionariesController extends BaseController<Dictionaries,Long>{

	@Override
	public BaseFacadeService<Dictionaries, Long> getService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("system/dictionaries/index");
		return mv;
	}

}
