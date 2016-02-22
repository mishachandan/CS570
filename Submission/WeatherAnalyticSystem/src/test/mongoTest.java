package test;

import java.util.Set;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class mongoTest {
	
	
//	public static boolean collectionExists(final String collectionName, MongoDatabase db) {
//	    @SuppressWarnings("unchecked")
//		Set<String> collectionNames = (Set<String>) db.listCollectionNames();
//	    for (final String name : collectionNames) {
//	        if (name.equalsIgnoreCase(collectionName)) {
//	            return true;
//	        }
//	    }
//	    return false;
//	}

	public static void main(String args[]) {
		try
		{
			
		String st = "{\"name\": {\"fname\": \"poo\", \"lname\":\"lakhan\", \"address\": { \"street\": \"18537,east arr\", \"city\": \"covina\"}}, \"dob\": \"31-mar-88\"}" ;	
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);

		MongoDatabase db = mongoClient.getDatabase("mongoTest");
		System.out.println("Connect to database successfully");
				
		
			//db.createCollection("coll1");
		MongoCollection<Document> collection = db.getCollection("coll1");
		
		
		Document doc = Document.parse(st);
		collection.insertOne(doc);
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
