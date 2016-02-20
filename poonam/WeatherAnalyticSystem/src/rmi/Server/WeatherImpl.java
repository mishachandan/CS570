package rmi.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface WeatherImpl extends Remote {
	
	String getData(int zip) throws RemoteException;
	
	String storeData() throws RemoteException;
	

}
