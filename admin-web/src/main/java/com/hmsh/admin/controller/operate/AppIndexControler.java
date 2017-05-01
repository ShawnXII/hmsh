package com.hmsh.admin.controller.operate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.controller.BaseController;
import com.hmsh.app.vo.system.AppIndexManage;
import com.hmsh.core.base.service.BaseFacadeService;

@Controller
@RequestMapping("/appindex")
public class AppIndexControler extends BaseController<AppIndexManage,Long>{

	@Override
	public BaseFacadeService<AppIndexManage, Long> getService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("operate/appindex");
		return mv;
	}

}
