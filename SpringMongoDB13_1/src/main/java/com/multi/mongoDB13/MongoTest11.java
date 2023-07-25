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

public class MongoTest11 {

	public static void main(String[] args) {


		/*
		 * Requires the MongoDB Java Driver.
		 * https://mongodb.github.io/mongo-java-driver
		 */

		Bson filter = new Document("office", "seoul");
		Bson project = new Document("age", 1L)
		    .append("name", 1L)
		    .append("office", 1L)
		    .append("_id", 0L);
		Bson sort = new Document("age", 1L);

		MongoClient mongoClient = new MongoClient(
		    new MongoClientURI(
		        "mongodb://localhost:27017/"
		    )
		);
		MongoDatabase database = mongoClient.getDatabase("shop");
		MongoCollection<Document> collection = database.getCollection("memo");
		FindIterable<Document> result = collection.find(filter)
			    .projection(project)
			    .sort(sort)
			    .limit((int)3L);
		System.out.println(result.first());
		System.out.println(result.first().get("name")); //Object
		System.out.println(result.first().getInteger("age") + 1); //Object --> Integer
		for (Document document : result) { //3 documents
			System.out.println(document.get("name") + ": " + document.getInteger("age"));
		}

	}

}
