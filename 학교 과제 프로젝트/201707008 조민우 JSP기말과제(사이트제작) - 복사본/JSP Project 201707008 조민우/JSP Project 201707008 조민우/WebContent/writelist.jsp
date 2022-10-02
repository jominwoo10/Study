<%@page import="javax.security.auth.callback.ConfirmationCallback"%>

	<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
	<%@ page import="java.io.PrintWriter"%>
	<%@ page import="bbs.BbsDAO"%>
	<%@ page import="bbs.Bbs"%>
	<%@ page import="java.util.ArrayList"%>
	 <%@ page import ="java.sql.*" %>
    <% request.setCharacterEncoding("UTF-8"); %> 
	<!DOCTYPE html>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- 뷰포트 -->
	<meta name="viewport" content="width=device-width" initial-scale="1">
	<!-- 스타일시트 참조  -->
	<link rel="stylesheet" href="css/bootstrap.css">
	<title>방명록 보기</title>
	<style type="text/css">
		a, a:hover {
			color: #000000;
			text-decoration: none;
		}
	</style>
	</head>
	<body>
	<%
	ResultSet rs = null;
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/jspproject?useUnicode=yes&characterEncoding=UTF-8";
	String id = "root";
	String pass = "jsp2021";	
	int num = 0;
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String time = null;;
	Bbs bbs = new Bbs();
	PreparedStatement pstmt = null;
	try {	
		Connection conn = DriverManager.getConnection(url,id,pass);
		
		String sql = "SELECT num,title,content,time FROM write_content";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();

} catch(SQLException e) {
	out.println( e.toString() );
	} 
%>
		<%
			int pageNumber = 1; //기본 페이지 넘버
			//페이지넘버값이 있을때
			if (request.getParameter("pageNumber") != null) {
				pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
			}
		%>
		<!-- 네비게이션  -->
		<nav class="navbar navbar-default">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="bs-example-navbar-collapse-1"
					aria-expaned="false">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand">미니홈피 방명록</a>
			</div>
			<div class="collapse navbar-collapse"
				id="#bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">메뉴<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="index.jsp">홈</a></li>
							<li><a href="write.jsp">방명록 쓰기</a></li>
						</ul></li>
				</ul>
			</div>
		</nav>
		<!-- 게시판 -->
		<div class="container">
			<div class="row">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th style="background-color: #eeeeee; text-align: center;">번호</th>
							<th style="background-color: #eeeeee; text-align: center;">제목</th>
							<th style="background-color: #eeeeee; text-align: center;">내용</th>
							<th style="background-color: #eeeeee; text-align: center;">작성일</th>
						</tr>
					</thead>
					<tbody>
						<tr><%
							while(rs.next()){%>
							<td><%=num = rs.getInt(1) %></td>
							<td><%=title= rs.getString(2) %></td>
							<td><%=content = rs.getString(3) %></td>
							<td><%=time = rs.getString(4)%></td>
						</tr>
						<%} %>
					</tbody>
				</table>

			</div>
		</div>
		<!-- 애니매이션 담당 JQUERY -->
		<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
		<!-- 부트스트랩 JS  -->
		<script src="js/bootstrap.js"></script>
	</body>
	</html>