package com.hmsh.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.admin.security.support.SecurityUserHolder;
import com.hmsh.admin.vo.user.Account;

@Controller
public class LoginController {
	/**
	 * 登录页面
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login.htm",method=RequestMethod.GET)
	public ModelAndView  loginView(HttpServletRequest request,HttpSession session){
		ModelAndView mv=new ModelAndView();
		Account account=SecurityUserHolder.getCurrentUser();
		if(account!=null){
			return new ModelAndView("redirect:/index.htm");
		}
		mv.setViewName("login");
		mv.addObject("flag", true);
		if(session!=null){
			Object object=session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
			if(object!=null){
				if(object instanceof BadCredentialsException){
					BadCredentialsException e=(BadCredentialsException)object;
					String error=e.getMessage();
					mv.addObject("flag", false);
					mv.addObject("error", error);
				}
			}
		}
		return mv;
	}
	/**
	 * 退出登录
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/loginOut.htm",method=RequestMethod.GET)
	public ModelAndView  loginOut(HttpServletRequest request,HttpSession session){
		ModelAndView mv=new ModelAndView();
		if(session!=null){
			//session.removeAttribute(WebSecurityConfig.SESSION_KEY);
			Object object=session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
			if(object!=null){
				if(object instanceof BadCredentialsException){
					//BadCredentialsException e=(BadCredentialsException)object;
				}
			}
		}
		return mv;
	}
}
