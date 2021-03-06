package com.gervasio.websockettest;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;

import java.util.ArrayList;
import java.util.List;
import com.corundumstudio.socketio.SocketIOClient;
import com.gervasio.websockettest.beans.Chat;


public class Events {
	
	private SocketIOServer server;
	private List<SocketIOClient> clients = new ArrayList<SocketIOClient>();
	
	public Events(SocketIOServer server) {
		this.server = server;
	}
	
	public void makeEvents() {
		
		this.server.addEventListener(EnumEvents.SEND_MESSAGE.toString(), Chat.class, (client, data, ackRequest) -> {
			client.sendEvent(EnumEvents.SEND_MESSAGE.toString(), data);
		});
		
		this.server.addConnectListener((client) -> {
			String uuid = client.getSessionId().toString();
			String clientIp = client.getRemoteAddress().toString();
			String clientNamespace = client.getNamespace().getName();
			System.out.println("UUID: " + client.getSessionId().toString());
			System.out.println("Remote IP: " + clientIp);
			System.out.println("Namespace: " + clientNamespace);
			clients.add(client);
			client.sendEvent(EnumEvents.SEND_MESSAGE.toString(), "NANMESPACE:");
		});
		
	}
	
}
