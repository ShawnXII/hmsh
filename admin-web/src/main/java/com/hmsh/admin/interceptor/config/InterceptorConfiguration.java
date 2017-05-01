package com.hmsh.admin.interceptor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.hmsh.admin.interceptor.MyInterceptor;

@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter{
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
	 */
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		// 注册拦截器 excludePathPatterns("") 不拦截的路径
        InterceptorRegistration ir = registry.addInterceptor(new MyInterceptor());
        ir.excludePathPatterns("/login.htm");
        //还可以在这里注册其它的拦截器
	}
	
}
