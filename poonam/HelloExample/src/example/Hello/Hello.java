package example.Hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
	
	String getData() throws RemoteException;
	
	String storeData() throws RemoteException;
	

}
