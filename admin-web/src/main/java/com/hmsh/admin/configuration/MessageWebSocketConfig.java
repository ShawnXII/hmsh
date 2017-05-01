package com.hmsh.admin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.hmsh.admin.socket.MessageWebSocketHandler;
import com.hmsh.admin.socket.MessageWebSocketInterceptor;

/**
 * WebSocket 配置
 * 
 * @author ShawnXII
 *
 */
@Configuration
@EnableWebSocket
public class MessageWebSocketConfig implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(messageWebSocketHandler(), "/sockjs/message")
				.addInterceptors(new MessageWebSocketInterceptor()).withSockJS();
	}

	@Bean
	public MessageWebSocketHandler messageWebSocketHandler() {
		return new MessageWebSocketHandler();
	}
}
