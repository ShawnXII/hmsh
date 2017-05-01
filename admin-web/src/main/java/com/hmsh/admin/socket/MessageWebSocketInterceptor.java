package com.hmsh.admin.socket;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

/**
 * 可以在websocket建立之间和之后做一些事情
 * 
 * @author ShawnXII
 *
 */
public class MessageWebSocketInterceptor implements HandshakeInterceptor {

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception arg3) {

	}

	
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		if (request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			String siteId = servletRequest.getServletRequest().getParameter("siteId");
			String userId = servletRequest.getServletRequest().getParameter("userId");
			if (siteId == null || userId == null) {
				return false;
			}
			attributes.put("siteId", siteId);
			attributes.put("userId", userId);
		}
		return true;
	}

}
