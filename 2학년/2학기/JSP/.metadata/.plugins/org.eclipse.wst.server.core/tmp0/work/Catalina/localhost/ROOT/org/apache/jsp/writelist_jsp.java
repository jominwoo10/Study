/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.70
 * Generated at: 2021-12-18 21:32:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.security.auth.callback.ConfirmationCallback;
import java.io.PrintWriter;
import bbs.BbsDAO;
import bbs.Bbs;
import java.util.ArrayList;
import java.sql.*;

public final class writelist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.io.PrintWriter");
    _jspx_imports_classes.add("bbs.Bbs");
    _jspx_imports_classes.add("bbs.BbsDAO");
    _jspx_imports_classes.add("javax.security.auth.callback.ConfirmationCallback");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	 \r\n");
      out.write("    ");
 request.setCharacterEncoding("UTF-8"); 
      out.write(" \r\n");
      out.write("	<!DOCTYPE html>\r\n");
      out.write("	<html>\r\n");
      out.write("	<head>\r\n");
      out.write("	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("	<!-- ????????? -->\r\n");
      out.write("	<meta name=\"viewport\" content=\"width=device-width\" initial-scale=\"1\">\r\n");
      out.write("	<!-- ??????????????? ??????  -->\r\n");
      out.write("	<link rel=\"stylesheet\" href=\"css/bootstrap.css\">\r\n");
      out.write("	<title>????????? ??????</title>\r\n");
      out.write("	<style type=\"text/css\">\r\n");
      out.write("		a, a:hover {\r\n");
      out.write("			color: #000000;\r\n");
      out.write("			text-decoration: none;\r\n");
      out.write("		}\r\n");
      out.write("	</style>\r\n");
      out.write("	</head>\r\n");
      out.write("	<body>\r\n");
      out.write("	");

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

      out.write("\r\n");
      out.write("		");

			int pageNumber = 1; //?????? ????????? ??????
			//????????????????????? ?????????
			if (request.getParameter("pageNumber") != null) {
				pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
			}
		
      out.write("\r\n");
      out.write("		<!-- ???????????????  -->\r\n");
      out.write("		<nav class=\"navbar navbar-default\">\r\n");
      out.write("			<div class=\"navbar-header\">\r\n");
      out.write("				<button type=\"button\" class=\"navbar-toggle collapsed\"\r\n");
      out.write("					data-toggle=\"collapse\" data-target=\"bs-example-navbar-collapse-1\"\r\n");
      out.write("					aria-expaned=\"false\">\r\n");
      out.write("					<span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span\r\n");
      out.write("						class=\"icon-bar\"></span>\r\n");
      out.write("				</button>\r\n");
      out.write("				<a class=\"navbar-brand\">???????????? ?????????</a>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"collapse navbar-collapse\"\r\n");
      out.write("				id=\"#bs-example-navbar-collapse-1\">\r\n");
      out.write("				<ul class=\"nav navbar-nav\">\r\n");
      out.write("				</ul>\r\n");
      out.write("				<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("					<li class=\"dropdown\"><a href=\"#\" class=\"dropdown-toggle\"\r\n");
      out.write("						data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\"\r\n");
      out.write("						aria-expanded=\"false\">??????<span class=\"caret\"></span></a>\r\n");
      out.write("						<ul class=\"dropdown-menu\">\r\n");
      out.write("							<li><a href=\"index.jsp\">???</a></li>\r\n");
      out.write("							<li><a href=\"write.jsp\">????????? ??????</a></li>\r\n");
      out.write("						</ul></li>\r\n");
      out.write("				</ul>\r\n");
      out.write("			</div>\r\n");
      out.write("		</nav>\r\n");
      out.write("		<!-- ????????? -->\r\n");
      out.write("		<div class=\"container\">\r\n");
      out.write("			<div class=\"row\">\r\n");
      out.write("				<table class=\"table table-striped\"\r\n");
      out.write("					style=\"text-align: center; border: 1px solid #dddddd\">\r\n");
      out.write("					<thead>\r\n");
      out.write("						<tr>\r\n");
      out.write("							<th style=\"background-color: #eeeeee; text-align: center;\">??????</th>\r\n");
      out.write("							<th style=\"background-color: #eeeeee; text-align: center;\">??????</th>\r\n");
      out.write("							<th style=\"background-color: #eeeeee; text-align: center;\">??????</th>\r\n");
      out.write("							<th style=\"background-color: #eeeeee; text-align: center;\">?????????</th>\r\n");
      out.write("						</tr>\r\n");
      out.write("					</thead>\r\n");
      out.write("					<tbody>\r\n");
      out.write("						<tr>");

							while(rs.next()){
      out.write("\r\n");
      out.write("							<td>");
      out.print(num = rs.getInt(1) );
      out.write("</td>\r\n");
      out.write("							<td>");
      out.print(title= rs.getString(2) );
      out.write("</td>\r\n");
      out.write("							<td>");
      out.print(content = rs.getString(3) );
      out.write("</td>\r\n");
      out.write("							<td>");
      out.print(time = rs.getString(4));
      out.write("</td>\r\n");
      out.write("						</tr>\r\n");
      out.write("						");
} 
      out.write("\r\n");
      out.write("					</tbody>\r\n");
      out.write("				</table>\r\n");
      out.write("\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<!-- ??????????????? ?????? JQUERY -->\r\n");
      out.write("		<script src=\"https://code.jquery.com/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("		<!-- ??????????????? JS  -->\r\n");
      out.write("		<script src=\"js/bootstrap.js\"></script>\r\n");
      out.write("	</body>\r\n");
      out.write("	</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
