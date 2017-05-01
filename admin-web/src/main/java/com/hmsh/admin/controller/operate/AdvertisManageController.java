package com.hmsh.admin.controller.operate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.controller.BaseController;
import com.hmsh.app.vo.system.AdvertisManage;
import com.hmsh.core.base.service.BaseFacadeService;

@Controller
@RequestMapping("/advertis")
public class AdvertisManageController extends BaseController<AdvertisManage,Long>{

	@Override
	public BaseFacadeService<AdvertisManage, Long> getService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("operate/advertis");
		return mv;
	}

}
