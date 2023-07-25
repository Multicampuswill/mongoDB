package com.multi.mongoDB13;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.bson.Document;
import com.mongodb.client.FindIterable;

public class MongoTest8 {

	public static void main(String[] args) {
		//몽고DB프로그램
		//DB --> Collection(table) --> Document(JSON, row) --> Field(column)
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("shop");
		MongoCollection<Document> collection = database.getCollection("memo");
		
	
		//rdb(row) --> mongodb(document) --> java(json, Document) 
		//java(json list, List)
		List<Document> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Document doc = new Document();//json
			//age:500 name:song, office:busan, phone:011
			doc.append("age", 500 + i);
			doc.append("name", "song" + i);
			doc.append("office", "busan" + i);
			doc.append("phone", "011" + i);
			list.add(doc);
		}
		
		//객체생성시 클래스(틀) ---> 틀을 가지고 부품을 찍어서 만들어서 씀
		//new는 클래스로 부품(object)을 만들어라.
		//인터페이스 - 틀에서는 이런 기능이 필요해! 탈수기능필요()
		//             기능이 필요하다는 정의만 되어있음. 
		//             구체적으로 실행하는 코드가 인터페이스에는 없음.
		//             인터페이스는 객체를 생성할 수 없다. 
		collection.insertMany(list);
		System.out.println("insertMany성공!!!");
		mongoClient.close();
	}
}
