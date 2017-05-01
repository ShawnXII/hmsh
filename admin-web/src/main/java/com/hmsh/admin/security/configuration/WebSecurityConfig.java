package com.hmsh.admin.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.hmsh.admin.security.MyAuthenticationProvider;

/**
 * Spring Security
 * 
 * @author ShawnXII
 *
 */
@Configuration
@EnableWebSecurity // 禁用Boot的默认Security配置，配合@Configuration启用自定义配置（需要扩展WebSecurityConfigurerAdapter）
@EnableGlobalMethodSecurity(prePostEnabled = true) // 启用Security注解，例如最常用的@PreAuthorize
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	//private static final Logger log = Logger.getLogger(WebSecurityConfig.class);
	
	@Autowired
	private MyAuthenticationProvider provider;

	/*
	 * Web层面的配置，一般用来配置无需安全检查的路径 (non-Javadoc)
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.
	 * config.annotation.web.builders.WebSecurity)
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/assets/**");
	}
	/*
	 * Request层面的配置，对应XML Configuration中的<http>元素 (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.
	 * config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable();
		http.authorizeRequests().antMatchers("/index.htm").permitAll().
		anyRequest().authenticated().and().formLogin()
				.loginPage("/login.htm").failureUrl("/login.htm?error").
				permitAll().and().logout().logoutUrl("/loginOut.htm").deleteCookies("remember-me").
				logoutSuccessUrl("/login.htm").and().rememberMe();
	}

	/*
	 * 身份验证配置，用于注入自定义身份验证Bean和密码校验规则 (non-Javadoc)
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.
	 * config.annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
		//log.info("################登录认证开始 ################");
		//将验证过程交给自定义验证工具
		auth.authenticationProvider(provider);
		//log.info("################登录认证结束 ################");
	}
	
}
