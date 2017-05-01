package com.hmsh.admin.security.support;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hmsh.admin.vo.user.Account;


/**
 * 获取当前登录用户
 * 
 * @author ShawnXII
 *
 */
public class SecurityUserHolder {

	private static final Logger log = LoggerFactory.getLogger(SecurityUserHolder.class);

	/**
	 * 获取当前登录用户
	 * 
	 * @return
	 */
	public static Account getCurrentUser() {
		Account account = null;
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			if ((SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof Account)) {
				try {
					account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				} catch (Exception e) {
					log.error("获取当前登录用户信息错误", e);
				}
			}
		}
		return account;
	}
	
	public static String getContextPath(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		return request.getContextPath();
	}
}
