<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 내장객체 (implicit)
		request, response, session, application, out, pageContext
	--%>
<%
	out.equals(pageContext.getOut());
	request.equals(pageContext);
	response.equals(response);
	session.equals(pageContext.getPage());
	
%>
	out.equals(pageContext.getOut():<%= out.equals(pageContext.getOut())%><br/>
	request.equals(pageContext)):<%= request.equals(pageContext.getRequest())%><br/>
	response.equals(response): <%= response.equals(pageContext.getResponse()) %><br/>
	session.equals(pageContext)   :<%= session.equals(pageContext.getSession()) %><br/>
	page.equals(pageContext.getPage()) : <%= page.equals(pageContext.getPage()) %><br/>
	application.equals(pageContext.getServletContext()) :<%= application.equals(pageContext.getServletContext()) %>
</body>
</html>