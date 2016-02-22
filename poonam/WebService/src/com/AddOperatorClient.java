package com;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

public class AddOperatorClient {

	public static void main(String[] args) throws RemoteException {
		AddOperatorStub stub = new AddOperatorStub();
		AddOperatorStub.Add add  = new AddOperatorStub.Add();
		add.setX(4);
		add.setY(7);
		System.out.println(stub.add(add).get_return());
	}
}
