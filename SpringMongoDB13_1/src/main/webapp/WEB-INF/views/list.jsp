<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL(Java Standard Tag Library) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<table border="1" width="800px">
    <tr bgcolor="lime">
        <th>번호</th>
        <th>작성자</th>
        <th>내용</th>
        <th>날씨</th>
        <th>날짜</th>
    </tr>
    <c:forEach items="${list}" var="dto" varStatus="status">
	    <tr bgcolor="pink">
	        <td>${status.count}</td>
	        <td>${dto.name}</td>
	        <td>
	       		<a href="one.memo?_id=${dto._id}">${dto.content}</a>
	        </td>
	        <td>${dto.weather}</td>
	        <td>${dto.date}</td>
	    </tr>
    </c:forEach>
</table>