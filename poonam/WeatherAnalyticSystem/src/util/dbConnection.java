package util;

import org.bson.Document;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class dbConnection {

	private static String dbName = "weatherdb";
	private static String collectionName = "weatherCollection";
	private static MongoDatabase mongoDatabase;
	private static MongoClient mongoClient;

	public static MongoDatabase getDB() {

		// To connect to mongodb server
		mongoClient = new MongoClient("localhost", 27017);

		mongoDatabase = mongoClient.getDatabase(dbName);

		System.out.println("Connect to database successfully");

		// create a collection
		// mongoDatabase.createCollection(collectionName);

		mongoDatabase.getCollection(collectionName);

		// System.out.println("Created collection successfully");

		 
		return mongoDatabase;

	}

	public static boolean insertDocument(String jsonString) {
		getDB();
		//System.out.println("jsonString ==" + jsonString +"\n*****************");
		try {
			//System.out.println("----> "+mongoDatabase);
			MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);

			Document doc = Document.parse(jsonString);
			collection.insertOne(doc);
			return true;
		} catch (Exception e) {
			System.out.println("dbConnection- Exception occured : " + e.getMessage());
			e.printStackTrace();
			return false;
		}

	}
	
	//display method - get temp, description for given city for given date or 
	// if for the given data for taht particular city .. there are multiple docs the fetch the info and display table wise

	public static String getDbName() {
		return dbName;
	}

	public static String getCollectionName() {
		return collectionName;
	}

	public static MongoDatabase getMongoDatabase() {
		return mongoDatabase;
	}

	public static MongoClient getMongoClient() {
		return mongoClient;
	}

}
