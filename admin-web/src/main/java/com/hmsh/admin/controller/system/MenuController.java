package com.hmsh.admin.controller.system;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.configuration.ApplicationStartup;
import com.hmsh.admin.controller.BaseController;
import com.hmsh.admin.service.facade.system.MenuFacadeService;
import com.hmsh.admin.vo.system.Menu;
import com.hmsh.core.exception.ControllerException;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController<Menu,Long>{
	
	@Autowired
	private MenuFacadeService menuService;
	
	@Override
	public MenuFacadeService getService() {
		return menuService;
	}

	@Override
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		return new ModelAndView("system/menu");
	}
	
	@Override
	@RequestMapping(value = { "/query" }, method = RequestMethod.GET)
	public @ResponseBody Page<Menu> query(HttpServletRequest request, HttpSession session, Menu entity)
			throws ControllerException {
		try {
			Object obj=ApplicationStartup.getCacheData().get(ApplicationStartup.MENU_KEY);
			if(obj!=null && obj instanceof  ArrayList){
				@SuppressWarnings("unchecked")
				List<Menu> menuList=(List<Menu>) obj;
				if(menuList!=null&&menuList.size()>0){
					return new PageImpl<Menu>(menuList);
				}
			}
			return null;
		} catch (Exception e) {
			log.error("分页查询异常!", e);
			throw new ControllerException(e.getMessage());
		}
	}
	
}
