<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네모네모 드로잉</title>
<style>
div.row {
	display : flex;
}
.nemo {
    width: 60px;
    height: 60px;
    border: 1px solid black;
    cursor: pointer;
  	margin: -1px;
    -webkit-appearance: none; 
    -moz-appearance: none;
    appearance: none;
}

/* 체크 박스가 체크되었을 때의 스타일 */
.nemo:checked {
    background-color: black;
}
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

</style>
</head>
<body>
	<h1>1: 웃는얼굴</h1>
	<form action="/hello/" method="post">
	    <div class="row row1">
	        <input class="nemo" type="checkbox" name="p_block1" id="1" value="1"/>
	        <input class="nemo" type="checkbox" name="p_block2" id="2" value="1"/>
	        <input class="nemo" type="checkbox" name="p_block3" id="3" value="1"/>
	        <input class="nemo" type="checkbox" name="p_block4" id="4" value="1"/>
	        <input class="nemo" type="checkbox" name="p_block5" id="5" value="1"/>
	        <input class="hidden" name="p_num" value="1"/>
	        <input class="hidden" name="p_row_num" value="1"/>
	        <button class="hidden" type="submit">저장</button>
		   </div>
	</form>
	<form action="/hello/" method="post">
	    <div class="row row1">
	        <input class="nemo" type="checkbox" name="p_block1" id="1" value="1"/>
	        <input class="nemo" type="checkbox" name="p_block2" id="2" value="1"/>
	        <input class="nemo" type="checkbox" name="p_block3" id="3" value="1"/>
	        <input class="nemo" type="checkbox" name="p_block4" id="4" value="1"/>
	        <input class="nemo" type="checkbox" name="p_block5" id="5" value="1"/>
	        <input class="hidden" name="p_num" value="1"/>
	        <input class="hidden" name="p_row_num" value="2"/>
	        <button class="hidden" type="submit">저장</button>
		   </div>
	</form>
	<form action="/hello/" method="post">
	    <div class="row row1">
	        <input class="nemo" type="checkbox" name="p_block1" id="1" value="1"/>
	        <input class="nemo" type="checkbox" name="p_block2" id="2" value="1"/>
	        <input class="nemo" type="checkbox" name="p_block3" id="3" value="1"/>
	        <input class="nemo" type="checkbox" name="p_block4" id="4" value="1"/>
	        <input class="nemo" type="checkbox" name="p_block5" id="5" value="1"/>
	        <input class="hidden" name="p_num" value="1"/>
	        <input class="hidden" name="p_row_num" value="3"/>
	        <button class="hidden" type="submit">저장</button>
		   </div>
	</form>
	<form action="/hello/" method="post">
	    <div class="row row1">
	        <input class="nemo" type="checkbox" name="p_block1" id="1" value="1"/>
	        <input class="nemo" type="checkbox" name="p_block2" id="2" value="1"/>
	        <input class="nemo" type="checkbox" name="p_block3" id="3" value="1"/>
	        <input class="nemo" type="checkbox" name="p_block4" id="4" value="1"/>
	        <input class="nemo" type="checkbox" name="p_block5" id="5" value="1"/>
	        <input class="hidden" name="p_num" value="1"/>
	        <input class="hidden" name="p_row_num" value="4"/>
	        <button class="hidden" type="submit">저장</button>
		   </div>
	</form>
	<form action="/hello/" method="post">
	    <div class="row row1">
	        <input class="nemo" type="checkbox" name="p_block1" id="1" value="1"/>
	        <input class="nemo" type="checkbox" name="p_block2" id="2" value="1"/>
	        <input class="nemo" type="checkbox" name="p_block3" id="3" value="1"/>
	        <input class="nemo" type="checkbox" name="p_block4" id="4" value="1"/>
	        <input class="nemo" type="checkbox" name="p_block5" id="5" value="1"/>
	        <input class="hidden" name="p_num" value="1"/>
	        <input class="hidden" name="p_row_num" value="5"/>
	        <button class="hidden" type="submit">저장</button>
		   </div>
	</form>
	<a class="complete" href="${rootPath}/correct_check/1/5?p_num=1&row=5">다그렸다!</a>
	<c:if test="${not empty wrongMessage}">
        <div>${wrongMessage}</div>
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