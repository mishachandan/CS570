package rmi.Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.Server.WeatherImpl;
import util.dbConnection;

public class RMIClient {

	private RMIClient() {
	};
	
	public static String getDataByZip(String zip) 
	{
		int zipcode = Integer.parseInt(zip);
		WeatherImpl obj;
		try {
			obj = (WeatherImpl) Naming.lookup("Get_Data");
			String result = obj.getData(zipcode);
			return result;
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static void main(String args[]) {
				
		String host = (args.length < 1) ? null : args[0];

		try {

//			//displaying objects registerd in registry
//			String[] names = Naming.list("//" + "localhost" + "/");
//			System.out.println("len == " + names.length);
//			for (int i = 0; i < names.length; i++)
//				System.out.println("******" + names[i]);

			WeatherImpl obj = (WeatherImpl) Naming.lookup("Get_Data"); // looking for objectname in registry									
			WeatherImpl obj2 = (WeatherImpl) Naming.lookup("Store_Data");
			WeatherImpl obj3 = (WeatherImpl) Naming.lookup("fetch_data_all");
			
			
			
			System.out.println("--------------------------------------------");
			String result = obj.getData(91722); //get the hard coded zip value from UI
			System.out.println(result); 
			System.out.println("--------------------------------------------");
	
			boolean val = obj2.storeData(result);	
			if(val)
				System.out.println("stored success"); 
			else
				System.out.println("stored err"); 
			
			// fetch weather for all cities in the list
		    boolean val1 = obj3.fetchDataAll(); 
		    if(val1)
				System.out.println("stored all success"); 
			else
				System.out.println("stored all err"); 

		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}

	}

}
