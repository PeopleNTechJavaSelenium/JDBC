package mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
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
	public MongoDatabase connectMongoRemote(String databaseName){
		MongoClient mClient = new MongoClient();
		mdb = mClient.getDatabase(databaseName);
		System.out.println("mongodb is connected");
		return mdb;
	}
	public void insert(String databaseName,String collectionName,String newsType, String writerName, String date){
		mdb = connectMongoRemote(databaseName);
		MongoCollection mCollection = mdb.getCollection(collectionName);
		Document doc = new Document().append("news",newsType).append("writer", writerName).append("date", date);
		mCollection.insertOne(doc);
	}
	public List<Document> getMongoDBData(String databaseName, String collectionName){
		List<Document> list = new ArrayList<Document>();
		mdb = connectMongo(databaseName);
		MongoCollection coll = mdb.getCollection(collectionName);	
		List<Document> docList = ((List<Document>)coll.find().into(new ArrayList<Document>()));
		for(Document doc:docList){
			list.add(doc);
		}
		
		return list;
	}

}
