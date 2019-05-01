<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World!</title>
</head>
<body>
<h1>Hello People!</h1>
<c:if test="${empty userLogin}">
	<form action="login.do">
		<p>ID : <input type="text" size="20" name="id"></p>
		<p>PASSWORD : <input type="password" size="20" name="password"></p>
		<input type="submit" value="제출">
	</form>
	<br/>
	<button><a href="join.do">회원가입</a></button>
</c:if>
<c:if test="${!empty userLogin }">
	
</c:if>
</body>
</html>