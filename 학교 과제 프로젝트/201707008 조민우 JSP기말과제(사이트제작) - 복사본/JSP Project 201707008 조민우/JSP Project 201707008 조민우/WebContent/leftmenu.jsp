<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#btn1{
	width:180px;
	height:30px;
	right:20;
	bottom:20;
	
}
</style>
</head>
<body>
<jsp:include page = "myselfview.jsp"/>
<div>
	<button id="btn1" onclick = "location.href='index.jsp?target=myself'">자기소개 수정하기</button>
</div>
</body>
</html>