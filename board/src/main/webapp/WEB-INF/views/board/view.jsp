<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>게시물 조회</title>
</head>
	<body>
	<div id="nav">
		<%@ include file="../include/nav.jsp" %>
	</div>
		<label>제목</label>
		${view.title}<br />
		
		<hr />
		
		<label>작성자</label>
		${view.writer}<br />
		
		<hr />
		
		<label>내용</label><br />
		${view.content}<br />
		
		<hr />
		
		<div>
			<a href="/board/modify?bno=${view.bno}">게시물 수정</a>, <a href="/board/delete?bno=${view.bno}">게시물 삭제</a>
		</div>
	</body>
</html>