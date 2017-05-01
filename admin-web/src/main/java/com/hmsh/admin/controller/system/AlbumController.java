package com.hmsh.admin.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.controller.BaseController;
import com.hmsh.admin.vo.system.Album;
import com.hmsh.core.base.service.BaseFacadeService;

/**
 * 相册
 * 
 * @author ShawnXII
 *
 */
@Controller
@RequestMapping("/album")
public class AlbumController extends BaseController<Album, Long> {

	@Override
	public BaseFacadeService<Album, Long> getService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("system/album");
		return mv;
	}

}
