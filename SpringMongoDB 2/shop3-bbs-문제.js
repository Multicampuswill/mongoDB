db.getCollection("memo").find({})

//shop3 생성, memo3생성
/*
    1.memo3에 document 1개를 넣어서 전체검색(아래 보이는 것에서 첫번째 row처럼)
    2.memo3에 넣었던 1개를 조건으로 해서 전체검색(age가 1)
    3.memo3에 document 3개를 넣어서 전체검색(아래 보이는 것에서 2~4 row처럼)
    4.memo3에 name이 Didi인 경우, age를 100으로 변경
    5.memo3에 office가 busan인 경우, phone을 555로 변경
    6.memo3에 name이 Pier인 경우, document삭제
    7.memo3에 office가 busan인 경우, documents삭제
    8.memo3 collection삭제후, 전체 컬렉션을 검색
    9.shop3 db삭제
*/