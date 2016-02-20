package example.Hello;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.rmi.Naming;

@SuppressWarnings("serial")
public class Server extends UnicastRemoteObject implements Hello {

	protected Server() throws RemoteException {

	}

	@Override
	public String getData() throws RemoteException {

		String query = "select * from geo.places where text=\"sunnyvale, ca\"";
		String url;
		URL myURL;
		try {
			url = "http://query.yahooapis.com/v1/public/yql?q=" + URLEncoder.encode(query, "UTF-8")
					+ "&format=json&env=store://datatables.org/alltableswithkeys";

			myURL = new URL(url);
			HttpURLConnection connection;
			connection = (HttpURLConnection) myURL.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder results = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				results.append(line);
				connection.disconnect();
				System.out.println("--------------------------------------------");
				System.out.println(results.toString());
				System.out.println("--------------------------------------------");
			}
		} catch (UnsupportedEncodingException e) {
			System.err.println("UnsupportedEncodingException -- sayHello  exception : " + e.toString());
			e.printStackTrace();
		} catch (MalformedURLException e) {
			System.err.println("MalformedURLException -- sayHello  exception : " + e.toString());
			e.printStackTrace();
		} catch (ProtocolException e) {
			System.err.println("ProtocolException -- sayHello  exception : " + e.toString());
			e.printStackTrace();
		} catch (IOException e) {
			// System.err.println("IOException -- sayHello exception : " +
			// e.toString());
			// e.printStackTrace();
		}

		String msg = "Poonam ";

		return "Hello " + msg;
	}

	public static void main(String args[]) {
		try {

			Server obj = new Server();
			
			Server obj2 = new Server();	//obj for storeData method
			
			// Bind these object instance to the name "Hello" and "Store"
			
			Naming.rebind("Hello", obj);
			Naming.rebind("Store", obj2);
			System.out.println("Server Ready........");

			// Server obj = new Server();
			// Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 2001);
			//
			// //Bind the remote object's stub in the registry
			// Registry registry = LocateRegistry.getRegistry();
			// registry.bind("Hello", stub);
			
			
			
			
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}

	}

	@Override
	public String storeData() throws RemoteException {

		try {
			
			// To connect to mongodb server
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			
			MongoDatabase database = mongoClient.getDatabase("weatherdb");		
			
			System.out.println("Connect to database successfully");
			
			//mongoClient.close();
			
		} catch (Exception e) {

		}

		return null;
	}

}
