package com.multi.mongoDB13;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;

public class MongoTest6 {

	public static void main(String[] args) {
		//몽고DB프로그램
		//DB --> Collection(table) --> Document(JSON, row) --> Field(column)
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("shop");
		MongoCollection<Document> collection = database.getCollection("member");
		
		
		//조건(filter)
		Document filter = new Document();//json
		filter.append("pw", "1234");
		filter.append("name", "apple2");
		//{"pw":"1234", "name":"apple2"}
		
		//변경할 내용
		Bson set1 = Updates.set("id", "final hong");
		Bson set2 = Updates.set("name", "final hong");
		//{$set: {id: 'final hong'}}
		//{$set: {name: 'final hong'}}
		
		//list로 묶어라.
		List<Bson> list = new ArrayList<>();
		list.add(set1);
		list.add(set2);
		
		//다시 bson으로 만들어주세요.
		Bson sets = Updates.combine(list);
		///{$set: [{id: 'final hong'},{name: 'final hong'}]}
		
		//db에 이 쿼리를 전송 
		collection.updateOne(filter, sets);
		mongoClient.close();
		
		//System.out.println("DeleteOne성공!!!");
		System.out.println("updateOne성공!!!");
	}

}
