package rmi.Client;

import org.bson.Document;

import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

public class mongoTest {
	

	public static void main(String args[]) {
		try
		{
			
		String st = "{\"name\": {\"fname\": \"poo\", \"lname\":\"lakhan\", \"address\": { \"street\": \"18537,east arr\", \"city\": \"covina\"}}, \"dob\": \"31-mar-88\"}" ;	
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);

		MongoDatabase db = mongoClient.getDatabase("mongoTest");
		System.out.println("Connect to database successfully");
		
		//db.createCollection("coll1");
		MongoCollection<Document> collection = db.getCollection("coll1");
		
		DBObject bson = ( DBObject ) JSON.parse( st );
		collection.insertOne((Document) bson);
	
		
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
