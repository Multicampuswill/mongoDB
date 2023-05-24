use shop2
db.memo.find({})
db.memo.find({}).count()

db.memo.find({'age':1})

db.memo.find({})

db.memo.find({'name':'Tom','office':'busan'}) //default and조건
db.memo.find({$and : [{'name':'Tom'}, {'office':'busan'}]})
db.memo.find({$or : [{'name':'Tom'}, {'office':'busan'}]})

db.memo.find({'age' : {$gt : 50}})
db.memo.find({'age' : {$lt : 3}}) //1~2
db.memo.find({'age' : {$lte : 3}}) //1~3
db.getCollection("memo").find({}) //전체 검색

//select age from memo where age > 50
db.memo.find({'age' : {$gt : 50}}, {age : 1})
db.memo.find({'age' : {$gt : 50}}, {_id: 0, age : 1})
db.memo.find({'age' : {$lt : 3}}, {age : 1, phone :1}) //1~2
db.memo.find({'age' : {$lte : 3}}, {age:0}).limit(2) //1~3
//field선택시 0으로 설정하면, 설정된 field만 빼고, 다 보여주세요! 

/*
*/ 
//db.memo.find({조건}, {필드선택})
//  1. name이 Tom이고, office가 seoul인 documents의 phone은?
    db.memo.find({name : 'Tom', office : 'seoul'}, {phone : 1})
//  2. age가 10이거나 office가 Wordware인 documents의 갯수는?
    db.memo.find({$or : [{age : 10}, {office : 'Wordware'}]}, {}).count()
//  3. age가 10이거나 office가 Wordware인 documents의 name은?(sort name내림차순)
    db.memo.find({"$or": [{"age": 10.0}, {"office": "Wordware"}]}, 
                 {"name": 1.0}).sort({"name": 1.0})
    db.memo.find({$or : [{age : 10}, {office : 'Wordware'}]}, {_id : 0,name:1})
//  4. office가 busan인 documendb.getCollection("memo").find({})db.getCollection("unknown").find({})db.getCollection("unknown").find({})db.getCollection("unknown").find({})db.getCollection("unknown").find({})ts 중 _id, age빼고 모두 출력
    db.memo.find({office : 'busan'}, {_id : 0, age : 0})
//  5. office가 busan이 아닌 docudb.getCollection("unknown").find({})ments 중 office, phone은?
    db.memo.find({office : { $not : /busan/}}, {office : 1, phone : 1}).limit(3)
//  6. office가 seoul인 사람의 phone, name만 출력(수를 2개만 출력)
    db.memo.find({office : 'seoul'}, {_id : 0, office : 1, phone : 1}).limit(2)
    
db.memo.find({'name':'Garry'}) //select

var memo_find_result = db.memo.find({})

db.memo.find({'office' : {$not : /busan/}}).limit(3)


