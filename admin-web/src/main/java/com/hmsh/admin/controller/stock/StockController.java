package com.hmsh.admin.controller.stock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.controller.BaseController;
import com.hmsh.app.vo.wms.Storage;
import com.hmsh.core.base.service.BaseFacadeService;

@Controller
@RequestMapping("/stock")
public class StockController extends BaseController<Storage,Long>{

	@Override
	public BaseFacadeService<Storage, Long> getService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("stock/index");
		return mv;
	}

}
