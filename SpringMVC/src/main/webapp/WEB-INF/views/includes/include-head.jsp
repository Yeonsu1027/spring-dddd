<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>나의 홈페이지</title>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

header{
display:flex;
align-items:center;
padding:15px;
}
header div {
margin-left:auto;
margin-right:15px;
}
nav ul{
padding:10px;
display:flex;
background-color: black;
}

nav ul li {
color:yellow;
list-style:none;
margin: 5px 10px;
}
</style>
</head>