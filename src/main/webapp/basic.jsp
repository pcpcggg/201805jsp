<%@page import="kr.or.ddit.user.UserVo"%>
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
</head>
<!-- 스크립틀릿 <% %>  : 자바 코드 작성 -->
<!-- 표현식 <%= %> : 출력을 표현 -->
<%
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:hh:mm"); 
	
	%>
	
<body>
	hello, world<br/>
	
	
	<%= sdf.format(date) %>
	
	<% UserVo userVo = (UserVo)session.getAttribute("userVo"); 
		//session.setMaxInactiveInterval(interval);
	%>
	<%= userVo.getName()+ "[" +  userVo.getAlias()+ "]" %>]
	
</body>
</html>