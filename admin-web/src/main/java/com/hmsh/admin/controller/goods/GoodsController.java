package com.hmsh.admin.controller.goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.controller.BaseController;
import com.hmsh.app.vo.goods.Goods;
import com.hmsh.core.base.service.BaseFacadeService;

@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController<Goods,Long>{

	@Override
	public BaseFacadeService<Goods, Long> getService() {
		
		return null;
	}

	@Override
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("goods/index");
		return mv;
	}

}
