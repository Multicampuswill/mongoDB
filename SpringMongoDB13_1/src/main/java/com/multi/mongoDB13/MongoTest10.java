package com.multi.mongoDB13;
import java.util.ArrayList;
import java.util.List;

import org.bson.BSON;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;

public class MongoTest10 {

	public static void main(String[] args) {
		//몽고DB프로그램
		//DB --> Collection(table) --> Document(JSON, row) --> Field(column)
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("shop");
		MongoCollection<Document> collection = database.getCollection("memo");
		
		
		//조건(filter)
		Document filter = new Document();//json
		filter.append("age", 501);
		
		//변경할 내용
		Bson set1 = Updates.set("name", "songsong2");
		Bson set2 = Updates.set("phone", "9999");
		Bson set3 = Updates.set("age", 555);
		
		//리스트로 묶어서 bson(JSON)으로 만들어라.
		ArrayList<Bson> list = new ArrayList<Bson>();
		list.add(set1);
		list.add(set2);
		list.add(set3);
		
		Bson sets = Updates.combine(list);
		
		//db에 이 쿼리를 전송 
		collection.updateOne(filter, sets);
		mongoClient.close();
		
		//System.out.println("DeleteOne성공!!!");
		System.out.println("updateOne성공!!!");
	}

}
