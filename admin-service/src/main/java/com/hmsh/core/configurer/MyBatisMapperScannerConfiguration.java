package com.hmsh.core.configurer;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis扫描接口
 * 
 * @author ShawnXII
 *
 */
@Configuration
@AutoConfigureAfter(MyBatilsConfiguration.class)
public class MyBatisMapperScannerConfiguration {

	private String getBasePackage(String type) {
		StringBuffer basePackage = new StringBuffer();
		if ("admin".equals(type)){
			basePackage.append("com.hmsh.admin.dao");
		}
		if ("app".equals(type)){
			basePackage.append("com.hmsh.app.dao");
		}
		return basePackage.toString();
	}

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		try {
			MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
			mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
			mapperScannerConfigurer.setBasePackage(getBasePackage("admin"));
			return mapperScannerConfigurer;
		} catch (Exception e) {
			System.out.println("MapperScannerConfigurer error:"+e);
		}
		return null;
	}

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer1() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("appSqlSessionFactory");
		mapperScannerConfigurer.setBasePackage(getBasePackage("app"));
		return mapperScannerConfigurer;
	}

}
