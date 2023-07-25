package com.multi.mongoDB13;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemoServiceImpl implements MemoService {
	
	@Autowired
	MemoDAO dao;
	
	@Override
	public void insert(MemoDTO memoDTO) {
		//insert db처리하기전 전처리 있으면 하세요.!
		//날짜 넣는 전처리 
		memoDTO.setDate(new Date());
		dao.insert(memoDTO);
	}

	@Override
	public List<MemoDTO> list() {
		return dao.list();
	}

	@Override
	public MemoDTO one(String _id) {
		return dao.one(_id);
	}

	@Override
	public void update(MemoDTO memoDTO) {
		System.out.println(memoDTO);
		dao.update(memoDTO);
	}

	@Override
	public void delete(String _id) {
		dao.delete(_id);
		
	}
}
