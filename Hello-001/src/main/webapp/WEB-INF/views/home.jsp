<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!-- (set 변수선언) >>이 페이지<<에선 저주소를 rootPath 라는 변수에 쓰겠다. -->	
	<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<!-- /hello/static/css/main.css -->
<!-- css?002 : 보통 ?앞까지만 url ?뒤 무시 / tomcat 속이기 -->
<link href="${rootPath}/static/css/main.css?007" rel="stylesheet">
</head>
<body>
	<header class="main">
		<h1>반갑습니다</h1>
	</header>
	<nav class="main">
		<ul>
			<li><a href="/">Home</a></li>
			<li><a href="/notice">공지사항</a></li>
			<li><a href="/bbs">자유게시판</a></li>
			<li><a href="${rootPath}/user/login">로그인</a></li>
			<li><a href="${rootPath}/user/join">회원가입</a></li>
		</ul>
	</nav>
</body>
</html>
