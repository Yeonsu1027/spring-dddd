<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<a href="${rootPath}/">게임화면</a>
<h1 class="h1h1h1">css적용확인용</h1>

<div class="HM-home_container">
	<div class="HM-home_top">
		<div class="HM-home_first_menu">
			<div class="HM-home_weather">
				<label> <span>날씨</span></label>
			</div>

			<div class="HM-home_img">
				<img src="${rootPath}/static/images/sun.png"> <img
					src="${rootPath}/static/images/cloud.png"> <img
					src="${rootPath}/static/images/rainy.png"> <img
					src="${rootPath}/static/images/snow.png">
			</div>
			<div>
				<label class="HM-home_cal"> <span>${YEAR} 년</span> <span>${MONTH}
						월</span> <span>${DAY} 일</span>
				</label>
			</div>
		</div>
		<div class="HM-home_second_menu">
			<label>제목 : 수족관을 다녀왔다!</label>
		</div>
	</div>
	<div class="HM-home_picture">
		<c:if test="${clear_data5.c_clear != 1}">
			<div>
				<div id="LEVEL3" class="YS_p_div">
					<c:if test="${clear_data3.c_clear == 1}">
						<img class="YS_picture_c"
							src="${rootPath}/static/images/jellyfish.png">
					</c:if>
					<c:if test="${clear_data3.c_clear != 1}">
						<img
							class="YS_picture
    					<c:if test="${clear_data1.c_clear == 1 && clear_data2.c_clear == 1 && clear_data4.c_clear != 1}">next_level</c:if>"
							src="${rootPath}/static/images/question.png" alt="Question Image">
					</c:if>
				</div>
				<div id="LEVEL1" class="YS_p_div">
					<c:if test="${clear_data1.c_clear == 1}">
						<img class="YS_picture_c"
							src="${rootPath}/static/images/smile.png" alt="Smile Image">
					</c:if>
					<c:if test="${clear_data1.c_clear != 1}">
						<img
							class="YS_picture
    					<c:if test="${clear_data2.c_clear != 1 && clear_data3.c_clear != 1 && clear_data4.c_clear != 1}">next_level</c:if>"
							src="${rootPath}/static/images/question.png" alt="Question Image">
					</c:if>
				</div>
			</div>
			<div>
				<div id="LEVEL4" class="YS_p_div">
					<c:if test="${clear_data4.c_clear == 1}">
						<img class="YS_picture_c"
							src="${rootPath}/static/images/whale.png" >
					</c:if>
					<c:if test="${clear_data4.c_clear != 1}">
						<img
							class="YS_picture
    					<c:if test="${clear_data1.c_clear == 1 && clear_data2.c_clear == 1 && clear_data3.c_clear == 1}">next_level</c:if>"
							src="${rootPath}/static/images/question.png" alt="Question Image">
					</c:if>
				</div>
				<div id="LEVEL2" class="YS_p_div">
					<c:if test="${clear_data2.c_clear == 1}">
						<img class="YS_picture_c"
							src="${rootPath}/static/images/fish.png">
					</c:if>
					<c:if test="${clear_data2.c_clear != 1}">
						<img
							class="YS_picture
    					<c:if test="${clear_data1.c_clear == 1 && clear_data3.c_clear != 1 && clear_data4.c_clear != 1}">next_level</c:if>"
							src="${rootPath}/static/images/question.png" alt="Question Image">
					</c:if>
				</div>
			</div>
		</c:if>
		<c:if test="${clear_data5.c_clear == 1}">
			<div id="LEVEL5">
				<img class="YS_picture" src="${rootPath}/static/images/five.png">
			</div>
		</c:if>
	</div>
	<div class="HM-home_diary">
		<c:if test="${clear_data1.c_clear == 1}">
			<h2 class="YS_diary_row">어제 수족관에 놀러갔었다!</h2>
		</c:if>
		<c:if test="${clear_data1.c_clear != 1}">
			<h2 class="YS_diary_row_n">　</h2>
		</c:if>
		<c:if test="${clear_data2.c_clear == 1}">
			<h2 class="YS_diary_row">작고 귀여운 흰 동가리도 보고</h2>
		</c:if>
		<c:if test="${clear_data2.c_clear != 1}">
			<h2 class="YS_diary_row_n">　</h2>
		</c:if>
		<c:if test="${clear_data3.c_clear == 1}">
			<h2 class="YS_diary_row">알록달록한 조명빛을 받는 해파리와</h2>
		</c:if>
		<c:if test="${clear_data3.c_clear != 1}">
			<h2 class="YS_diary_row_n">　</h2>
		</c:if>
		<c:if test="${clear_data4.c_clear == 1}">
			<h2 class="YS_diary_row">멋진 흰돌고래를 보고</h2>
		</c:if>
		<c:if test="${clear_data4.c_clear != 1}">
			<h2 class="YS_diary_row_n">　</h2>
		</c:if>
		<c:if test="${clear_data5.c_clear == 1}">
			<h2 class="YS_diary_row">엄청 커다란 문어를 만났다!</h2>
			<h2 class="YS_diary_row">참 재밌었다!</h2>
		</c:if>
		<c:if test="${clear_data5.c_clear != 1}">
			<h2 class="YS_diary_row_n">　</h2>
		</c:if>
	</div>
</div>