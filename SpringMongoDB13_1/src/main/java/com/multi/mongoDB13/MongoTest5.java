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

public class MongoTest5 {

	public static void main(String[] args) {
		//몽고DB프로그램
		//DB --> Collection(table) --> Document(JSON, row) --> Field(column)
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("shop");
		MongoCollection<Document> collection = database.getCollection("member");
		
		Document filter = new Document();//json
		filter.append("id", "apple");
		//조건의 결과가 많다하더라도 맨 처음 document만 삭제 
		//collection.deleteOne(filter);
		//조건의 결과가 많으면 만족하는 documents를 모두 삭제 
		collection.deleteMany(filter);
		mongoClient.close();
		
		//System.out.println("DeleteOne성공!!!");
		System.out.println("DeleteMany성공!!!");
	}

}
