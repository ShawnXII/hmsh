package com.hmsh.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	/**
	 * 重定向到index.htm
	 * @return
	 */
	@RequestMapping(value = { "/", ""}, method = RequestMethod.GET)
	public ModelAndView redirect() {
		ModelAndView mv = new ModelAndView("redirect:/index.htm");
		return mv;
	}
	
	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView indexView() {
		ModelAndView mv = new ModelAndView("index");
		//TODO 报表数据 
		return mv;
	}
	
	//TODO 报表接口编写
	
}
