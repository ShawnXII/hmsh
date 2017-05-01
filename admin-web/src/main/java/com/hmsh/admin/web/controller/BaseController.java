package com.hmsh.admin.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.hmsh.admin.core.util.Commutil;

/**
 * BaseController 公共的Controller
 * 
 * @author ShawnXII
 */
public class BaseController{
	/**
	 * 日志
	 */
	protected static final Logger log = LoggerFactory.getLogger(BaseController.class);
	/**
	 * 处理页面的公共属性
	 * @param request
	 * @param model
	 */
	protected void handelParams(HttpServletRequest request, Model model){
		String title=Commutil.null2String(request.getParameter("title"));
		String icon=Commutil.null2String(request.getParameter("icon"));
		Map<String,Object> params=new HashMap<>();
		params.put("title", title);
		params.put("icon", icon);
		model.addAttribute("params", icon);
	}

	
}
