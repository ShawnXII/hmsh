package com.hmsh.core.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import com.hmsh.admin.service.user.AccountService;

@SpringBootApplication
@ComponentScan("com.hmsh")
//@ImportResource(locations = "classpath:dubbo/dubbo.xml")
public class AdminBootstrap {

	private static final Logger log = LoggerFactory.getLogger(AdminBootstrap.class);

	private static volatile boolean running = true;
	private static ConfigurableApplicationContext context;
	

	
	public static void main(String[] args) {
		try{
			log.info("################AdminBootstrap准备启动服务！################");
			context = new SpringApplicationBuilder().sources(AdminBootstrap.class).web(false).run(args);
			AccountService service=context.getBean(AccountService.class);
			System.out.println(service.loadUserByUsername("admin"));
			context.start();     
			log.info("################AdminBootstrap服务启动成功！################");
			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
					if (context != null) {
						context.stop();
						context.close();
						context = null;
					}
					log.info("################AdminBootstrap服务已经停止!################");
					synchronized (AdminBootstrap.class) {
						running = false;
						AdminBootstrap.class.notify();
					}
				}
			});

			synchronized (AdminBootstrap.class) {
				while (running) {
					try {
						AdminBootstrap.class.wait();
					} catch (Throwable e) {
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
