package com.hmsh.core.configurer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import com.hmsh.core.tool.Commutil;


/**
 * MyBatils基础配置
 * @author ShawnXII
 */
@Configuration
@EnableTransactionManagement
@ConfigurationProperties(prefix="mybatils")
public class MyBatilsConfiguration implements TransactionManagementConfigurer{
	
	//App数据源配置
	@Resource(name = "appDataSource")
	private DruidDataSource appDataSource;
	
	//后台的数据源配置
	@Resource(name = "primaryDataSource")
	private DruidDataSource adminDataSource;
	
	
	//配置
	private List<Map<String, String>> config=new ArrayList<>();
	/**
	 * 分页插件
	 * @return
	 */
    private  PageHelper creatPage(){
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("offsetAsPageNum", "true");
		properties.setProperty("rowBoundsWithCount", "false");
		properties.setProperty("pageSizeZero", "true");
		properties.setProperty("reasonable", "true");
		properties.setProperty("supportMethodsArguments", "true");
		properties.setProperty("returnPageInfo", "check");
		pageHelper.setProperties(properties);
		return pageHelper;
	}
    
	/**
	 * 获取SqlSessionFactory
	 * @param type
	 * @return
	 */
	private SqlSessionFactory getSqlSessionFactoryBean(String type){
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		Iterator<Map<String,String>> ite=config.iterator();
		Map<String,String> map=null;
		while(ite.hasNext()){
			map=ite.next();
			String name=map.get("name");
			if(type.equals(name)){
				break;
			}
		}
		if(map==null){
			map=config.get(0);
		}
		if(map==null){
			throw new IllegalArgumentException("请配置MyBatils");
		}
		DruidDataSource dataSource=adminDataSource;
		if(type.equals("app")){
			dataSource=this.appDataSource;
		}
		bean.setDataSource(dataSource);
		bean.setTypeAliasesPackage(Commutil.null2String(map.get("typeAliasesPackage")));
		bean.setPlugins(new Interceptor[]{creatPage()});
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			bean.setConfigLocation(resolver.getResource(Commutil.null2String(map.get("configLocation"))));
			bean.setMapperLocations(resolver.getResources(Commutil.null2String(map.get("mapperLocations"))));
			return bean.getObject();
		} catch (Exception e) {
			System.out.println("SqlSessionFactory error:"+e);
			throw new IllegalArgumentException(e);
		}
	}
	                                                     
	
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean() {
		return getSqlSessionFactoryBean("admin");
	}
	
	@Bean(name = "sqlSessionTemplate")
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(this.adminDataSource);
		return transactionManager;
	}
	
	@Bean(name = "appSqlSessionFactory")
	public SqlSessionFactory appSqlSessionFactoryBean() {
		return getSqlSessionFactoryBean("app");
	}
	
	@Bean(name = "appSqlSessionTemplate")
	public SqlSessionTemplate appSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	@Bean(name = "appTransactionManager")
	public PlatformTransactionManager appTransactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(this.appDataSource);
		return transactionManager;
	}
	

	public List<Map<String, String>> getConfig() {
		return config;
	}


	public void setConfig(List<Map<String, String>> config) {
		this.config = config;
	}

	/*
	 * 实现接口 TransactionManagementConfigurer 方法，其返回值代表在拥有多个事务管理器的情况下默认使用的事务管理器
	 * (non-Javadoc)
	 * @see org.springframework.transaction.annotation.TransactionManagementConfigurer#annotationDrivenTransactionManager()
	 */
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return transactionManager();
	}
	
}
