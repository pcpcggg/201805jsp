<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td { border: 1px solid #ddd; padding: 10px;}
</style>

</head>

<%
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:hh:mm");
%>
<body>
	hello, world
	<br />
	
	<% for(int i=0; i < 10; i++){ %>
		<br/> test : <%=sdf.format(date)%>
	<%} %>
	<br/>
	<br/>
	<table>
	<% for(int i=1; i < 10; i++){ %>
		<tr>
			<%for(int j=2; j < 10; j++){ %>
				<td> <%= j+" * "+i+" = "+i*j %></td>
			<%} %>
		</tr>
	<%} %>
	</table>
</body>
</html>