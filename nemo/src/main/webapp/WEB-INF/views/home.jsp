<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.nemo {
	width: 60px;
	height: 60px;
	border: 1px solid black;
	cursor: pointer;
	margin: 5px;
}

.row {
	display: flex;
}
</style>
</head>
<body>
	<form id="myForm" action="/saveGameData" method="post">
	<div name="p_id" value="USER1"></div>
    <div class="nemo_table" name="p_num" value="1">
        <div class="row r1" name="p_row_num" value="1">
            <section class="nemo n1" name="p_block1" data-value="0" onclick="toggleValue('block1')"></section>
            <section class="nemo n2" name="p_block2" data-value="0" onclick="toggleValue('block2')"></section>
            <section class="nemo n3" name="p_block3" data-value="0" onclick="toggleValue('block3')"></section>
            <section class="nemo n4" name="p_block4" data-value="0" onclick="toggleValue('block4')"></section>
            <section class="nemo n5" name="p_block5" data-value="0" onclick="toggleValue('block5')"></section>
        </div>
        <div class="row r2" name="p_row_num" value="2">
            <section class="nemo n1" name="p_block1" data-value="0" onclick="toggleValue('block6')"></section>
            <section class="nemo n2" name="p_block2" data-value="0" onclick="toggleValue('block7')"></section>
            <section class="nemo n3" name="p_block3" data-value="0" onclick="toggleValue('block8')"></section>
            <section class="nemo n4" name="p_block4" data-value="0" onclick="toggleValue('block9')"></section>
            <section class="nemo n5" name="p_block5" data-value="0" onclick="toggleValue('block10')"></section>
        </div>
        <div class="row r3" name="p_row_num" value="3">
            <section class="nemo n1" name="p_block1" data-value="0" onclick="toggleValue('block11')"></section>
            <section class="nemo n2" name="p_block2" data-value="0" onclick="toggleValue('block12')"></section>
            <section class="nemo n3" name="p_block3" data-value="0" onclick="toggleValue('block13')"></section>
            <section class="nemo n4" name="p_block4" data-value="0" onclick="toggleValue('block14')"></section>
            <section class="nemo n5" name="p_block5" data-value="0" onclick="toggleValue('block15')"></section>
        </div>
        <div class="row r4" name="p_row_num" value="4">
            <section class="nemo n1" name="p_block1" data-value="0" onclick="toggleValue('block16')"></section>
            <section class="nemo n2" name="p_block2" data-value="0" onclick="toggleValue('block17')"></section>
            <section class="nemo n3" name="p_block3" data-value="0" onclick="toggleValue('block18')"></section>
            <section class="nemo n4" name="p_block4" data-value="0" onclick="toggleValue('block19')"></section>
            <section class="nemo n5" name="p_block5" data-value="0" onclick="toggleValue('block20')"></section>
        </div>
        <div class="row r5" name="p_row_num" value="5">
            <section class="nemo n1" name="p_block1" data-value="0" onclick="toggleValue('block21')"></section>
            <section class="nemo n2" name="p_block2" data-value="0" onclick="toggleValue('block22')"></section>
            <section class="nemo n3" name="p_block3" data-value="0" onclick="toggleValue('block23')"></section>
            <section class="nemo n4" name="p_block4" data-value="0" onclick="toggleValue('block24')"></section>
            <section class="nemo n5" name="p_block5" data-value="0" onclick="toggleValue('block25')"></section>
        </div>
    </div>
    <button type="submit">저장</button>
</form>

<script>
function toggleValue(name) {
    var element = document.querySelector('section[name="' + name + '"]');
    if (element.dataset.value === '0') {
        element.dataset.value = '1';
        element.style.backgroundColor = 'black'; 
    } else {
        element.dataset.value = '0';
        element.style.backgroundColor = 'initial'; // 원래 색깔로 돌아오게
    }
}
</script>
</body>
</html>