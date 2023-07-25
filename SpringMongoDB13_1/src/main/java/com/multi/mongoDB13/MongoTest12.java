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

public class MongoTest12 {

	public static void main(String[] args) {

		/*
		 * Requires the MongoDB Java Driver. https://mongodb.github.io/mongo-java-driver
		 */

		// Bson filter = new Document();
		Bson project = new Document("_id", 0L);
		Bson sort = new Document("id", -1L);

		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017/"));
		MongoDatabase database = mongoClient.getDatabase("shop");
		MongoCollection<Document> collection = database.getCollection("member");
		FindIterable<Document> result = collection.find().projection(project).sort(sort).limit((int) 20L);

		System.out.println("회원관리 명단입니다.");
		System.out.println("--------------------");
		System.out.println("id\tpw\tname\ttel");
		for (Document document : result) {
			if (document.get("id") != null) {
				System.out.println(	document.get("id") + "\t" + 
									document.get("pw") + "\t" + 
									document.get("name") + "\t" + 
									document.get("tel"));
			}
		}

	}

}
