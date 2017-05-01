package com.hmsh.admin.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import com.hmsh.admin.configuration.ApplicationStartup;

/**
 * 
 * @author ShawnXII
 *
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.hmsh.admin"})
@ImportResource(locations={"dubbo/dubbo.xml"})
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class AdminWebBootstrap implements EmbeddedServletContainerCustomizer{
	
	private static final Logger log = LoggerFactory.getLogger(AdminWebBootstrap.class);

	public static void main(String[] args) {
		try {
			log.info("################AdminWebBootstrap准备启动服务！################");
			System.getProperties().load(AdminWebBootstrap.class.getClassLoader().getResourceAsStream("application.properties"));
			if (System.getProperty("os.name").toLowerCase().contains("linux")) {
				System.setProperty("java.security.egd", "file:/dev/./urandom");
			}
			SpringApplication springApplication =new SpringApplication(AdminWebBootstrap.class);
			springApplication.addListeners(new ApplicationStartup());
			springApplication.run(args);
			log.info("################AdminWebBootstrap服务启动成功！################");
		}catch (Throwable t){
			log.error("########################AdminWebBootstrap服务启动失败！########################", t);
		}
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		int port = Integer.parseInt(System.getProperty("server.port", "8082"));
		container.setPort(port);
	}

}
