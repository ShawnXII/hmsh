package com.hmsh.admin.wms.configurer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
import com.hmsh.admin.tool.Commutil;

/**
 * 多数据源配置
 * @author ShawnXII
 */
@Configuration
@ConfigurationProperties(prefix="customer")
public class DataSourceConfiguration  {
	
	private List<Map<String, String>> datasource=new ArrayList<>();
	
	public List<Map<String, String>> getDatasource() {
		return datasource;
	}

	public void setDatasource(List<Map<String, String>> datasource) {
		this.datasource = datasource;
	}
	/**
	 * 配置Admin数据源
	 * 默认的数据源
	 * @return
	 */
	@Bean(name = "primaryDataSource", destroyMethod = "close", initMethod = "init")
	@Primary
	public DruidDataSource primaryDataSource() {
		return newDruidDataSource("wms");
	}
	

	
	
	private DruidDataSource newDruidDataSource(String type) {
		DruidDataSource druidDataSource=new DruidDataSource();
		Iterator<Map<String,String>> ite=datasource.iterator();
		Map<String,String> map=null;
		while(ite.hasNext()){
			map=ite.next();
			String name=map.get("name");
			if(type.equals(name)){
				break;
			}
		}
		if(map==null){
			map=datasource.get(0);
		}
		if(map==null){
			throw new IllegalArgumentException("请配置数据源");
		}
		druidDataSource.setDriverClassName(map.get("driver"));
		druidDataSource.setUrl(map.get("url"));
		druidDataSource.setUsername(map.get("username"));
		druidDataSource.setPassword(map.get("password"));
		druidDataSource.setMaxActive(Commutil.null2Int(map.get("maxActive"),5));
		druidDataSource.setInitialSize(Commutil.null2Int(map.get("initialSize"),1));
		druidDataSource.setMaxWait(Commutil.null2Int(map.get("maxWait"),6000));
		druidDataSource.setMinIdle(Commutil.null2Int(map.get("minIdle"),1));
		druidDataSource.setTimeBetweenEvictionRunsMillis(Commutil.null2Int(map.get("timeBetweenEvictionRunsMillis"),3000));
		druidDataSource.setMinEvictableIdleTimeMillis(Commutil.null2Int(map.get("minEvictableIdleTimeMillis"),300000));
		druidDataSource.setValidationQuery(Commutil.null2String(map.get("validationQuery"),"SELECT 'x'"));
		druidDataSource.setTestOnBorrow(Commutil.null2Boolean(map.get("testOnBorrow"),false));
		druidDataSource.setTestOnReturn(Commutil.null2Boolean(map.get("testOnReturn"),false));
		druidDataSource.setTestWhileIdle(Commutil.null2Boolean(map.get("testWhileIdle"),true));
		druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(Commutil.null2Int(map.get("maxPoolPreparedStatementPerConnectionSize"),20));
		druidDataSource.setPoolPreparedStatements(Commutil.null2Boolean(map.get("poolPreparedStatements"),true));
		druidDataSource.setMaxOpenPreparedStatements(Commutil.null2Int(map.get("maxOpenPreparedStatements"),20));
		return druidDataSource;
	}
}
