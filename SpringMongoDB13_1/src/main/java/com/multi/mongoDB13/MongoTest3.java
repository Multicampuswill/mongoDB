package com.multi.mongoDB13;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.bson.Document;
import com.mongodb.client.FindIterable;

public class MongoTest3 {

	public static void main(String[] args) {
		//몽고DB프로그램
		//DB --> Collection(table) --> Document(JSON, row) --> Field(column)
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("shop");
		MongoCollection<Document> collection = database.getCollection("member");
		
		Scanner sc = new Scanner(System.in);
		String id = sc.next();
		String pw = sc.next();
		String name = sc.next();
		String tel = sc.next();
		
		//rdb(row) --> mongodb(document) --> java(json, Document) 
		//java(json list, List)
		Document doc = new Document();//json
		doc.append("id", id);
		doc.append("pw", pw);
		doc.append("name", name);
		doc.append("tel", tel);
		sc.close();
		
		collection.insertOne(doc);
		System.out.println("insertOne성공!!!");
		mongoClient.close();
	}

}
