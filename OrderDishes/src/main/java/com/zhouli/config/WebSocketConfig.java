package com.zhouli.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.zhouli.service.SpringWebSocketHandlerInterceptor;
import com.zhouli.service.WebSocket;


@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig{
	
}/*
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// TODO Auto-generated method stub
		
	}
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler(),"/websocket/socketServer.do").addInterceptors(new SpringWebSocketHandlerInterceptor());
        registry.addHandler(webSocketHandler(), "/sockjs/socketServer.do").addInterceptors(new SpringWebSocketHandlerInterceptor()).withSockJS();
    }
    @Bean
    public TextWebSocketHandler webSocketHandler(){
        return new WebSocket();
    }

}*/