package rmi.Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;


public class test {
	
	public static void main(String args[]) 
	{
		try{
		
		String query = "select * from geo.places where text=\"sunnyvale, ca\"";
		String url = "http://query.yahooapis.com/v1/public/yql?q="+ URLEncoder.encode(query, "UTF-8")+"&format=json&env=store://datatables.org/alltableswithkeys";
		 URL myURL = new URL(url);
	        HttpURLConnection connection = (HttpURLConnection) myURL.openConnection();
	        connection.setRequestMethod("GET");
	        connection.setDoOutput(true);
	        connection.connect();
	        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        StringBuilder results = new StringBuilder();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            results.append(line);
	        }

	        connection.disconnect();
	        System.out.println(results.toString());

		
				
		         // To connect to mongodb server
		         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		         
		         MongoDatabase database = mongoClient.getDatabase("weatherdb");
		         
		       //  MongoCollection<Document> collection = database.getCollection("wdata");
		         mongoClient.close();
					
		}
		      catch(Exception e){
		         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      }
		
	}

}

