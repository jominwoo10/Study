<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="java.sql.*" %>
    <% request.setCharacterEncoding("UTF-8"); %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<%
	Class.forName("com.mysql.jdbc.Driver");

	String url = "jdbc:mysql://localhost:3306/jspproject?useUnicode=yes&characterEncoding=UTF-8";
	String id = "root";
	String pass = "jsp2021";	
	
	String name = request.getParameter("name");
	String idd = request.getParameter("idd");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	
	try {	
		Connection conn = DriverManager.getConnection(url,id,pass);
		
		String sql = "INSERT INTO userinfo(name,id,password,email) VALUES(?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, name);
		pstmt.setString(2, idd);
		pstmt.setString(3, password);
		pstmt.setString(4, email);
		
		pstmt.execute();
		pstmt.close();
		
		conn.close();
} catch(SQLException e) {
	out.println( e.toString() );
	} 

%>
<script language=javascript>
   self.window.alert("회원가입이 완료되었습니다.");
   location.href="index.jsp"; 
</script>

</body>
</html>