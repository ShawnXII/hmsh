package com.hmsh.admin.security;


import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.hmsh.admin.service.facade.user.AccountFacadeService;
import com.hmsh.admin.vo.system.Role;
import com.hmsh.admin.vo.user.Account;
import com.hmsh.core.tool.Commutil;
/**
 * 自定义登录验证
 * @author ShawnXII
 *
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	protected static final org.slf4j.Logger log = LoggerFactory.getLogger(MyAuthenticationProvider.class);
	
	@Autowired
	private AccountFacadeService accountService;
	/**
	 * 自定义验证方式
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username=authentication.getName();
		String password=Commutil.null2String(authentication.getCredentials());
		log.info("################用户:"+username+"登录认证开始 ################");
		Account account=null;
		try {
			account = (Account) accountService.loadUserByUsername(username);
		} catch (UsernameNotFoundException e) {
			log.error(e.getMessage() , e);
			throw new BadCredentialsException(e.getMessage());
		}
		if(account==null){
			log.info("################用户:"+username+"登录认证结束,用户名不存在 ################");
			throw new BadCredentialsException("用户名不存在!");
		}
		String salt=account.getSalt();
		password=Commutil.encrypt(password, salt);
		if(!password.equals(account.getPassword())){
			log.info("################用户:"+username+"登录认证结束,密码错误 ################");
			throw new BadCredentialsException("密码错误");
		}
		List<Role> roles=account.getAuthorities();
		log.info("################用户:"+username+"登录认证结束 ################");
		return new UsernamePasswordAuthenticationToken(account, password, roles);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
