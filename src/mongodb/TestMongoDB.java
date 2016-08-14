package mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.util.JSON;

public class TestMongoDB {

	public static void main(String[] args) {
		ConnectMongoDB mongo = new ConnectMongoDB();
		mongo.insert("test", "NewsContent", "USA","","08/14/2016");
		List<Document> list = new ArrayList<Document>();
		list = mongo.getMongoDBData("test", "NewsContent");
		for(Document doc:list){
			System.out.println(JSON.parse(doc.toJson()));
		}
		

	}

}
