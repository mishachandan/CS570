package util;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class dbConnection {

	private static String dbName = "weatherdb";

	public static MongoDatabase getDB() {
		// To connect to mongodb server
		MongoClient mongoClient = new MongoClient("localhost", 27017);

		MongoDatabase database = mongoClient.getDatabase(dbName);

		System.out.println("Connect to database successfully");
		
		return database;
	}

	//insertDocument();

}
