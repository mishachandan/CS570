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

		System.out.println("---city name = " + city);
		
		// http connection to url and get weather data for city
			String result = config.getCityWeatherData(city);

			return result;

	}

	public static void main(String args[]) {
		try {

			RMIServer obj = new RMIServer(); // getdata method
			RMIServer obj2 = new RMIServer(); // obj for storeData method
			RMIServer obj3 = new RMIServer(); // for fetchall method

			// Bind these object instance to the name "Hello" and "Store"
			Naming.rebind("Get_Data", obj);
			Naming.rebind("Store_Data", obj2);
			Naming.rebind("fetch_data_all", obj3);
			
			System.out.println("Server Ready........");

		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}

	}

	public boolean storeData(String result) throws RemoteException {

		if(dbConnection.insertDocument(result))
		{	System.err.println("stored data--server");
			return true;
		}
			
		return false;
	}

	
	public boolean fetchDataAll() throws RemoteException {
		// fetch weather data for all cities daily
		if(config.fetchALL())
			return true;
		else
			return false;
		// store in db

	}

	
}
