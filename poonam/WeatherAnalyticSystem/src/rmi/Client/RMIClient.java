package rmi.Client;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.Server.WeatherImpl;

public class RMIClient {

	private RMIClient() {
	};

	public static void main(String args[]) {
		String host = (args.length < 1) ? null : args[0];

		// System.setSecurityManager(new RMISecurityManager());

		try {

			String[] names = Naming.list("//" + "localhost" + "/");
			System.out.println("len == " + names.length);
			for (int i = 0; i < names.length; i++)
				System.out.println("******" + names[i]);

			WeatherImpl obj = (WeatherImpl) Naming.lookup("Get_Data"); // objectname in registry
												
			
			WeatherImpl obj2 = (WeatherImpl) Naming.lookup("Store_Data");
			System.out.println("--------------------------------------------");
			System.out.println(obj.getData(91722)); //get the hard coded zip value from UI
			System.out.println("--------------------------------------------");
			
			
			obj2.storeData();

			//
			// System.out.println(host);
			//
			// Registry registry = LocateRegistry.getRegistry(host);
			// Hello stub = (Hello) registry.lookup("Hello");

			// String response = obj.sayHello();

			// System.out.println("Response : "+response);
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}

	}

}
