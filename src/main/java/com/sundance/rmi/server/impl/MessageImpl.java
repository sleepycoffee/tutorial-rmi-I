package com.sundance.rmi.server.impl;

import java.rmi.RemoteException;

import com.sundance.rmi.server.Message;

public class MessageImpl implements Message {

	public MessageImpl() throws RemoteException {   
		
	}

	public void sayHello(String name) throws RemoteException {
		System.out.println("Hello " + name);
	}

}