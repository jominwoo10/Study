<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="java.sql.*" %>
    <% request.setCharacterEncoding("UTF-8"); %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자기소개 쓰기</title>
</head>
<body>
<%
	Class.forName("com.mysql.jdbc.Driver");

	String url = "jdbc:mysql://localhost:3306/jspproject?useUnicode=yes&characterEncoding=UTF-8";
	String id = "root";
	String pass = "jsp2021";	
	
	String memo = request.getParameter("memo"); //myself.jsp에서 memo에 입력한 데이터값

	
	try {	
		Connection conn = DriverManager.getConnection(url,id,pass);
		
		String sql = "UPDATE myself SET message = ? WHERE num = 1";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, memo);
		
		pstmt.execute();
		pstmt.close();
		
		conn.close();
} catch(SQLException e) {
	out.println( e.toString() );
	} 

%>
<script language=javascript>
   self.window.alert("입력한 글을 저장하였습니다.");
   location.href="index.jsp"; 
</script>

</body>
</html>