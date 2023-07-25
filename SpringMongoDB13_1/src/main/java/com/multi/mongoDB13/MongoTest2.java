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

public class MongoTest2 {

	public static void main(String[] args) {
		//몽고DB프로그램
		//DB --> Collection(table) --> Document(JSON, row) --> Field(column)
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("shop");
		MongoCollection<Document> collection = database.getCollection("memo");
		Document doc = new Document();//json
		//age:500 name:song, office:busan, phone:011
		doc.append("age", 500);
		doc.append("name", "song");
		doc.append("office", "busan");
		doc.append("phone", "011");

		collection.insertOne(doc);
		System.out.println("insertOne성공!!!");
	}

}
