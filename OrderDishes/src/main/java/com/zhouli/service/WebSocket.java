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
    private static final ArrayList<WebSocketSession> users;//���������������⣬�����Map���洢��key��userid
    private static Logger logger = Logger.getLogger(WebSocket.class);
    static {
        users = new ArrayList<WebSocketSession>();
    }
    
    public WebSocket() {
        // TODO Auto-generated constructor stub
    }

    *//**
     * ���ӳɹ�ʱ�򣬻ᴥ��ҳ����onopen����
     *//*
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // TODO Auto-generated method stub
        this.session =session;
        webSocketSet.add(this);
        //����ʵ���Լ�ҵ�񣬱��磬���û���¼�󣬻��������Ϣ���͸��û�
        //TextMessage returnMessage = new TextMessage("�㽫�յ�������");
        //session.sendMessage(returnMessage);
    }
    
    *//**
     * �ر�����ʱ����
     *//*
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        
    	webSocketSet.remove(this);
    	  System.out.println("22222222222�͑��˷�����Ϣ");
    	logger.debug("websocket connection closed......");
        String username= (String) session.getAttributes().get("WEBSOCKET_USERNAME");
        System.out.println("�û�"+username+"���˳���");
        users.remove(session);
        System.out.println("ʣ�������û�"+users.size());
    }

    *//**
     * js����websocket.sendʱ�򣬻���ø÷���
     *//*
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("�͑��˷�����Ϣ");
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
     * ��ĳ���û�������Ϣ
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
     * �����������û�������Ϣ
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