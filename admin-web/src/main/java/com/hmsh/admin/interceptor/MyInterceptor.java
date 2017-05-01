package com.hmsh.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.hmsh.admin.configuration.ApplicationStartup;

public class MyInterceptor extends HandlerInterceptorAdapter{
	private static final String RETURN_TYPE="fragment";
	/*
	 * 预处理回调方法，实现处理器的预处理（如登录检查）。
     * 第三个参数为响应的处理器，即controller。
     * 返回true，表示继续流程，调用下一个拦截器或者处理器。
     * 返回false，表示流程中断，通过response产生响应。
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	/*	 String accept = request.getHeader("Accept");
		 if (accept.contains("json"))return true;
		 String path = request.getServletPath();
		 if (path.lastIndexOf(".htm") == -1)return true;*/
		 String ReturnType=request.getHeader("Return-Type");
		 if(StringUtils.isBlank(ReturnType)&&RETURN_TYPE.equals(ReturnType)){
			 //返回
			 return true;
		 }
		 return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		if(modelAndView!=null){
			modelAndView.addObject("cacheData", ApplicationStartup.getCacheData());
		}
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	private boolean isHtml(String url){
		boolean flag=false;
		String[] arr=url.split(".");
		if(arr!=null&&arr.length>1){
			String suffix=arr[arr.length-1];
			if("htm".equals(suffix)){
				flag=true;
			}
		}
		return flag;
	}
}
