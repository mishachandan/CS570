package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class config {

	private static List<Cities> laCountyCities = new ArrayList<Cities>();
	private static String URL = "http://query.yahooapis.com/v1/public/yql?q=";
	
	
	public static void setCityList() {
		laCountyCities.add(new Cities("Acton, ca", 93510));
		laCountyCities.add(new Cities("Agoura Hills, ca", 91301));
		laCountyCities.add(new Cities("Beverly Hills, ca", 90210));
		laCountyCities.add(new Cities("Burbank, ca", 91501));
		laCountyCities.add(new Cities("Covina, ca", 91722));
		laCountyCities.add(new Cities("Culver City, ca", 90066));
		laCountyCities.add(new Cities("Diamond Bar, ca", 91765));
		laCountyCities.add(new Cities("Green Valley, ca", 91350));
		laCountyCities.add(new Cities("Lakewood, ca", 90712));

		// return (ArrayList<Cities>) laCountyCities;

	}

	public static String getCityNameFromZip(int zip) {
		setCityList();
		System.out.println("len of city list=" + laCountyCities.size() );
		System.out.println("\nzip code passed = "+zip);
		
		Iterator<Cities> iterator = laCountyCities.iterator();
		 while(iterator.hasNext())
		 {
			 Cities city = (Cities) iterator.next();
			 System.out.println("zip code in obj ="+city.getZipCode()+"\n" );
			 if (city.getZipCode() == zip)
					return city.getCityName();
			 
		 }
			 
		return null;

	}

	public static String getURL() {
		return URL;
	}

	public static void setURL(String uRL) {
		URL = uRL;
	}
	
	
	public static String getCityWeatherData(URL myURL)
	{
		System.out.println("---- my url value = "+myURL);
		try
		{
			HttpURLConnection connection;
			connection = (HttpURLConnection) myURL.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder results = new StringBuilder();
			String line;
			//String finalResult ="";
			while ((line = reader.readLine()) != null) {
				results.append(line);
				//connection.disconnect();
				//System.out.println("--------------------------------------------");
				//System.out.println(results.toString());
				//finalResult = finalResult + results.toString();
				//return results.toString();
				//System.out.println("--------------------------------------------");
			}
			
			return results.toString();
		}
			catch (UnsupportedEncodingException e) {
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
		return null;
	}
		
	
	

}
