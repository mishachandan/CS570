package example.Hello;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

	private Client() {
	};

	public static void main(String args[]) {
		String host = (args.length < 1) ? null : args[0];

		// System.setSecurityManager(new RMISecurityManager());

		try {

			String[] names = Naming.list("//" + "localhost" + "/");
			System.out.println("len == " + names.length);
			for (int i = 0; i < names.length; i++)
				System.out.println("******" + names[i]);

			Hello obj = (Hello) Naming.lookup("Hello"); // objectname in registry
												
			
			Hello obj2 = (Hello) Naming.lookup("Store");
			
			System.out.println(obj.getData());
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
