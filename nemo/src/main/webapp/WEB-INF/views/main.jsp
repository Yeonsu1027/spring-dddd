<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<a href="${rootPath}/">게임화면</a>
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
						<img class="YS_picture_c
						<c:if test="${clear_data1.c_clear == 1 && clear_data2.c_clear == 1&& clear_data3.c_clear == 1 && clear_data4.c_clear != 1}">fade-in</c:if>"
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
						<img class="YS_picture_c
						<c:if test="${clear_data1.c_clear == 1 && clear_data2.c_clear != 1&& clear_data3.c_clear != 1 && clear_data4.c_clear != 1}">fade-in</c:if>"
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
						<img class="YS_picture_c
						<c:if test="${clear_data1.c_clear == 1 && clear_data2.c_clear == 1&& clear_data3.c_clear == 1 && clear_data4.c_clear == 1}">fade-in</c:if>"
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
						<img class="YS_picture_c
						<c:if test="${clear_data1.c_clear == 1 && clear_data2.c_clear == 1&& clear_data3.c_clear != 1 && clear_data4.c_clear != 1}">fade-in</c:if>"
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
				<img class="YS_picture fade-in" src="${rootPath}/static/images/octopus.png">
			</div>
		</c:if>
		<section class="ex-mark hidden">
			<img src="${rootPath}/static/images/ex-mark.png" alt="느낌표" width="100%"/>
		</section>
		
	</div>
	<div class="HM-home_diary">
		<c:if test="${clear_data1.c_clear == 1}">
			<section class="YS_border-bottom">
				<h2 class="YS_diary_row
				<c:if test="${clear_data1.c_clear == 1 && clear_data2.c_clear != 1&& clear_data3.c_clear != 1 && clear_data4.c_clear != 1}">fade-in</c:if>"
				>어제 수족관에 놀러갔었다!</h2>
			</section>	
		</c:if>
		<c:if test="${clear_data1.c_clear != 1}">
			<section class="YS_border-bottom">
				<h2 class="YS_diary_row_n">　</h2>
			</section>
		</c:if>
		<c:if test="${clear_data2.c_clear == 1}">
			<section class="YS_border-bottom">
				<h2 class="YS_diary_row
				<c:if test="${clear_data1.c_clear == 1 && clear_data2.c_clear == 1&& clear_data3.c_clear != 1 && clear_data4.c_clear != 1}">fade-in</c:if>"
				>작고 귀여운 흰 동가리도 보고</h2>
			</section>
		</c:if>
		<c:if test="${clear_data2.c_clear != 1}">
			<section class="YS_border-bottom">
				<h2 class="YS_diary_row_n">　</h2>
			</section>
		</c:if>
		<c:if test="${clear_data3.c_clear == 1}">
			<section class="YS_border-bottom">		
				<h2 class="YS_diary_row
				<c:if test="${clear_data1.c_clear == 1 && clear_data2.c_clear == 1&& clear_data3.c_clear == 1 && clear_data4.c_clear != 1}">fade-in</c:if>"
				>알록달록한 조명빛을 받는 해파리와</h2>
			</section>
		</c:if>
		<c:if test="${clear_data3.c_clear != 1}">
			<section class="YS_border-bottom">
				<h2 class="YS_diary_row_n">　</h2>
			</section>
		</c:if>
		<c:if test="${clear_data4.c_clear == 1}">
			<section class="YS_border-bottom">
				<h2 class="YS_diary_row
				<c:if test="${clear_data1.c_clear == 1 && clear_data2.c_clear == 1&& clear_data3.c_clear == 1 && clear_data4.c_clear == 1}">fade-in</c:if>"
				>멋진 흰돌고래를 보고</h2>
			</section>
		</c:if>
		<c:if test="${clear_data4.c_clear != 1}">
			<section class="YS_border-bottom">
				<h2 class="YS_diary_row_n">　</h2>
			</section>
		</c:if>
		<c:if test="${clear_data5.c_clear == 1}">
			<section class="YS_border-bottom">		
				<h2 class="YS_diary_row">엄청 커다란 문어를 만났다!</h2>
			</section>
			<section class="YS_border-bottom">
				<h2 class="YS_diary_row">참 재밌었다!</h2>
			</section>
		</c:if>
		<c:if test="${clear_data5.c_clear != 1}">
			<section class="YS_border-bottom">
				<h2 class="YS_diary_row_n">　</h2>
			</section>
		</c:if>
	</div>
</div>
<script>
/* document.addEventListener("DOMContentLoaded", () => {
	  // LEVEL4의 fade-in 애니메이션 종료 후 처리
	  document
	    .getElementById("LEVEL4")
	    .addEventListener("animationend", () => {
	      // YS_picture_c 클래스를 가진 모든 이미지에 next_level 클래스 추가
	      // 완성그림에다가 클래스붙여서 깜빡이는효과
	      var images = document.querySelectorAll(".YS_picture_c");
	      images.forEach((image) =>{
	        image.classList.add("next_level5");
	      });
	    });
	}); */
	//---------------------------------------------
	// 4까지 클리어하고 나서 이미지클릭시 ! 이미지 나오게
document.addEventListener("DOMContentLoaded", () => {
    // LEVEL4의 fade-in 애니메이션 종료 후 처리
    document.getElementById("LEVEL4").addEventListener("animationend", () => {
        // YS_picture_c 클래스를 가진 모든 이미지에 next_level 클래스 추가
        // 완성그림에다가 클래스붙여서 깜빡이는효과
        const images = document.querySelectorAll(".YS_picture_c");
        images.forEach((image) => {
            image.classList.add("next_level5");
            image.addEventListener("click", () => {
                const exMark = document.querySelector(".ex-mark");
                exMark.classList.remove("hidden");
            });
        });
    });
});


	

</script>