<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/includes/head.jspf" %>
<style>
	div.w3-card-4 {
		width: 50%;
		margin: 20px auto;
	}
	div.w3-section input {
		border-radius: 15px;
	}
	div.w3-container {
		border: 3px solid green;
		margin-top: 30px;
	}
	div.j {
		display : flex;
		text-align: center;
		align-items: center;
		justify-content: center;
		}
	div.j p {
		margin: 15px;
	}
</style>
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/product.js"></script>
<body>
	<%@ include file="/WEB-INF/views/includes/header.jspf" %>
	<main class="w3-container">
		<div class="w3_card-4">
			<div class="w3-container w3-center">
				<h3>${PRODUCT.io_pname}</h3>
				<div class="j">
					<p>거래일</p>
					<h5>${PRODUCT.io_date}</h5>
					<p>거래시각</p>
					<h5>${PRODUCT.io_time}</h5>
				</div>
				<div class="j">
					<p>단가</p>
					<h5>${PRODUCT.io_price}</h5>
					<p>수량</p>
					<h5>${PRODUCT.io_quan}</h5>
				</div>
				<h4>거래액</h4>
				<h5>${PRODUCT.io_total}</h5>
				<div class="w3-section">
					<input data-seq="${PRODUCT.io_seq}" 
						type="button" value="수정" class="btn_update w3-button w3-blue"/>
					<input data-seq="${PRODUCT.io_seq}" 
						type="button" value="삭제" class="btn_delete w3-button w3-red"/>
				</div>
			</div>
		</div>
	</main>

</body>
</html>