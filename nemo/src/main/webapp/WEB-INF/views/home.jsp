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

.row {
    display: flex;
}
</style>
</head>
<body>
    <form action="/hello">
    	<div class="row">
 			<input class="nemo" type="checkbox" name="p_block1" value="1"/>
 			<input class="nemo" type="checkbox" name="p_block2" value="1"/>
 			<input class="nemo" type="checkbox" name="p_block3" value="1"/>
 			<input class="nemo" type="checkbox" name="p_block4" value="1"/>
 			<input class="nemo" type="checkbox" name="p_block5" value="1"/>
 		</div>	
        <button type="submit">저장</button>
    </form>
</body>
</html>
