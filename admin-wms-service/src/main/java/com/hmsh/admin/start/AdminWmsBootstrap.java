package com.hmsh.admin.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@ComponentScan("com.hmsh.admin")
@ImportResource(locations = "classpath:dubbo/dubbo.xml")
public class AdminWmsBootstrap {

	private static final Logger log = LoggerFactory.getLogger(AdminWmsBootstrap.class);

	private static volatile boolean running = true;
	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {

		log.info("################AdminWmsBootstrap准备启动服务！################");
		context = new SpringApplicationBuilder().sources(AdminWmsBootstrap.class).web(false).run(args);
		context.start();
		log.info("################AdminWmsBootstrap服务启动成功！################");
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				if (context != null) {
					context.stop();
					context.close();
					context = null;
				}
				log.info("################AdminWmsBootstrap服务已经停止!################");
				synchronized (AdminWmsBootstrap.class) {
					running = false;
					AdminWmsBootstrap.class.notify();
				}
			}
		});

		synchronized (AdminWmsBootstrap.class) {
			while (running) {
				try {
					AdminWmsBootstrap.class.wait();
				} catch (Throwable e) {
				}
			}
		}
	}
}
