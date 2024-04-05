<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
	<%@ include file="/WEB-INF/views/includes/head.jspf" %>
	<style>
		table.w3-table-all {
			width: 70%;
			margin: 10px auto;
			tr:hover {
				cursor:pointer;
			}
		}
		div.btn_box {
			display:block;
			width: 70%;
			margin: 5px auto;
			text-align: right;
			padding:0;
			
		}
	</style>
		<script>
	// JS 파일을 Link 하여 사용할 경우
	// JSP 에서 선언된 ${rootPath}는 사용할 수 없다
	// JS 파일을 Link 하기 전에 var 키워드를 사용하여
	// 모든 JS 에서 사용할 수 있도록 변수를 선언해 둔다.
		const rootPath = "${rootPath}"
	</script>
	<script src="${rootPath}/static/js/product.js?2024-03-29-004"></script>
  <body>
	<%@ include file="/WEB-INF/views/includes/header.jspf" %>
	<div class="w3-container btn_box">
		<a href="${rootPath}/insert" class="w3-button w3-green w3-round-large">거래추가</a>
	</div>
	<div class="w3-container w3-padding-24 w3-center">
		<table class="w3-table-all w3-striped w3-hoverable">
			<thead>
				<tr>
					<th>No</th>
					<th>일자</th>
					<th>시각</th>
					<th>상품명</th>
					<th>구분</th>
					 <c:choose>
	                    <c:when test="${PRODUCT_LIST[0].io_input eq 1}">
	                        <th>매입단가</th>
	                        <th>매출단가</th>
	                    </c:when>
	                    <c:when test="${PRODUCT_LIST[0].io_input eq 2}">
	                        <th>매출단가</th>
	                        <th>매입단가</th>
	                    </c:when>
	                    <c:otherwise>
	                        <th>매입단가</th>
	                        <th>매출단가</th>
	                    </c:otherwise>
	                </c:choose>
	                <th>수량</th>
	                <th>매입합계</th>
	                <th>매출합계</th>
				</tr>
			</thead>
			<tbody class="product_body">
				<c:forEach items="${PRODUCT_LIST}" var="PRODUCT" varStatus="VAR">
					<tr data-seq="${PRODUCT.io_seq}">
						<td>${PRODUCT.io_seq}</td>
						<td>${PRODUCT.io_date}</td>
						<td>${PRODUCT.io_time}</td>
						<td>${PRODUCT.io_pname}</td>
						<td>
			                <c:choose>
			                    <c:when test="${PRODUCT.io_input eq 1}">
			                        매입
			                    </c:when>
			                    <c:when test="${PRODUCT.io_input eq 2}">
			                        매출
			                    </c:when>
			                    <c:otherwise>
			                        기타
			                    </c:otherwise>
			                </c:choose>
			            </td>
	                    <td>${PRODUCT.io_input eq 1 ? PRODUCT.io_price : 0}</td>
	                    <td>${PRODUCT.io_input eq 2 ? PRODUCT.io_price : 0}</td>
						<td>${PRODUCT.io_quan}</td>
						<td>${PRODUCT.io_input eq 1 ? PRODUCT.io_total : 0}</td>
                    	<td>${PRODUCT.io_input eq 2 ? PRODUCT.io_total : 0}</td>
					</tr>
				</c:forEach>
				<tr>
					<td>총 합계</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				    <td>${totalPurchase}</td>
				    <td>${totalSales}</td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>