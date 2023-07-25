package com.multi.mongoDB13;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class MemoDAOImpl implements MemoDAO {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public void insert(MemoDTO memoDTO) {
		//mongoTemlate에게 요청함.
		mongoTemplate.insert(memoDTO, "memo");
		//dto가 memo의 document가 될 예정.
		//dto 1개당 document 1개에 mapping
	}

	@Override
	public List<MemoDTO> list() {
		Query query = new Query();
		query.with(new Sort(Sort.Direction.DESC, "date"));
		return mongoTemplate.find(query, MemoDTO.class, "memo");
	}

	@Override
	public MemoDTO one(String _id) {
		return mongoTemplate.findById(_id, MemoDTO.class, "memo");
	}

	@Override
	public void update(MemoDTO memoDTO) {
		System.out.println("dao>> "  + memoDTO);
		//조건(filter)을 써주는 객체를 사용해야함.
		Criteria filter = new Criteria("_id"); //filter
		filter.is(memoDTO.get_id()); //==
		Query query = new Query(filter); //filter, sort, limit, project
		
		Update update = new Update();
		update.set("content", memoDTO.getContent());
		System.out.println(memoDTO);
		mongoTemplate.updateMulti(	query, 
									update, 
									MemoDTO.class, 
									"memo");
	}

	@Override
	public void delete(String _id) {
		Query query = new Query(new Criteria("_id").is(_id));
		mongoTemplate.remove(query, "memo");
	}
}
