package com.hmsh.admin.wms.configurer;

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


	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		try {
			MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
			mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
			mapperScannerConfigurer.setBasePackage("com.hmsh.admin.wms.dao");
			return mapperScannerConfigurer;
		} catch (Exception e) {
			System.out.println("MapperScannerConfigurer error:"+e);
		}
		return null;
	}
}
