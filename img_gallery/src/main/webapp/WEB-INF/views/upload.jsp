<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<form method="post" enctype="multipart/form-data">
		<input placeholder="id" name="g_id"/>
		<input type="email" placeholder="이메일" name="g_email"/>
		<input placeholder="비밀번호" name="g_password"/>
		<input type="file" class="file single"
                name="image_file"
                accept="image/*"/>
        <button>업로드</button>
	</form>

</body>
</html>