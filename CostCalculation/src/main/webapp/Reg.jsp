<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dropdown List Example</title>
</head>
<body>
	<h2>İş Seçiniz:</h2>
	<select>
		<c:forEach var="item" items="${items}">
			<option value="${item.id}">${item.name}</option>
		</c:forEach>
	</select>
</body>
</html>
