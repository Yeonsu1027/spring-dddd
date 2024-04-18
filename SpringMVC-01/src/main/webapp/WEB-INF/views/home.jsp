<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>
<!DOCTYPE html>
<html>
	<!-- 이 위치에 head 를 include 하라 / main-layout 의 name -->
	<tiles:insertAttribute name="head"/>
 	<body>
 	<tiles:insertAttribute name="header"/>
 	<tiles:insertAttribute name="nav"/>
 	<tiles:insertAttribute name="content"/>
 	</body>
</html>
