package com.multi.mongoDB13;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;
import java.util.concurrent.TimeUnit;
import org.bson.Document;
import com.mongodb.client.FindIterable;

public class MongoTest1 {

	public static void main(String[] args) {
		Bson filter = new Document("office", "InnoZ");
		//몽고DB프로그램
		//DB --> Collection(table) --> Document(JSON, row) --> Field(column)
		MongoClient mongoClient = new MongoClient(
		    new MongoClientURI(
		        "mongodb://localhost:27017/"
		    )
		);
		MongoDatabase database = mongoClient.getDatabase("shop");
		MongoCollection<Document> collection = database.getCollection("memo");
		FindIterable<Document> result = collection.find(filter);
		System.out.println(result.first());
		System.out.println(result.first().getString("name"));
		System.out.println(result.first().getInteger("age"));
		System.out.println(result.first().getString("office"));
		System.out.println(result.first().getString("phone"));
	}

}
