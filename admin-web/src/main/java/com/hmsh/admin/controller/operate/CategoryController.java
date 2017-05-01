package com.hmsh.admin.controller.operate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.controller.BaseController;
import com.hmsh.app.vo.system.Category;
import com.hmsh.core.base.service.BaseFacadeService;

/**
 * 行业配置
 * 
 * @author ShawnXII
 *
 */
@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController<Category, Long> {

	@Override
	public BaseFacadeService<Category, Long> getService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("operate/category");
		return mv;
	}

}
