<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    margin: 5px;
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

</style>
</head>
<body>
	<form action="/hello" method="post">
	    <div class="row row1">
	        <input class="nemo" type="checkbox" name="p_block1" id="1" value="1"/>
	        <input class="nemo" type="checkbox" name="p_block2" id="2" value="1"/>
	        <input class="nemo" type="checkbox" name="p_block3" id="3" value="1"/>
	        <input class="nemo" type="checkbox" name="p_block4" id="4" value="1"/>
	        <input class="nemo" type="checkbox" name="p_block5" id="5" value="1"/>
	        <input class="hidden" name="p_num" value="1"/>
	        <input class="hidden" name="p_row_num" value="1"/>
	        <button type="submit">저장</button>
		   </div>
	</form>
</body>
</html>
