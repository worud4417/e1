<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
게시글을 수정했습니다.
<br>
<a href="${ctxPath=pageContext.request.contextPath}/list.do">[게시글목록보기]</a>
<a href="${ctxPath}/read.do?no=${modReq.articleNumber}">[게시글내용보가]</a>
</body>
</html>