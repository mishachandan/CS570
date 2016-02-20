package rmi.Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import util.config;
import util.dbConnection;

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
public class RMIServer extends UnicastRemoteObject implements WeatherImpl {

	protected RMIServer() throws RemoteException {

	}

	public String getData(int zip) throws RemoteException {

		String city = config.getCityNameFromZip(zip);
		
		System.out.println("---city name = "+ city);
		String query = "select * from geo.places where text=\"" + city + "\"";
		String url;
		URL myURL;

		try {
			url = config.getURL() + URLEncoder.encode(query, "UTF-8")
					+ "&format=json&env=store://datatables.org/alltableswithkeys";
			myURL = new URL(url);

			// http connection to url and get weather data for city
			String result = config.getCityWeatherData(myURL);

			return result;

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		String msg = "Poonam ";
		return "Hello " + msg;
	}

	public static void main(String args[]) {
		try {

			RMIServer obj = new RMIServer();
			RMIServer obj2 = new RMIServer(); // obj for storeData method

			// Bind these object instance to the name "Hello" and "Store"
			Naming.rebind("Get_Data", obj);
			Naming.rebind("Store_Data", obj2);
			System.out.println("Server Ready........");

		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}

	}

	public String storeData() throws RemoteException {

		MongoDatabase db = dbConnection.getDB();

		return null;
	}

}
