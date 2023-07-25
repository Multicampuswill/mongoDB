package com.multi.mongoDB13;

import java.util.List;

public interface MemoDAO {
	public final static double PI = 3.14;
//인터페이스의 역할
	//필요한 기능만 정의!
	//멤버메서드만 사용 가능 
	//멤버변수를 쓸 수 없다.!
	//불완전한 메서드만 사용 가능!
	//추상적 == 불완전!
	//추상메서드
	//실제로 메서드 구현은 클래스에서 
	//구체적을 한다. 
	//여러 클래스에서 공유할 목적으로 상수를
	//선언해서 사용할 수 있음. 
	public abstract void insert(MemoDTO memoDTO);
	
	List<MemoDTO> list(); 

	MemoDTO one(String _id); 

	void update(MemoDTO memoDTO); 

	void delete(String _id); 
}