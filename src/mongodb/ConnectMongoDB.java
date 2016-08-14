package mongodb;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ConnectMongoDB {
	MongoDatabase mdb = null;
	
	public MongoDatabase connectMongo(String databaseName){
		MongoClient mClient = new MongoClient();
		mdb = mClient.getDatabase(databaseName);
		System.out.println("mongodb is connected");
		return mdb;
	}
	public void insert(String collectionName,String newsType, String writerName){
		MongoCollection mCollection = mdb.getCollection(collectionName);
		Document doc = new Document().append("news",newsType).append("writer", writerName);
		mCollection.insertOne(doc);
	}

}
