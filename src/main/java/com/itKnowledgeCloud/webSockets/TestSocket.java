package com.itKnowledgeCloud.webSockets;

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class TestSocket {
	
	 @OnMessage
	   public void onMessage(Session session, String msg) {
	      try {
	         session.getBasicRemote().sendText(msg+" z serwera");
	      } catch (IOException e) { 
	    	  e.printStackTrace();
	      }
	   }

}
