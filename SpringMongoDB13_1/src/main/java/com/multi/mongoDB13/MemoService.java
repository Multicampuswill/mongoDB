package com.multi.mongoDB13;

import java.util.List;

public interface MemoService {

	List<MemoDTO> list(); 

	void insert(MemoDTO memoDTO); 

	MemoDTO one(String _id); 

	void update(MemoDTO vo); 

	void delete(String _id); 
}
