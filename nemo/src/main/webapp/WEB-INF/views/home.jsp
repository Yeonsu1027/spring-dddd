<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네모네모 드로잉</title>
<style>
div.view {
    display: flex;
}

div.row {
	display : flex;
}
.nemo {
    width: 60px;
    height: 60px;
    border: 1px solid black;
    cursor: pointer;
  	margin: 1px;
    -webkit-appearance: none; 
    -moz-appearance: none;
    appearance: none;
}

.p_data_1 {
background-color: black;
}

/* 체크 박스가 체크되었을 때의 스타일 */
/* .nemo:checked {
    background-color: black;
} */
.nemo:hover {
  cursor: pointer;
  background-color: #ccc;
  opacity: 0.7;
}

.hidden {
    display: none;
}
.alist {
    display: none;
}
.complete {
  border-radius: 15px;
  border: none;
  background-color: rgb(116, 176, 229);
  color: white;
  font-weight: 700;
  width: 200px;
  padding: 10px;
  margin-top: 20px;
  text-decoration: none;
  display: inline-block;
  text-align: center;
}

.complete:hover {
  cursor: pointer;
  opacity: 0.7;
}


.eraser{
    transition: 0.6s;
}
.eraser:hover{
opacity: 0.5;
cursor: pointer;
}

.game_menu {
    border: 3px solid black;
    border-radius: 10px;
    margin-left : 20px
}

</style>
</head>
<body>
	<h1>Lv.1 웃는얼굴</h1>
	<img src="${rootPath}/static/images/crayon.png" alt="crayon" width="80px" class="crayon">
	<div class="view">
		<div class="game">
			<form action="/hello/" method="post">
				<div class="row row1">
				    <input class="nemo ${row1Data.p_block1 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block1"  value="1"/>
				    <input class="nemo ${row1Data.p_block2 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block2"  value="1"/>
				    <input class="nemo ${row1Data.p_block3 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block3" value="1"/>
				    <input class="nemo ${row1Data.p_block4 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block4"  value="1"/>
				    <input class="nemo ${row1Data.p_block5 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block5"  value="1"/>
				    <input class="hidden" name="p_num" value="1"/>
				    <input class="hidden" name="p_row_num" value="1"/>
				    <button class="hidden" type="submit">저장</button>
				</div>
			</form>
			<form action="/hello/" method="post">
			    <div class="row row2">
				    <input class="nemo ${row2Data.p_block1 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block1"  value="1"/>
				    <input class="nemo ${row2Data.p_block2 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block2"  value="1"/>
				    <input class="nemo ${row2Data.p_block3 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block3" value="1"/>
				    <input class="nemo ${row2Data.p_block4 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block4"  value="1"/>
				    <input class="nemo ${row2Data.p_block5 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block5"  value="1"/>
				    <input class="hidden" name="p_num" value="1"/>
				    <input class="hidden" name="p_row_num" value="2"/>
				    <button class="hidden" type="submit">저장</button>
				 </div>
			</form>
			<form action="/hello/" method="post">
			    <div class="row row3">
				    <input class="nemo ${row3Data.p_block1 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block1"  value="1"/>
				    <input class="nemo ${row3Data.p_block2 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block2"  value="1"/>
				    <input class="nemo ${row3Data.p_block3 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block3" value="1"/>
				    <input class="nemo ${row3Data.p_block4 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block4"  value="1"/>
				    <input class="nemo ${row3Data.p_block5 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block5"  value="1"/>
				    <input class="hidden" name="p_num" value="1"/>
				    <input class="hidden" name="p_row_num" value="3"/>
				    <button class="hidden" type="submit">저장</button>
				  </div>
			</form>
			<form action="/hello/" method="post">
			    <div class="row row4">
				    <input class="nemo ${row4Data.p_block1 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block1"  value="1"/>
				    <input class="nemo ${row4Data.p_block2 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block2"  value="1"/>
				    <input class="nemo ${row4Data.p_block3 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block3" value="1"/>
				    <input class="nemo ${row4Data.p_block4 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block4"  value="1"/>
				    <input class="nemo ${row4Data.p_block5 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block5"  value="1"/>
				    <input class="hidden" name="p_num" value="1"/>
				    <input class="hidden" name="p_row_num" value="4"/>
				    <button class="hidden" type="submit">저장</button>
				  </div>
			</form>
			<form action="/hello/" method="post">
			    <div class="row row5">
				    <input class="nemo ${row5Data.p_block1 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block1"  value="1"/>
				    <input class="nemo ${row5Data.p_block2 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block2"  value="1"/>
				    <input class="nemo ${row5Data.p_block3 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block3" value="1"/>
				    <input class="nemo ${row5Data.p_block4 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block4"  value="1"/>
				    <input class="nemo ${row5Data.p_block5 == 1 ? 'p_data_1' : ''}" type="checkbox" name="p_block5"  value="1"/>
				    <input class="hidden" name="p_num" value="1"/>
				    <input class="hidden" name="p_row_num" value="5"/>
				    <button class="hidden" type="submit">저장</button>
				 </div>
			</form>
		</div>
		<section class="game_menu">
			<a href="${rootPath}/reset/1/5?p_num=1&row=5"><img class="eraser" src="${rootPath}/static/images/eraser.png" width="100px"/></a>
		</section>
	</div>
	<a class="complete" href="${rootPath}/correct_check/1/5?p_num=1&row=5">다그렸다!</a>
	<c:if test="${not empty wrongMessage}">
        <div>${wrongMessage}</div>
        <a class="complete" href="${rootPath}/">되돌아가기</a>
    </c:if>
    <!-- 정답 알림 -->
    <c:if test="${not empty clearMessage}">
        <div>${clearMessage}</div>
    </c:if>
	<script>
		document.addEventListener('DOMContentLoaded',() => {

		  const inputs = document.querySelectorAll('input.nemo');
	

		  inputs.forEach((input) => {
		    input.addEventListener('click', ()=> {

		    	const form = input.closest('form');
		      

		    	const button = form.querySelector('button[type="submit"]');
		      

		      button.click();
		    });
		  });
		  
		 /*  const complete_btn = document.querySelector("button.complete")
		  
		  complete_btn.addEventListener('click', ()=> {
			  
		  } */
		  
		  
		  
		});

	</script>
</body>
</html> 