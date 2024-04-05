<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
	<style>
		div.hidden {
			display : none;
		}
	</style>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>상품추가</title>
</head>
<body>
	<div class="form">
		<form method="post" class="input">
			<fieldset>
			<legend>상품등록</legend>
				<div><label>상품명</label><input  name="io_pname" value="${PRODUCT.io_pname}"/></div>
				<div><label>단가</label><input  name="io_price" value="${PRODUCT.io_price}"/></div>
				<div><label>구분</label><input placeholder="1매입 2매출" name="io_input" value="${PRODUCT.io_input}"/></div>
				<div><label>수량</label><input  name="io_quan" value="${PRODUCT.io_quan}"/></div>
				<div><label></label><input type="submit" value="저장"/></div>
			</fieldset>
		</form>
	</div>
</body>
</html>