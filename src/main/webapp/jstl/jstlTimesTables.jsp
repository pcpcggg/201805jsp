<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {border-spacing: 15px;}
	td { border: 1px solid #ddd; padding: 10px;}
	td:nth-chid(odd){
		background: f00;
	}
</style>

</head>

<%
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:hh:mm");
%>
<body>
	hello, world
	<br />
	

	<c:forEach begin="0" end="10">
		<br/> test : <%=sdf.format(date)%>
	</c:forEach>
	
	<br/>
	<br/>
	<table>
		<c:forEach begin="1" end="9" var="i">
			<tr>
				<c:forEach begin="2" end="9" var="j">
					<td> ${j} * ${i} = ${i * j}</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>