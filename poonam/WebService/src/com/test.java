package com;

import org.bson.Document;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializer;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

import util.config;
import util.dbConnection;

public class test {

	public static String minTemp(String zipcode) {
		zipcode = "91722";
		MongoDatabase db = dbConnection.getDB();
		String cityName = config.getCityNameFromZip(Integer.parseInt(zipcode));
		String city = config.splitName(cityName);

//		FindIterable<Document> iteratbale = db.getCollection(dbConnection.getCollectionName())
//				.find(new Document("query.results.channel.location.city", city).append("query.created",
//						new Document("$gte", "2016-02-20T00:00:00Z").append("$lt", "2016-02-24T00:00:00Z")));
		
		
		FindIterable<Document> iteratbale = db.getCollection(dbConnection.getCollectionName()).
				find(new Document("query.results.channel.location.city", city)).
				sort(new Document("query.created", -1));
		
		
	
				
						
		
//		db.getCollection('weatherCollection').find( { $query: { "query.results.channel.location.city" : { $eq : "Acton" } } , 
//			$orderby: { "query.created" : -1 } } )

		int[] temp = new int[50];
		int i = 0;
		for (Document document : iteratbale) {

			System.out.println(document.toJson());
			
			
			JsonParser parser = new JsonParser();
			JsonObject obj = parser.parse(document.toJson()).getAsJsonObject();
			JsonObject query = obj.get("query").getAsJsonObject();
			JsonObject results = query.get("results").getAsJsonObject();
			JsonObject channel = results.get("channel").getAsJsonObject();
			JsonObject item = channel.get("item").getAsJsonObject();
			JsonArray forecast = item.get("forecast").getAsJsonArray();	
			
			
			System.out.println("---------------------");
			System.out.println(forecast.toString());
			
			break;
// for temp------------------------------------------
//			JsonParser parser = new JsonParser();
//			JsonObject obj = parser.parse(document.toJson()).getAsJsonObject();
//			JsonObject query = obj.get("query").getAsJsonObject();
//			JsonObject results = query.get("results").getAsJsonObject();
//			JsonObject channel = results.get("channel").getAsJsonObject();
//			JsonObject item = channel.get("item").getAsJsonObject();
//			JsonObject condition = item.get("condition").getAsJsonObject();
//			int temp1 = condition.get("temp").getAsInt();

//			temp[i] = temp1;
//			i++;
//
//			System.out.println("------------------------");
			//System.out.println(temp1);

		}

//		int total = 0;
//		for (int j = 0; j < 7; j++) {
//
//			total = total + temp[j];
//			System.out.print(temp[j] + ", ");
//		}
//		float avg = total / 7;
//		
//		int min = temp[0];
//		for (int j = 0; j < 7; j++) {
//			if (temp[j] < min)
//			{
//				min = temp[j];
//			}
//			
//			System.out.print(temp[j] + ", ");
//		}
//		

		return "hiii";

	}

	public static void main(String[] args) {

		minTemp("");

	}

}
