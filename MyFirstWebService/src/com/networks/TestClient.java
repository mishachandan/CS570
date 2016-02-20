package com.networks;

import java.rmi.RemoteException;

import com.networks.FirstWebserviceStub.AddTwoNumbers;
import com.networks.FirstWebserviceStub.AddTwoNumbersResponse;

public class TestClient {
	
	public static void main(String[] args) throws RemoteException {
		   
		  FirstWebserviceStub stub = new FirstWebserviceStub();
		  AddTwoNumbers atn = new AddTwoNumbers();
		  atn.setFirstNumber(8);
		  atn.setSecondNumber(8);
		  AddTwoNumbersResponse res = stub.addTwoNumbers(atn);
		  System.out.println(res.get_return());
		   
		 }

}
