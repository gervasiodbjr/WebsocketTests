package com.gervasio.websockettest;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;

public class App 
{
	// static Logger log = Logger.getLogger(App.class);
	
    public static void main( String[] args )
    {
        Configuration config = new Configuration();
        config.setHostname("127.0.0.1");
        config.setPort(9009);
        
        SocketConfig socketconfig = config.getSocketConfig();
        socketconfig.setReuseAddress(true);
        
        SocketIOServer server = new SocketIOServer(config);
        new Events(server).makeEvents();
        server.start();
    }
}