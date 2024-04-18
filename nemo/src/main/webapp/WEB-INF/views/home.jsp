<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

.hidden {
    display: none;
}
.alist {
    display: none;
}

</style>
</head>
<body>
	<h1>1: 웃는얼굴</h1>
	<c:forEach var="item" items="${answer}">
		<div class="alist">
		    <p>${item.n_block1}</p>
		    <p>${item.n_block2}</p>
		    <p>${item.n_block3}</p>
		    <p>${item.n_block4}</p>
		    <p>${item.n_block5}</p>
		</div>
	</c:forEach>
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
	<button class="">다그렸다!</button>
	<script>
		// JavaScript 코드
		document.addEventListener('DOMContentLoaded',() => {
		  // 모든 input 요소를 선택
		  var inputs = document.querySelectorAll('input.nemo');
	
		  // 각 input 요소에 클릭 이벤트 추가
		  inputs.forEach((input) => {
		    input.addEventListener('click', ()=> {
		      // 해당 input 요소의 부모 폼을 찾음
		      var form = input.closest('form');
		      
		      // 부모 폼 안에 있는 버튼을 찾음
		      var button = form.querySelector('button[type="submit"]');
		      
		      // 찾은 버튼을 클릭하여 폼을 제출
		      button.click();
		    });
		  });
		});

	</script>
</body>
</html> 