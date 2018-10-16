package com.zhouli.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.Session;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
public class WebSocket{
	
}
/*@Component

public class WebSocket extends TextWebSocketHandler {
	private WebSocketSession session;
	private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();
    private static final ArrayList<WebSocketSession> users;//这个会出现性能问题，最好用Map来存储，key用userid
    private static Logger logger = Logger.getLogger(WebSocket.class);
    static {
        users = new ArrayList<WebSocketSession>();
    }
    
    public WebSocket() {
        // TODO Auto-generated constructor stub
    }

    *//**
     * 连接成功时候，会触发页面上onopen方法
     *//*
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // TODO Auto-generated method stub
        this.session =session;
        webSocketSet.add(this);
        //这块会实现自己业务，比如，当用户登录后，会把离线消息推送给用户
        //TextMessage returnMessage = new TextMessage("你将收到的离线");
        //session.sendMessage(returnMessage);
    }
    
    *//**
     * 关闭连接时触发
     *//*
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        
    	webSocketSet.remove(this);
    	  System.out.println("22222222222客戶端发来消息");
    	logger.debug("websocket connection closed......");
        String username= (String) session.getAttributes().get("WEBSOCKET_USERNAME");
        System.out.println("用户"+username+"已退出！");
        users.remove(session);
        System.out.println("剩余在线用户"+users.size());
    }

    *//**
     * js调用websocket.send时候，会调用该方法
     *//*
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("客戶端发来消息");
        try {
        	
        }catch(Exception e) {
        	
        }
    }

 public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
       
    	if(session.isOpen()){session.close();}
        logger.debug("websocket connection closed......");
        users.remove(session);
    }

    public boolean supportsPartialMessages() {
        return false;
    }
    
    
    *//**
     * 给某个用户发送消息
     *
     * @param userName
     * @param message
     *//*
    public void sendMessageToUser(String userName, TextMessage message) {
        for (WebSocketSession user : users) {
            if (user.getAttributes().get("WEBSOCKET_USERNAME").equals(userName)) {
                try {
                    if (user.isOpen()) {
                        user.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
    
    *//**
     * 给所有在线用户发送消息
     *
     * @param message
     *//*
    public void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession user : users) {
            try {
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}*/