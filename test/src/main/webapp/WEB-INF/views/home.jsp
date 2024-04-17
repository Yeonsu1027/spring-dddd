<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
	<h1>test</h1>
	<c:forEach var="item" items="${testlist}">
	    <p>${item.t_num}</p>
	    <p>${item.t_num2}</p>
	</c:forEach>
	<form action="/hello" method="post">
	    <label for="t_num">t_num:</label>
	    <input type="text" id="t_num" name="t_num"><br><br>
	    <label for="t_num2">t_num2:</label>
	    <input type="text" id="t_num2" name="t_num2"><br><br>
	    <button type="submit">저장</button>
	</form>
  </body>
</html>
