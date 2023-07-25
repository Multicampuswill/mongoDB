<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL(Java Standard Tag Library) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<form action="update.memo">
<table border="1" width="800px">
    <tr bgcolor="lime">
        <th>번호</th>
        <th>작성자</th>
        <th>내용</th>
        <th>날씨</th>
        <th>날짜</th>
    </tr>
	    <tr bgcolor="pink">
	        <td>
	        	<input name="_id" value="${dto._id}" readonly="readonly"></td>
	        <td>${dto.name}</td>
	        <td>
	        	<input name="content" value="${dto.content}"></td>
	        <td>${dto.weather}</td>
	        <td>${dto.date}</td>
	    </tr>
	    <tr>
	    	<td colspan="5" align="center" >
	    		<button>수정하기</button>
	    	</td>
	    </tr>
</table>
</form>
<a href="delete.memo?_id=${dto._id}">
	<button>삭제하기</button>
</a>