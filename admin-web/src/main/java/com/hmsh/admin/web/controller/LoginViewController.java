package com.hmsh.admin.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 登录控制器
 * <br>功能:
 * <br>登录,注册,找回密码,退出登录
 * @author ShawnXII
 */
@Controller
@RequestMapping("/login")
public class LoginViewController {
	
	/**
	 * 登陆页面
	 * @param request
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login.htm",method=RequestMethod.GET)
	public String  loginView(HttpServletRequest request,HttpSession session,Model model){
		model.addAttribute("flag", true);
		if(session!=null){
			Object object=session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
			if(object!=null){
				if(object instanceof BadCredentialsException){
					BadCredentialsException e=(BadCredentialsException)object;
					String error=e.getMessage();
					model.addAttribute("flag", false);
					model.addAttribute("error", error);
				}
			}
		}
		return "login/login";
	}
	
	
	
}
