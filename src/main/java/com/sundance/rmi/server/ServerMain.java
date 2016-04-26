package com.sundance.rmi.server;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.sundance.rmi.server.impl.MessageImpl;
 
public class ServerMain {
     
    public static void main(String[] args) throws UnknownHostException {
    	
    	String hostname = InetAddress.getLocalHost().getHostAddress();
    	System.out.println("this host IP is " + hostname);
        
    	try {
			MessageImpl obj = new MessageImpl();
			Message stub = (Message) UnicastRemoteObject.exportObject(obj, 0);

			// Bind the remote object's stub in the registry
			// run 'rmiregistry 1099' under directory target/classes 
			Registry registry = LocateRegistry.getRegistry();
			// create a new service named message
			registry.bind("message", stub);

		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
        
        System.out.println("Server is ready");
        
    }
}
