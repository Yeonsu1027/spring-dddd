<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
	<header>
		<h1>이미지 갤러리 2024</h1>
		<p>Image Gallery 2024 Summer</p>
	</header>
	<a href="${rootPath}/insert">이미지 업로드</a>
  </body>
</html>
