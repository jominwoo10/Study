<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Integer count = (Integer)application.getAttribute("count");
Integer newco = null;

if (count==null){
	application.setAttribute("count",1);
} else{
	if(session.isNew()){
		newco = count +1;
		pageContext.setAttribute("count",newco);
	}
}
%>
<h5>방문자 수 : <%= application.getAttribute("count") %><h5>
</body>
</html>