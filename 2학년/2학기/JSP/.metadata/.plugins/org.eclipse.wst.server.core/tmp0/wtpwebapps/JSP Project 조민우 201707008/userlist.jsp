<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="java.sql.*" %>
    <% request.setCharacterEncoding("UTF-8"); %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 리스트</title>
</head>
<body>
<%
	Class.forName("com.mysql.jdbc.Driver");

	String url = "jdbc:mysql://localhost:3306/jspproject?useUnicode=yes&characterEncoding=UTF-8";
	String id = "root";
	String pass = "jsp2021";	
	
	try {	
		Connection conn = DriverManager.getConnection(url,id,pass);
		
		String sql = "select * from userinfo";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		
		%>
		<h1 align="center">회원 List</h1>
		<table border="1" align="center">
		<tr>
			<td>이름</td>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이메일</td>
		</tr>
		<%while(rs.next()){
		%><tr>
			<td><%=rs.getString("name")%></td>
			<td><%=rs.getString("id")%></td>
			<td><%=rs.getString("password")%></td>
			<td><%=rs.getString("email")%></td>
		</tr>
		
		<%
		}%>
        	<tr align="center">
                <td colspan="4">
            	    <input type="button" style="border-left: none;"value="홈으로" onClick="location.href='index.jsp'">
                </td>
            </tr> 
		</table>
		<%
		pstmt.execute();
		pstmt.close();
		
		conn.close();

} catch(SQLException e) {
	out.println( e.toString() );
	} 

%>

</body>
</html>