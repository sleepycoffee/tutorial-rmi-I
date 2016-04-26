package com.sundance.rmi.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.sundance.rmi.server.Message;
 
public class ClientMain {
     
    public static void main(String[] args) {
    	try {
            // fire to localhost port 1099
            Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1099);
             
            // search for myMessage service
            Message impl = (Message) myRegistry.lookup("message");
             
            // call server's method        
            impl.sayHello("Tom Brady");
             
            System.out.println("Message Sent");
        } catch (Exception e) {
            e.printStackTrace();
        }       
    }
}

